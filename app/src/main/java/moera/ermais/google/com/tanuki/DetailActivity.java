package moera.ermais.google.com.tanuki;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.orderInfoTV)
    TextView mOrderInfoTV;
    @BindView(R.id.orderNumberTV)
    TextView mOrderNumberTV;
    @BindView(R.id.returnB)
    Button mReturnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent orderNumber = getIntent();
        if (orderNumber != null) {
            int intValue = orderNumber.getIntExtra("orderNumber", 0);
            mOrderNumberTV.setText(intValue);
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
