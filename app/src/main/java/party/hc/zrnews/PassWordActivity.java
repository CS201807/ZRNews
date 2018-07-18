package party.hc.zrnews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import party.hc.zrnews.bean.UserBean;
import party.hc.zrnews.conn.Sign;
import party.hc.zrnews.conn.User;
import party.hc.zrnews.tools.SerializeUtils;

public class PassWordActivity extends AppCompatActivity {

    SharedPreferences.Editor editor;
    SharedPreferences preferences;
    UserBean ub;
    String pre;
    String nw;
    String dou;
    Boolean Json;
    final Runnable change = new Runnable() {
        public void run() {
            try {
                Json=Sign.UpdatePassword(ub,pre,nw);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word);
        preferences=getSharedPreferences("userdata",MODE_PRIVATE);
        editor = getSharedPreferences("userdata", MODE_PRIVATE).edit();

        TextView pre_pwd=findViewById(R.id.pre_pwd);
        TextView new_pwd=findViewById(R.id.new_pwd);
        TextView double_pwd=findViewById(R.id.double_pwd);
        ProgressBar progressBar=findViewById(R.id.pro);
        Button saveChange=findViewById(R.id.save_change);
        saveChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pre=pre_pwd.getText().toString();
                nw=new_pwd.getText().toString();
                dou=double_pwd.getText().toString();
                if(nw.equals(dou)){
                    try {
                        ub= (UserBean) SerializeUtils.serializeToObject(preferences.getString("bean",""));
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Thread thread = new Thread(change);
                    thread.start();
                    progressBar.setVisibility(View.VISIBLE);
                    
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progressBar.setVisibility(View.INVISIBLE);
                    if(Json){
                        editor.putString("password",nw);
                        editor.apply();
                        Toast.makeText(getApplicationContext(),"修改成功",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"密码错误",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getApplicationContext(),"两次密码输入不一致，请重新输入！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
