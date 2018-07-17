package party.hc.zrnews.UI;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import party.hc.zrnews.R;
import party.hc.zrnews.bean.CommentBean;
import party.hc.zrnews.bean.MicroArticleBean;

/**
 * Created by ubuntu on 18-7-17.
 */

public class CommentLine extends LinearLayout {
    public CommentLine(Context context) {
        super(context);

    }

    public CommentLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public CommentLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public CommentLine(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }
    public void init(CommentBean commentBean){
        LayoutInflater.from(getContext()).inflate(R.layout.comment_line,this,true);
        ImageView headPic=(ImageView)findViewById(R.id.imageView);
        TextView userName=(TextView)findViewById(R.id.textView);
        TextView content=(TextView)findViewById(R.id.textView6);

        content.setText(commentBean.getComment());
        userName.setText(commentBean.getUserName());

       // ImageView img=new ImageView(getContext());
        //Glide.with(getContext()).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531722868602&di=f962795b5b62c69881714fdf107f1089&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F110917%2F1829-11091FZ02495.jpg").into(img);
    }
}
