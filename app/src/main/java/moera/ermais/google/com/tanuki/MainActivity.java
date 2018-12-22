package moera.ermais.google.com.tanuki;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

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
//        boolean = mCountPersonET.getText()
        mSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (validForm()){

                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());

                    builder.setMessage(R.string.dialog_message)
                            .setTitle(R.string.dialog_title);

                    AlertDialog dialog = builder.create();
                }


            }
        });

    }

    public final static boolean isValidPhoneOrEmail(CharSequence target, Pattern pattern) {
        return !TextUtils.isEmpty(target) && pattern.matcher(target).matches();
    }

    boolean validForm() {
        boolean formIsValid = true;
        if (isValidPhoneOrEmail(mEmailET.getText(), Patterns.EMAIL_ADDRESS)) {
            mEmailET.setError("Enter valid email");
            formIsValid = false;
        }
        if (isValidPhoneOrEmail(mPhoneET.getText(), Patterns.PHONE)) {
            mPhoneET.setError("Enter valid phone");
            formIsValid = false;

        }
        int countPerson = Integer.parseInt(mCountPersonET.getText().toString());
        if (countPerson > 10) {
            mCountPersonET.setError("Персон должно быть меньшне 10");
            formIsValid = false;

        }
        int countItem = Integer.parseInt(mCountItemsET.getText().toString());
        if (countItem <= 0) {
            mCountItemsET.setError("Количество товаров должно быть больше 0");
            formIsValid = false;

        }

        return formIsValid;
    }

}
