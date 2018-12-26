package moera.ermais.google.com.tanuki;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import moera.ermais.google.com.tanuki.entity.request.Agent;
import moera.ermais.google.com.tanuki.entity.request.Data;
import moera.ermais.google.com.tanuki.entity.request.DeliveryAddress;
import moera.ermais.google.com.tanuki.entity.request.Header;
import moera.ermais.google.com.tanuki.entity.request.Method;
import moera.ermais.google.com.tanuki.entity.request.OrderItem;
import moera.ermais.google.com.tanuki.entity.request.Request;
import moera.ermais.google.com.tanuki.entity.request.Sender;
import moera.ermais.google.com.tanuki.entity.response.Reply;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.orderTV)
    TextView mOrderTV;
    @BindView(R.id.nameET)
    EditText mNameET;
    @BindView(R.id.emailET)
    EditText mEmailET;
    @BindView(R.id.phoneET)
    EditText mPhoneET;
    @BindView(R.id.streetET)
    EditText mStreetET;
    @BindView(R.id.houseET)
    EditText mHouseET;
    @BindView(R.id.flatET)
    EditText mFlatET;
    @BindView(R.id.payType)
    Spinner mPayTypeS;
    @BindView(R.id.commentET)
    EditText mCommentET;
    @BindView(R.id.countPersonsET)
    EditText mCountPersonET;
    @BindView(R.id.countItemsET)
    EditText mCountItemsET;
    @BindView(R.id.addButton)
    Button mSave;
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final int ORDER_LOADER_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String[] payTypes = {getString(R.string.payment_card_restaurant), getString(R.string.payment_encash)};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, payTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPayTypeS.setAdapter(adapter);

        isValidPhoneOrEmail(mEmailET.getText(), Patterns.EMAIL_ADDRESS);
        isValidPhoneOrEmail(mPhoneET.getText(), Patterns.PHONE);
        mSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (validForm()) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://api.dev2.tanuki.ru/")
                            .addConverterFactory(GsonConverterFactory.create())

                            .build();
                    API api = retrofit.create(API.class);
                    String request = generateRequest();
                    RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), request);


                    Call<Reply> call = api.reply(body);
                    call.enqueue(new Callback<Reply>() {
                                     @Override
                                     public void onResponse(Call<Reply> call, Response<Reply> response) {
                                         GsonBuilder builder = new GsonBuilder();
                                         Gson gson = builder.create();
                                         String result = "jsonData=" + gson.toJson(response.body());
                                         Log.i(TAG, result);
//                                         Log.d(TAG, response.body().));

                                     }

                                     @Override
                                     public void onFailure(Call<Reply> call, Throwable t) {
                                         Log.d(TAG, "err: " + t.getMessage());
                                     }
                                 }

                    );
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder((MainActivity.this));
                    builder.setMessage(R.string.dialog_message)
                            .setTitle(R.string.dialog_title);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

    }

    private String generateRequest() {
        Data data = new Data();
        data.setDateToDeliver("20180824164119");
        data.setDeliveryType("deliveryTypeRegular");
        data.setNotificationType("СМС оповещение");
        data.setComments(mCommentET.getText().toString());
        data.setPersons(Integer.parseInt(mCountPersonET.getText().toString()));
        Map<String, String> typeOfPaymentMethod = new HashMap<>();
        typeOfPaymentMethod.put("Наличными", "payment_encash");
        typeOfPaymentMethod.put("Картой курьеру", "payment_card_restaurant");
        data.setPaymentMethod(typeOfPaymentMethod.get(mPayTypeS.getSelectedItem().toString()));
        Log.d("MAIN_ACTIVITY", mPayTypeS.getSelectedItem().toString() + typeOfPaymentMethod.get(mPayTypeS.getSelectedItem().toString()));
        OrderItem orderItem = new OrderItem();
        orderItem.setAmount(Integer.parseInt(mCountItemsET.getText().toString()));
        orderItem.setItemId("9");
        orderItem.setPrice(110);
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem); //TODO always alone???
        data.setOrderItems(orderItems);
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setStreet(mStreetET.getText().toString());
        deliveryAddress.setCityId("1");
        deliveryAddress.setHouse(mHouseET.getText().toString());
        deliveryAddress.setApartment(mFlatET.getText().toString());
        data.setDeliveryAddress(deliveryAddress);
        Sender sender = new Sender();
        sender.setName(mNameET.getText().toString());
        sender.setPhone(mPhoneET.getText().toString());
        data.setSender(sender);

        Header header = new Header();

        String android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
