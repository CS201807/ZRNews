package party.hc.zrnews.mainFragments.VideosPageFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ubuntu on 18-7-15.
 */

public class VideosFragmentAdapter extends FragmentPagerAdapter {
    List<VideosBFragment> fragments;

    public VideosFragmentAdapter(FragmentManager fm, List<VideosBFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public VideosFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
