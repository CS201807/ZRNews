package party.hc.zrnews.mainFragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;

import party.hc.zrnews.R;
import party.hc.zrnews.SimpleAdapter;

/**
 * Created by ubuntu on 18-7-12.
 */

public class NewsFragment extends BFragment {
    private static final String[] CONTENT_TITLES = new String[]{"推荐", "热点", "当地", "视频", "社会", "图片", "娱乐", "问答", "科技", "汽车", "财经",};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.page_news,null);
        FrameLayout flContent = (FrameLayout) view.findViewById(R.id.fl_content);
        TextView tv = new TextView(getContext());
        ViewPager pager = (ViewPager)view.findViewById(R.id.pager);
        ArrayList<View> newsList;
        newsList=new ArrayList<>();
        TextView view1= new TextView(getContext());
        view1.setText("nihao!");
        newsList.add(view1);
        TextView view2= new TextView(getContext());
        view2.setText("buhao!");
        newsList.add(view2);
        TextView view3= new TextView(getContext());
        view3.setText("buhao!");
        newsList.add(view3);
        pager.setAdapter(new SimpleAdapter(newsList));


//Bind the title indicator to the adapter
        TitlePageIndicator titleIndicator = (TitlePageIndicator)view.findViewById(R.id.indicator);
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
        return view;
        //       return super.onCreateView(inflater, container, savedInstanceState);

    }
}
