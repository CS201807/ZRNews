package party.hc.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.Space;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ubuntu on 18-7-11.
 */

public class SimpleAdapter extends FragmentPagerAdapter {


    public SimpleAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}