package party.hc.zrnews.mainFragments.NewsPageFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import party.hc.zrnews.mainFragments.BFragment;

/**
 * Created by ubuntu on 18-7-13.
 */

public class NewsFragmentAdapter extends FragmentPagerAdapter {
    List<NewsBFragment> fragments;

    public NewsFragmentAdapter(FragmentManager fm, List<NewsBFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public NewsFragmentAdapter(FragmentManager fm) {
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