//        header.setUserId(android_id);
        header.setUserId("b1fd5271d981d1b7");// Если ставить уникальный id, то всегда возвращается ошибка Минимальная сумма заказа в Москве 1000 руб.
        Agent agent = new Agent();
        agent.setDevice("desktop");
        agent.setVersion("Chromium 68.0.3440.75");
        header.setAgent(agent);
        header.setDebugMode(true);
        header.setVersion("2.0");

        Method method = new Method();
        method.setMode("getData");
        method.setMtime(0);
        method.setName("makeOrder");

        Request request = new Request();
        request.setMethod(method);
        request.setHeader(header);
        request.setData(data);


        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String result = "jsonData=" + gson.toJson(request);
        Log.i("GSON", result);
        return result;

    }

    public static boolean isValidPhoneOrEmail(CharSequence target, Pattern pattern) {
        return !TextUtils.isEmpty(target) && pattern.matcher(target).matches();
    }

    boolean validForm() {
        boolean formIsValid = true;
        if (!isValidPhoneOrEmail(mEmailET.getText(), Patterns.EMAIL_ADDRESS)) {
            mEmailET.setError("Enter valid email");
            formIsValid = false;
        }

        if (!isValidPhoneOrEmail(mPhoneET.getText(), Patterns.PHONE)) {
            mPhoneET.setError("Enter valid phone");
            formIsValid = false;
        }

        boolean isCountPersonCorrect = !TextUtils.isEmpty(mCountPersonET.getText()) &&
                Integer.parseInt(mCountPersonET.getText().toString()) <= 10;
        if (!isCountPersonCorrect) {
            mCountPersonET.setError("Персон должно быть меньше 10");
            formIsValid = false;
        }

        boolean isCountItemCorrect = !TextUtils.isEmpty(mCountItemsET.getText()) &&
                Integer.parseInt(mCountItemsET.getText().toString()) > 0;
        if (!isCountItemCorrect) {
            mCountItemsET.setError("Количество товаров должно быть больше 0");
            formIsValid = false;
        }

        return formIsValid;
    }
//
//    @NonNull
//    @Override
//    public Loader<Reply> onCreateLoader(int id, @Nullable Bundle args) {
//        Log.d(TAG, "I in LOAD1");
//        return new AsyncTaskLoader<Reply>(this) {
//
//            @Override
//            protected void onStartLoading() {
//
//                forceLoad();
//            }
//
//
//            @Nullable
//            @Override
//            public Reply loadInBackground() {
//                Log.d(TAG, "I in LOAD");
//                Map<String, Object> information = new TreeMap<>();
//                information.put("Context", getApplicationContext());
//                URL url = NetworkUtils.buildUrl(information);
//                Reply reply = new Reply();
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(getResources().getString(R.string.url_tanuki))
//                        .build();
//
//                API api = retrofit.create(API.class);
//
//                try {
//
//
//                    String jsonMoviesResponse = NetworkUtils
//                            .getResponseFromHttpUrl(url);
//                    Log.d(TAG, "I in LOAD"+jsonMoviesResponse);
//
//                    GsonBuilder builder = new GsonBuilder();
//                    Gson gson = builder.create();
//                    reply = gson.fromJson(jsonMoviesResponse, Reply.class);
//
//                } catch (Exception e) {
//                    Log.e("Error fetching movies data", e.getMessage());
//                }
//                return reply;
//            }
//
//            public void deliverResult(Reply data) {
////                mMovieData = data;
//                super.deliverResult(data);
//            }
//        };
//    }
//
//    @Override
//    public void onLoadFinished(@NonNull Loader<Reply> loader, Reply data) {
//
//    }
//
//    @Override
//    public void onLoaderReset(@NonNull Loader<Reply> loader) {
//
//    }
}
