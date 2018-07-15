package party.hc.zrnews.bean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import party.hc.zrnews.R;

public class Conponent_Style4 extends RelativeLayout{

    private TextView CS4_title;
    private TextView CS4_text1;
    private TextView CS4_text2;
    private ImageView CS4_pic;
    private CheckBox CS4_checkbox;

    public Conponent_Style4(Context context, AttributeSet attrs, String title, String text1, String text2, String pic) {

        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.Conponent_Style2, this);

        // 获取控件
        CS4_title=findViewById(R.id.CS4_title);
        CS4_text1=findViewById(R.id.CS4_text1);
        CS4_text2=findViewById(R.id.CS4_text2);
        CS4_checkbox=findViewById(R.id.CS4_checkBox);
        CS4_pic=findViewById(R.id.CS4_pic);


        CS4_title.setText(title);
        CS4_text1.setText(text1);
        CS4_text2.setText(text2);

        Glide.with(getContext()). load(pic).into(CS4_pic);



    }

}
