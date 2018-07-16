package party.hc.zrnews.bean;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import party.hc.zrnews.R;

public class Conponent_Style5 extends RelativeLayout {

    public Conponent_Style5(Context context,NewsBean news, @Nullable AttributeSet attrs) {

        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.conponent_style5, this);

        // 获取控件
        TextView CS5_title = findViewById(R.id.CS5_title);
        TextView CS5_text1 = findViewById(R.id.CS5_text);
        //TextView CS5_text2 = findViewById(R.id.CS5_text2);
        ImageView CS5_pic = findViewById(R.id.CS5_pic);

        CS5_title.setText(news.getTitle());
        CS5_text1.setText(news.getAuthor()+" | "+news.getDate());
       // CS5_text2.setText(news.getDate());

        Glide.with(getContext()). load(news.getThumbnail()).into(CS5_pic);

    }
}
