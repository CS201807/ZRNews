package party.hc.zrnews;

import android.os.Handler;
import android.os.Message;
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
    Handler handler;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userNameTextView=(EditText) findViewById(R.id.logon_username);
        passwrodTextView=(EditText)findViewById(R.id.logon_password);
        phoneNumberTextView=(EditText)findViewById(R.id.logon_account);
        logupButton=(Button)findViewById(R.id.sign_commit);
        handler=new Handler(){
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        };
        logupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Thread(signUp).start();

            }
        });
    }

    final Runnable signUp = new Runnable() {
        public void run() {
            try {
                String result;
                result=Sign.signUp(phoneNumberTextView.getText().toString(),passwrodTextView.getText().toString(),userNameTextView.getText().toString());
                if(result.equals("OK")){
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);
                    finish();
                }
                else {
                    Message message = new Message();
                    message.what = 2;
                    handler.sendMessage(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}
