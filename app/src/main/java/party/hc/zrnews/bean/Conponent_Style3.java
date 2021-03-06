package party.hc.zrnews.bean;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import party.hc.zrnews.R;

public class Conponent_Style3 extends RelativeLayout{

    public Conponent_Style3(Context context, AttributeSet attrs, String title, String pic1) {

        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.conponent_style3, this);

        // 获取控件
        TextView CS3_textview = findViewById(R.id.CS3_title);
        ImageView CS3_pic = findViewById(R.id.CS3_pic);

        CS3_textview.setText(title);

        Glide.with(getContext()).load(pic1).into(CS3_pic);
    }
}