package party.hc.zrnews.mainFragments.NewsPageFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import party.hc.zrnews.R;
import party.hc.zrnews.bean.NewsBean;

/**
 * Created by ubuntu on 18-7-13.
 */

public class NewsGeneralFragment extends NewsBFragment {
    private String title;
    private ArrayList<NewsBean> newsList;
    public NewsGeneralFragment(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.page_news_general,null);
        newsList=new ArrayList<>();
        initData();
        //listview
        ListView listView=(ListView) view.findViewById(R.id.listView1);
        listView.setAdapter(new NewsAdapter(getContext(),newsList));
        return view;
        //       return super.onCreateView(inflater, container, savedInstanceState);

    }
    private void  initData(){
        for(int i=0;i<100;i++){

            newsList.add(new NewsBean("nihao"+i));
        }

    }
}
