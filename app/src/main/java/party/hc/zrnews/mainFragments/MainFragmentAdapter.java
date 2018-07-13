package party.hc.zrnews.mainFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ubuntu on 18-7-12.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {
    List<BFragment> fragments;

    public MainFragmentAdapter(FragmentManager fm, List<BFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
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
