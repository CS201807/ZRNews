package party.hc.zrnews.mainFragments.VideosPageFragments;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.DB.NewsCache;
import party.hc.zrnews.UrlReadActivity;
import party.hc.zrnews.R;
import party.hc.zrnews.bean.VideoBean;
import party.hc.zrnews.conn.GetVideos;
import party.hc.zrnews.tools.MArrayList;
import party.hc.zrnews.tools.SerializeUtils;

/**
 * Created by ubuntu on 18-7-15.
 */

public class VideosGeneralFragment  extends VideosBFragment{
    private String title;
    private ArrayList<VideoBean> newsList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private VideosAdapter myAdapter;
    public VideosGeneralFragment() {
    }
    private String openUrl="  ";

    public void setTitle(String title) {
        this.title = title;
    }

    @Override



    public String getTitle() {
        return title;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.page_videos_general,null);
        newsList=new MArrayList<>();
        initData();
        //listview
        ListView listView=(ListView) view.findViewById(R.id.listView1);
        myAdapter=new VideosAdapter(getContext(),newsList);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),UrlReadActivity.class);
                intent.putExtra("url",newsList.get(i).getUrl());
                intent.putExtra("type","js");
                getContext().startActivity(intent);
            }
        });
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
//        for(int i=0;i<100;i++){
//
//            newsList.add(new VideoBean());
//        }

        NewsCache cache=new NewsCache(getContext());

        try {
            newsList= (ArrayList<VideoBean>) SerializeUtils.serializeToObject(cache.getReadPageIndexByURL("V"+title));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            try {
                GetVideos.getVideos(newsList);
                //添加缓存功能
                NewsCache cache=new NewsCache(getContext());
                try {
                    List<VideoBean> subList=new ArrayList<>();
                    subList.addAll( newsList.subList(0,4));
                    String s= SerializeUtils.serialize(subList);
                    if(cache.checkByKey("V"+title)){
                        cache.updateValue("V"+title,s);
                    }else {
                        cache.insert("V"+title,s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //newsList.add(new VideoBean());
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
