package moera.ermais.google.com.tanuki;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import moera.ermais.google.com.tanuki.entity.request.Request;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.orderInfoTV)
    TextView mOrderInfoTV;
    @BindView(R.id.orderNumberTV)
    TextView mOrderNumberTV;
    @BindView(R.id.returnB)
    Button mReturnB;


    @BindView(R.id.nameInfoTV)
    TextView nameInfoTV;
    @BindView(R.id.nameTV)
    TextView nameTV;

    @BindView(R.id.phoneInfoTV)
    TextView phoneInfoTV;
    @BindView(R.id.phoneTV)
    TextView phoneTV;

    @BindView(R.id.streetInfoTV)
    TextView streetInfoTV;
    @BindView(R.id.streetTV)
    TextView streetTV;

    @BindView(R.id.houseInfoTV)
    TextView houseInfoTV;
    @BindView(R.id.houseTV)
    TextView houseTV;

    @BindView(R.id.flatInfoTV)
    TextView flatInfoTV;
    @BindView(R.id.flatTV)
    TextView flatTV;

    @BindView(R.id.payTypeInfoTV)
    TextView payTypeInfoTV;
    @BindView(R.id.payTypeTV)
    TextView payTypeTV;

    @BindView(R.id.commentInfoTV)
    TextView commentInfoTV;
    @BindView(R.id.commentTV)
    TextView commentTV;

    @BindView(R.id.countPersonsInfoTV)
    TextView countPersonsInfoTV;
    @BindView(R.id.countPersonsTV)
    TextView countPersonsTV;

    @BindView(R.id.countItemsInfoTV)
    TextView countItemsInfoTV;
    @BindView(R.id.countItemsTV)
    TextView countItemsTV;


    private static final String TAG = DetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent orderNumber = getIntent();
        if (orderNumber != null) {
            int intValue = orderNumber.getIntExtra("orderNumber", 0);
            String request = orderNumber.getStringExtra("orderInfo");

            request = request.split("=")[1];
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Request request1 = gson.fromJson(request, Request.class);
            mOrderNumberTV.setText(String.format("%d", intValue));
            nameTV.setText(request1.getData().getSender().getName());
            phoneTV.setText(request1.getData().getSender().getPhone());
            streetTV.setText(request1.getData().getDeliveryAddress().getStreet());
            houseTV.setText(request1.getData().getDeliveryAddress().getHouse());
            flatTV.setText(request1.getData().getDeliveryAddress().getApartment());
            Map<String, String> typeOfPaymentMethod = new HashMap<>();
            typeOfPaymentMethod.put("payment_encash", "Наличными");
            typeOfPaymentMethod.put("payment_card_restaurant", "Картой курьеру");
            payTypeTV.setText(typeOfPaymentMethod.get(request1.getData().getPaymentMethod()));
            commentTV.setText(request1.getData().getComments());
            countPersonsTV.setText(String.format("%d",request1.getData().getPersons()));
            countItemsTV.setText(String.format("%d", request1.getData().getOrderItems().get(0).getAmount()));

        }

        mReturnB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Context context = getApplicationContext();
                Class destination = MainActivity.class;
                Intent intent = new Intent(context, destination);
                startActivity(intent);

            }
        });
    }
}
