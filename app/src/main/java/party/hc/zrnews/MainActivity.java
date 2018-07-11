package party.hc.zrnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import party.hc.zrnews.bean.NewsBean;

public class MainActivity extends AppCompatActivity {
    private ArrayList<NewsBean> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView) findViewById(R.id.listView1);
         newsList=new ArrayList<>();
        initData();
        listView.setAdapter(new NewsAdapter(this,newsList));
    }
    private void  initData(){
        for(int i=0;i<100;i++){

            newsList.add(new NewsBean("nihao"+i));
        }

    }

}
