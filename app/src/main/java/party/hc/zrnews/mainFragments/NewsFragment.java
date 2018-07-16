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

import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.R;
import party.hc.zrnews.mainFragments.NewsPageFragments.NewsBFragment;
import party.hc.zrnews.mainFragments.NewsPageFragments.NewsFragmentAdapter;
import party.hc.zrnews.mainFragments.NewsPageFragments.NewsGeneralFragment;

/**
 * Created by ubuntu on 18-7-12.
 */

public class NewsFragment extends BFragment {
    private static final String[] CONTENT_TITLES = new String[]{"头条", "社会", "国内",  "国际", "娱乐",  "体育", "军事","科技","财经","时尚"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.page_news,null);
        ViewPager pager = (ViewPager)view.findViewById(R.id.pager);

        List<NewsBFragment> newsBFragments=new ArrayList<>();
        for(int i=0;i<CONTENT_TITLES.length;i++){
            NewsGeneralFragment newsGeneralFragment = new NewsGeneralFragment();
            newsGeneralFragment.setTitle(CONTENT_TITLES[i]);
            newsBFragments.add(newsGeneralFragment);
        }

        pager.setAdapter(new NewsFragmentAdapter(getChildFragmentManager(),newsBFragments));


//Bind the title indicator to the adapter
        TabPageIndicator titleIndicator = (TabPageIndicator)view.findViewById(R.id.indicator);
//        titleIndicator.setTextColor(Color.GRAY);
//        titleIndicator.setSelectedColor(Color.RED);
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
