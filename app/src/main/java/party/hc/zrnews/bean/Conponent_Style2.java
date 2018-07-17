package party.hc.zrnews.bean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import party.hc.zrnews.R;

public class Conponent_Style2 extends RelativeLayout {

    public Conponent_Style2(Context context, AttributeSet attrs, String title, String pic1,String pic2, String pic3) {

        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.conponent_style2, this);

        // 获取控件
        TextView CS2_textview = findViewById(R.id.CS2_title);
        ImageView CS2_pic1 = findViewById(R.id.CS2_pic1);
        ImageView CS2_pic2 = findViewById(R.id.CS2_pic2);
        ImageView CS2_pic3 = findViewById(R.id.CS2_pic3);

        CS2_textview.setText(title);

        Glide.with(getContext()). load(pic1).into(CS2_pic1);
        Glide.with(getContext()). load(pic2).into(CS2_pic2);
        Glide.with(getContext()). load(pic3).into(CS2_pic3);

    }

    public Conponent_Style2(Context context, NewsBean data, AttributeSet attrs) {

        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.conponent_style2, this);

        // 获取控件
        TextView CS2_textview = findViewById(R.id.CS2_title);
        ImageView CS2_pic1 = findViewById(R.id.CS2_pic1);
        ImageView CS2_pic2 = findViewById(R.id.CS2_pic2);
        ImageView CS2_pic3 = findViewById(R.id.CS2_pic3);

        CS2_textview.setText(data.getTitle());

        Glide.with(getContext()). load(data.getThumbnail()).into(CS2_pic1);
        Glide.with(getContext()). load(data.getThumbnail1()).into(CS2_pic2);
        Glide.with(getContext()). load(data.getThumbnail2()).into(CS2_pic3);

    }

}
