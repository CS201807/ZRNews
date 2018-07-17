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
import party.hc.zrnews.bean.MicroArticleBean;
import party.hc.zrnews.bean.NewsBean;

/**
 * Created by ubuntu on 18-7-16.
 */

public class MicroArticle extends LinearLayout {

    public MicroArticle(Context context) {
        super(context);

    }

    public MicroArticle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public MicroArticle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public MicroArticle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }
    public void init(NewsBean microArticleBean){
        LayoutInflater.from(getContext()).inflate(R.layout.micro_article_header,this,true);
        ImageView headPic=(ImageView)findViewById(R.id.imageView);
        TextView userName=(TextView)findViewById(R.id.textView);
        TextView content=(TextView)findViewById(R.id.textView5);
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        userName.setText(microArticleBean.getAuthor());
       // content.setText(Html.fromHtml("#一起去看世界杯#世界杯决赛赛后，法国总统马克龙去到了克罗地亚更衣室，和莫德里奇的孩子的这一幕也是很有爱了。"));
        content.setText(microArticleBean.getTitle());
        ImageView img=new ImageView(getContext());
        Glide.with(getContext()).load(microArticleBean.getThumbnail()).into(img);
        gridLayout.setColumnCount(3);//3 or 2
        gridLayout.addView(img);
        ImageView img2=new ImageView(getContext());
       // Glide.with(getContext()).load("http://bq-img.peco.uodoo.com/columbus/2015/uctest/466577d74d078c1ff91ce6918bfb9f85.jpg;,75,webp;6,C-C,228x228,1").into(img);
       // gridLayout.addView(img2);
    }
}
