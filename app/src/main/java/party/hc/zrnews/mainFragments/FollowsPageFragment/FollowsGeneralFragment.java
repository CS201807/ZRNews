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
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.DB.NewsCache;
import party.hc.zrnews.R;
import party.hc.zrnews.UI.MicroArticle;
import party.hc.zrnews.UrlReadActivity;
import party.hc.zrnews.bean.MicroArticleBean;
import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.conn.GetNews;
import party.hc.zrnews.mainFragments.NewsPageFragments.NewsAdapter;
import party.hc.zrnews.mainFragments.NewsPageFragments.NewsGeneralFragment;
import party.hc.zrnews.tools.MArrayList;
import party.hc.zrnews.tools.SerializeUtils;

/**
 * Created by ubuntu on 18-7-15.
 */

public class FollowsGeneralFragment extends FollowsBFragment {
    public FollowsGeneralFragment() {

    }

    private String title;
    private ArrayList<NewsBean> newsList;
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
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_news_general, null);
        newsList = new MArrayList<>();
        initData();

        //listview
        ListView listView = (ListView) view.findViewById(R.id.listView1);
        myAdapter = new FollowsAdapter(getContext(), newsList);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), UrlReadActivity.class);
                intent.putExtra("url", newsList.get(i).getUrl());
                intent.putExtra("id", newsList.get(i).getId());
                try {
                    intent.putExtra("bean",SerializeUtils.serialize(newsList.get(i)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                intent.putExtra("type", "nojs");
                getContext().startActivity(intent);
            }
        });
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.main_srl);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new FollowsGeneralFragment.LoadDataThread().start();
            }
        });
        if (newsList.size()==0)
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
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
    private void initData() {
//        for(int i=0;i<10;i++){
//
//            newsList.add(new NewsBean());
//        }
        NewsCache cache = new NewsCache(getContext());

        try {
            newsList = (MArrayList<NewsBean>) SerializeUtils.serializeToObject(cache.getReadPageIndexByURL("F"+title));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 加载数据的线程
     */
    class LoadDataThread extends Thread {
        @Override
        public void run() {
            int n= newsList.size();
            initData();
            if(newsList.size()==n){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0x103);//通过handler发送一个更新数据的标记
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(0x101);//通过handler发送一个更新数据的标记
        }

        private void initData() {
            GetNews news = new GetNews();
            try {
                news.getNews(newsList, "社会");
                NewsCache cache = new NewsCache(getContext());
                //添加缓存功能
                try {
                    List<NewsBean> subList = new MArrayList<>();
                    subList.addAll(newsList.subList(newsList.size()-10,newsList.size()));
                    String s = SerializeUtils.serialize(subList);
                    if (cache.checkByKey("F"+title)) {
                        cache.updateValue("F"+title, s);
                    } else {
                        cache.insert("F"+title, s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理消息
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x101:
                    if (swipeRefreshLayout.isRefreshing()) {
                        myAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);//设置不刷新
                    }
                    break;
                case 0x103:
                    Toast.makeText(getContext(),"网络出问题了！没有获取到数据。",Toast.LENGTH_SHORT).show();
                    swipeRefreshLayout.setRefreshing(false);//设置不刷新
                    break;
            }
        }
    };
}