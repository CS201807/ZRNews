package party.hc.zrnews.bean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import party.hc.zrnews.R;

public class Conponent_Style1 extends RelativeLayout{

    public Conponent_Style1(Context context, AttributeSet attrs, String title, String pic,String text1,String text2) {

        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.conponent_style1, this);

        // 获取控件
        TextView CS1_title = findViewById(R.id.CS1_title);
        ImageView CS1_pic = findViewById(R.id.CS1_pic);
        TextView CS1_text =findViewById(R.id.CS1_text);

        CS1_title.setText(title);
        CS1_text.setText(text1+" | "+text2);

        Glide.with(getContext()). load(pic).into(CS1_pic);

    }
}
