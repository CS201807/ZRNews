package party.hc.zrnews.mainFragments.FollowsPageFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import party.hc.zrnews.mainFragments.NewsPageFragments.NewsBFragment;

/**
 * Created by ubuntu on 18-7-15.
 */

public class FollowsFragmentAdapter extends FragmentPagerAdapter {
    List<FollowsBFragment> fragments;

    public FollowsFragmentAdapter(FragmentManager fm, List<FollowsBFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public FollowsFragmentAdapter(FragmentManager fm) {
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
