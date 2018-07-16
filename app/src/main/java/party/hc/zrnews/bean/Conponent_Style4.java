package party.hc.zrnews.bean;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import party.hc.zrnews.R;

@SuppressLint("ViewConstructor")
public class Conponent_Style4 extends RelativeLayout{

    public Conponent_Style4(Context context, AttributeSet attrs, String title, String text1, String text2, String pic) {

        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.conponent_style4, this);

        // 获取控件
        TextView CS4_title = findViewById(R.id.CS4_title);
        TextView CS4_text1 = findViewById(R.id.CS4_text1);
        TextView CS4_text2 = findViewById(R.id.CS4_text2);
        CheckBox CS4_checkbox = findViewById(R.id.CS4_checkBox);
        ImageView CS4_pic = findViewById(R.id.CS4_pic);


        CS4_title.setText(title);
        CS4_text1.setText(text1);
        CS4_text2.setText(text2);

        Glide.with(getContext()). load(pic).into(CS4_pic);



    }

}
