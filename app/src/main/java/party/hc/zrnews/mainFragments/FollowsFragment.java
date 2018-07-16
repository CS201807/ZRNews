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
import party.hc.zrnews.mainFragments.FollowsPageFragment.FollowsBFragment;
import party.hc.zrnews.mainFragments.FollowsPageFragment.FollowsFragmentAdapter;
import party.hc.zrnews.mainFragments.FollowsPageFragment.FollowsGeneralFragment;
import party.hc.zrnews.mainFragments.VideosPageFragments.VideosBFragment;
import party.hc.zrnews.mainFragments.VideosPageFragments.VideosFragmentAdapter;
import party.hc.zrnews.mainFragments.VideosPageFragments.VideosGeneralFragment;

/**
 * Created by ubuntu on 18-7-15.
 */

public class FollowsFragment extends BFragment {

    private static final String[] CONTENT_TITLES = new String[]{"文字","图片", "视频",};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.page_follows,null);
        ViewPager pager = (ViewPager)view.findViewById(R.id.pager);

        List<FollowsBFragment> newsBFragments=new ArrayList<>();
        for(int i=0;i<CONTENT_TITLES.length;i++){
            FollowsGeneralFragment followsGeneralFragment = new FollowsGeneralFragment();
            followsGeneralFragment.setTitle(CONTENT_TITLES[i]);
            newsBFragments.add(followsGeneralFragment);
        }

        pager.setAdapter(new FollowsFragmentAdapter(getChildFragmentManager(),newsBFragments));


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
