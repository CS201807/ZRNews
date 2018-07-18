package party.hc.zrnews;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import party.hc.zrnews.UI.CircleTransform;

public class SelfInfoActivity extends AppCompatActivity {

    TextView name;
    SharedPreferences preferences;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){

            case 1:
                if(resultCode==RESULT_OK||resultCode==0){
                    name.setText(preferences.getString("name",""));
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_info);
        preferences=getSharedPreferences("userdata",MODE_PRIVATE);
        Picasso.get().load(preferences.getString("avatar", String.valueOf(R.drawable.h))).transform(new CircleTransform()).into((ImageView) findViewById(R.id.head_frg));
        Button back= (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("data_return","1");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        final Button edit= (Button) findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelfInfoActivity.this,EditInfoActivity.class);
                startActivityForResult(intent,1);
            }
        });

        name=findViewById(R.id.self_name);
        name.setText(preferences.getString("name","最热新闻"));
        TextView focus=findViewById(R.id.focus);
        focus.setText(preferences.getString("focus","0")+"关注");
        TextView followers=findViewById(R.id.followers);
        followers.setText(preferences.getString("focus","0")+"粉丝");

    }
}
