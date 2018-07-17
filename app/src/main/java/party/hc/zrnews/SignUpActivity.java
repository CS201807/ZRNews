package party.hc.zrnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import party.hc.zrnews.conn.Sign;

public class SignUpActivity extends AppCompatActivity {
    private EditText userNameTextView;
    private EditText passwrodTextView;
    private EditText fakeNameTextView;
    private EditText phoneNumberTextView;
    private Button logupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userNameTextView=(EditText) findViewById(R.id.logon_account);
        passwrodTextView=(EditText)findViewById(R.id.logon_password);
        phoneNumberTextView=(EditText)findViewById(R.id.editText4);
        logupButton=(Button)findViewById(R.id.sign_commit);

        logupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(signUp).start();

            }
        });
    }

    Runnable signUp = new Runnable() {
        public void run() {
            try {
                String result;
                result=Sign.signUp(phoneNumberTextView.getText().toString(),passwrodTextView.getText().toString(),userNameTextView.getText().toString());
                if(result.equals("OK")){
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}
