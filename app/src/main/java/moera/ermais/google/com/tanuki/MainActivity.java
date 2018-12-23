package moera.ermais.google.com.tanuki;

import android.os.Bundle;
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

import java.util.Calendar;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import moera.ermais.google.com.tanuki.entity.Agent;
import moera.ermais.google.com.tanuki.entity.Data;
import moera.ermais.google.com.tanuki.entity.DeliveryAddress;
import moera.ermais.google.com.tanuki.entity.Header;
import moera.ermais.google.com.tanuki.entity.Method;
import moera.ermais.google.com.tanuki.entity.OrderItem;
import moera.ermais.google.com.tanuki.entity.Request;
import moera.ermais.google.com.tanuki.entity.Sender;

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
                    String json = generateJson();



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

    private String generateJson(){
        Data data = new Data();
        data.setDateToDeliver("32323232");
        data.setComments(mCommentET.getText().toString());
        data.setPersons(Integer.parseInt(mCountPersonET.getText().toString()));
        data.setPaymentMethod(mPayTypeS.getSelectedItem().toString());
        OrderItem orderItem = new OrderItem();
        orderItem.setAmount(Integer.parseInt(mCountItemsET.getText().toString()));
        OrderItem [] orderItems = new OrderItem[1];
        orderItems[0]= orderItem; //TODO always alone???
        data.setOrderItems(orderItems);
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setStreet(mStreetET.getText().toString());
        deliveryAddress.setHouse(mHouseET.getText().toString());
        deliveryAddress.setApartment(mFlatET.getText().toString());
        data.setDeliveryAddress(deliveryAddress);
        Sender sender = new Sender();
        sender.setName(mNameET.getText().toString());
        sender.setPhone(mPhoneET.getText().toString());
        data.setSender(sender);

        Header header = new Header();
        header.setUserId("b1fd5271d981d1b7");
        Agent agent = new Agent();
        header.setAgent(agent);

        Method method = new Method();
        Request request = new Request();
        request.setMethod(method);
        request.setHeader(header);
        request.setData(data);



        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Log.i("GSON", gson.toJson(request));
        return gson.toJson(request);

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

}
