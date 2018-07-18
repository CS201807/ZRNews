package party.hc.zrnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import party.hc.zrnews.DB.NewsCache;
import party.hc.zrnews.bean.Conponent_Style5;
import party.hc.zrnews.bean.Conponent_stylecollect;
import party.hc.zrnews.bean.HistoryBean;
import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.tools.SerializeUtils;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Button back= (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
       // ListView listView=(ListView) findViewById(R.id.listView);
        LinearLayout contentLayout=(LinearLayout)findViewById(R.id.content);

        NewsCache cache=new NewsCache(getApplicationContext());
        ArrayList<HistoryBean> newsList=new ArrayList<>();
        try {
            newsList= (ArrayList<HistoryBean>) SerializeUtils.serializeToObject(cache.getReadPageIndexByURL("addtoHistory"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        String bean=getIntent().getStringExtra("bean");
//        NewsBean bean1=new NewsBean();
//        try {
//            bean1= (NewsBean) SerializeUtils.serializeToObject(bean);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        final ArrayList<HistoryBean> finalNewsList = newsList;
        for(int i=newsList.size()-1;i>=0;i--) {
            Conponent_stylecollect view = new Conponent_stylecollect(getApplicationContext(), null,newsList.get(i).getTitle(),newsList.get(i).getThumbnail(),newsList.get(i).getSaveTime());
            final int finalI = i;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getApplicationContext(),UrlReadActivity.class);
                    intent.putExtra("url", finalNewsList.get(finalI).getUrl());
                    intent.putExtra("id", finalNewsList.get(finalI).getId());
                    try {
                        intent.putExtra("bean",SerializeUtils.serialize(finalNewsList.get(finalI)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    intent.putExtra("type","nojs");
                    intent.putExtra("his","nohis");
                    startActivity(intent);
                }
            });
            contentLayout.addView(view);
        }


    }
}
