package party.hc.zrnews.bean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import party.hc.zrnews.R;

public class Conponent_Style5 extends RelativeLayout {

    public Conponent_Style5(Context context, AttributeSet attrs, String title, String text1, String text2, String pic) {

        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.conponent_style5, this);

        // 获取控件
        TextView CS5_title = findViewById(R.id.CS5_title);
        TextView CS5_text = findViewById(R.id.CS5_text);
        ImageView CS5_pic = findViewById(R.id.CS5_pic);

        CS5_title.setText(title);
        CS5_text.setText(text1+" | "+text2);


        Glide.with(getContext()). load(pic).into(CS5_pic);

    }
}
