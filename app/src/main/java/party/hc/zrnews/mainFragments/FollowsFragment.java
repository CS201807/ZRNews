package party.hc.zrnews.mainFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.R;
import party.hc.zrnews.mainFragments.VideosPageFragments.VideosBFragment;
import party.hc.zrnews.mainFragments.VideosPageFragments.VideosFragmentAdapter;
import party.hc.zrnews.mainFragments.VideosPageFragments.VideosGeneralFragment;

/**
 * Created by ubuntu on 18-7-15.
 */

public class FollowsFragment extends BFragment {

    private static final String[] CONTENT_TITLES = new String[]{"推荐", "热点", "当地", "视频", "社会", "图片", "娱乐", "问答", "科技", "汽车", "财经",};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.page_follows,null);
        ViewPager pager = (ViewPager)view.findViewById(R.id.pager);

        List<VideosBFragment> newsBFragments=new ArrayList<>();
        for(int i=0;i<CONTENT_TITLES.length;i++){
            VideosGeneralFragment videosGeneralFragment = new VideosGeneralFragment();
            videosGeneralFragment.setTitle(CONTENT_TITLES[i]);
            newsBFragments.add(videosGeneralFragment);
        }

        pager.setAdapter(new VideosFragmentAdapter(getChildFragmentManager(),newsBFragments));


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
