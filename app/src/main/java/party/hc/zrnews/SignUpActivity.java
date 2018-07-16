package party.hc.zrnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        userNameTextView=(EditText) findViewById(R.id.editText2);
        passwrodTextView=(EditText)findViewById(R.id.editText3);
        fakeNameTextView=(EditText)findViewById(R.id.editText4);
        phoneNumberTextView=(EditText)findViewById(R.id.editText5);
        logupButton=(Button)findViewById(R.id.button4);
        logupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
