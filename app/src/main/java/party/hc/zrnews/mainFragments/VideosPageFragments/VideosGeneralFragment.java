package party.hc.zrnews.mainFragments.VideosPageFragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import party.hc.zrnews.R;
import party.hc.zrnews.bean.NewsBean;

/**
 * Created by ubuntu on 18-7-15.
 */

public class VideosGeneralFragment  extends VideosBFragment{
    private String title;
    private ArrayList<NewsBean> newsList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private VideosAdapter myAdapter;
    public VideosGeneralFragment(String title) {
        this.title = title;
    }
    private String openUrl="  ";
    @Override
    public String getTitle() {
        return title;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.page_videos_general,null);
        newsList=new ArrayList<>();
        initData();
        //listview
        ListView listView=(ListView) view.findViewById(R.id.listView1);
        myAdapter=new VideosAdapter(getContext(),newsList);
        listView.setAdapter(myAdapter);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.main_srl);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new VideosGeneralFragment.LoadDataThread().start();
            }
        });

        return view;
        //       return super.onCreateView(inflater, container, savedInstanceState);

    }

    /**
     * 初始化数据
     */
    private void  initData(){
        for(int i=0;i<100;i++){

            newsList.add(new NewsBean("nihao"+i, openUrl));
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
            newsList.add(new NewsBean("不好！", openUrl));
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
