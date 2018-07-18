package party.hc.zrnews.UI;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Comment;

import party.hc.zrnews.R;
import party.hc.zrnews.bean.MicroArticleBean;
import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.tools.Tools;

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
    public void init(final NewsBean microArticleBean){
        LayoutInflater.from(getContext()).inflate(R.layout.micro_article_header,this,true);
        ImageView headPic=(ImageView)findViewById(R.id.imageView);
        TextView userName=(TextView)findViewById(R.id.textView);
        final TextView content=(TextView)findViewById(R.id.textView5);
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        userName.setText(microArticleBean.getAuthor());
       // content.setText(Html.fromHtml("#一起去看世界杯#世界杯决赛赛后，法国总统马克龙去到了克罗地亚更衣室，和莫德里奇的孩子的这一幕也是很有爱了。"));
        content.setText(microArticleBean.getTitle());
        ImageView img=new ImageView(getContext());
        Glide.with(getContext()).load(microArticleBean.getThumbnail()).into(img);
        gridLayout.setColumnCount(2);//3 or 2
        gridLayout.addView(img,0);
        final Button Share=(Button)findViewById(R.id.button8);
        Button comment=(Button)findViewById(R.id.button7);
        final Button isGood=(Button)findViewById(R.id.button6);
        Share.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.share(getContext(),"",microArticleBean.getUrl());
            }
        });

        isGood.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                isGood.setEnabled(false);
            }
        });
//        ImageView img2=new ImageView(getContext());
//        Glide.with(getContext()).load(microArticleBean.getThumbnail()).into(img);
//        gridLayout.addView(img2,1);
    }
}
