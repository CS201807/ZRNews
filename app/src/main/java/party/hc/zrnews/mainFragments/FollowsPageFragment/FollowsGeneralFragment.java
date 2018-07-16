package party.hc.zrnews.mainFragments.FollowsPageFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;

import party.hc.zrnews.NewsReadActivity;
import party.hc.zrnews.R;
import party.hc.zrnews.UI.MicroArticle;
import party.hc.zrnews.bean.MicroArticleBean;
import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.conn.GetNews;
import party.hc.zrnews.mainFragments.NewsPageFragments.NewsAdapter;
import party.hc.zrnews.mainFragments.NewsPageFragments.NewsGeneralFragment;
import party.hc.zrnews.tools.MArrayList;

/**
 * Created by ubuntu on 18-7-15.
 */

public class FollowsGeneralFragment extends FollowsBFragment {
    public FollowsGeneralFragment() {
    }

    private String title;
    private ArrayList<MicroArticleBean> newsList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FollowsAdapter myAdapter;

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.page_news_general,null);
        newsList=new MArrayList<>();
        initData();
        //listview
        ListView listView=(ListView) view.findViewById(R.id.listView1);
        myAdapter=new FollowsAdapter(getContext(),newsList);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getContext(),NewsReadActivity.class);
//                intent.putExtra("url",newsList.get(i).getUrl());
//                getContext().startActivity(intent);
            }
        });
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.main_srl);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new FollowsGeneralFragment.LoadDataThread().start();
            }
        });

        return view;
        //       return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();

        myAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化数据
     */
    private void  initData(){
        for(int i=0;i<10;i++){

            newsList.add(new MicroArticleBean());
        }

    }
    /**
     * 加载数据的线程
     */
    class LoadDataThread extends  Thread{
        @Override
        public void run() {
            initData();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(0x101);//通过handler发送一个更新数据的标记
        }

        private void initData() {
            GetNews news=new GetNews();
//            try {
//                //news.getNews(newsList,"头条");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }
    }

    /**
     * 处理消息
     */
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x101:
                    if (swipeRefreshLayout.isRefreshing()){
                        myAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);//设置不刷新
                    }
                    break;
            }
        }
    };

}
