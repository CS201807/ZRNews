package party.hc.zrnews;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.IOException;

import party.hc.zrnews.bean.UserBean;
import party.hc.zrnews.conn.Sign;
import party.hc.zrnews.tools.SerializeUtils;

public class LoginActivity extends AppCompatActivity {
    private EditText userNameTextView;
    private EditText passwrodTextView;
    private Button loginButton;
    private Button logupButton;
    private Handler handler;
    String account;
    String password;
    String result;
    SharedPreferences.Editor editor;
    UserBean ub=new UserBean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userNameTextView=(EditText) findViewById(R.id.login_account);
        passwrodTextView=(EditText)findViewById(R.id.login_password);
        logupButton=(Button)findViewById(R.id.button4);
        loginButton=(Button)findViewById(R.id.button5);
        handler=new Handler(){
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                        break;
                    default:
                            break;
                }
            }
        };
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account = userNameTextView.getText().toString();
                password=passwrodTextView.getText().toString();
                new Thread(signIn).start();
                }
        });
        logupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    final Runnable signIn = new Runnable() {
        public void run() {
            try {
                result = Sign.signIn(account, password, ub);
                if (result.equals("OK")) {
                    editor = getSharedPreferences("userdata", MODE_PRIVATE).edit();
                    editor.putString("name", ub.getName());
                    editor.putString("password", password);
                    editor.putString("avatar", ub.getAvatar());
                    editor.putString("account", account);
                    editor.putString("id", ub.getId());
                    editor.putString("phoneNum", ub.getPhone());
                    editor.putString("followers", ub.getFollowers());
                    editor.putString("focus", ub.getFocus());
                    editor.putBoolean("logged",true);
                    editor.putString("birthday",ub.getBirthday());
                    editor.putString("sex",ub.getSex());
                    try {
                        editor.putString("bean", SerializeUtils.serialize(ub));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };
}
