package party.hc.zrnews;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import party.hc.zrnews.bean.UserBean;
import party.hc.zrnews.conn.Sign;
import party.hc.zrnews.tools.SerializeUtils;

public class EditInfoActivity extends AppCompatActivity {

    int year;
    int month;
    int day;
    Date date;
    String birthdata;
    String sex;
    String name;
    private Handler handler;
    UserBean ub=new UserBean();
    final Runnable keepData = new Runnable() {
        public void run() {
            try {
                Sign.UpdateUserInfo(ub,name,sex,birthdata);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        SharedPreferences preferences=getSharedPreferences("userdata",MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences("userdata", MODE_PRIVATE).edit();
        try {
            ub= (UserBean) SerializeUtils.serializeToObject(preferences.getString("bean",""));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RadioGroup rg= (RadioGroup) findViewById(R.id.r_g);
        switch (preferences.getString("sex","保密")){
            case "男":
                rg.check(R.id.rb_m);
                sex="男";
                break;
            case "女":
                rg.check(R.id.rb_w);
                sex="女";
                break;
            default:
                rg.check(R.id.rb_s);
                sex="保密";
                break;
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_m)
                {

                    sex="男";
                }
                else if(i==R.id.rb_w){

                    sex="女";
                }
                else {

                    sex="保密";
                }
            }
        });

        EditText username= (EditText) findViewById(R.id.edit_username);
        username.setText(preferences.getString("name","最热新闻"));


        Button back= (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("data_return",name);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


        Button password= (Button) findViewById(R.id.password);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditInfoActivity.this,PassWordActivity.class);
                startActivity(intent);
            }
        });
        Button save= (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("name",username.getText().toString());
                editor.putString("sex",sex);
                editor.putString("birthday",birthdata);
                editor.apply();
                name=username.getText().toString();
                new Thread(keepData).start();
                Toast.makeText(getApplicationContext(),"保存成功",Toast.LENGTH_SHORT).show();
            }
        });
        Button birth= findViewById(R.id.birth);

        TextView birthday= findViewById(R.id.birthday);
        birthday.setText(preferences.getString("birthday",""));
        birthdata=preferences.getString("birthday","");
//        SimpleDateFormat sdf = new SimpleDateFormat( " yyyy-MM-dd" );
//        try {
//            date=sdf.parse(preferences.getString("birthday",""));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        sdf =   new SimpleDateFormat( " yyyy年MM月dd日 " );
//        String s=sdf.format(date);
//        birthday.setText(s);
        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnDateSetListener listener=new OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        year=i;
                        month=i1;
                        day=i2;

                        birthdata=i+"-"+i1+"-"+i2;
                        birthday.setText(i+"-"+i1+"-"+i2);
                    }
                };
                DatePickerDialog dialog=new DatePickerDialog(EditInfoActivity.this, R.style.MyDatePickerDialogTheme,listener,year,month,day);
                dialog.show();
            }
        });
    }




}
