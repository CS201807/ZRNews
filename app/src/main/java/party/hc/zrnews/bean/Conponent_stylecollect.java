package party.hc.zrnews.bean;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import party.hc.zrnews.R;


public class Conponent_stylecollect extends RelativeLayout {

    public Conponent_stylecollect(Context context, AttributeSet attrs, String title, String pic, String collecttime) {

        super(context, attrs);


        LayoutInflater.from(context).inflate(R.layout.conponent_style_collect, this);

    // 获取控件
    TextView Csc_title = findViewById(R.id.CSc_title);
    TextView CSc_time = findViewById(R.id.CSc_time);
    ImageView CSc_pic = findViewById(R.id.CSc_pic);

        Csc_title.setText(title);
        CSc_time.setText(collecttime);

        Glide.with(getContext()). load(pic).into(CSc_pic);

    }

}
