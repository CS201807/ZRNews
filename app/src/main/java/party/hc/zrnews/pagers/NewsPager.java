package party.hc.zrnews.pagers;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;

import party.hc.zrnews.MainActivity;
import party.hc.zrnews.NewsAdapter;
import party.hc.zrnews.NewsViewPagerAdapter;
import party.hc.zrnews.R;
import party.hc.zrnews.SimpleAdapter;
import party.hc.zrnews.bean.NewsBean;

/**
 * Created by 18573 on 2018/7/11.
 * 新闻页面
 */

public class NewsPager extends BasePager {

    public NewsPager(Context context) {
        super(context);
    }
    private static final String[] CONTENT_TITLES = new String[]{"推荐", "热点", "当地", "视频", "社会", "图片", "娱乐", "问答", "科技", "汽车", "财经",};

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.page_news,null);
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);
        return view;
    }

    @Override
    public void iniData() {
        TextView tv = new TextView(context);
        ViewPager pager = (ViewPager)mRootView.findViewById(R.id.pager);
        ArrayList<View>newsList;
        newsList=new ArrayList<>();
        TextView view1= new TextView(context);
        view1.setText("nihao!");
        newsList.add(view1);
        TextView view2= new TextView(context);
        view2.setText("buhao!");
        newsList.add(view2);
        TextView view3= new TextView(context);
        view3.setText("buhao!");
        newsList.add(view3);
        pager.setAdapter(new SimpleAdapter(newsList));


//Bind the title indicator to the adapter
        TitlePageIndicator titleIndicator = (TitlePageIndicator)mRootView.findViewById(R.id.indicator);
        titleIndicator.setTextColor(Color.GRAY);
        titleIndicator.setSelectedColor(Color.RED);
        titleIndicator.setViewPager(pager);

        titleIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //flContent.addView(tv);
    }
}
