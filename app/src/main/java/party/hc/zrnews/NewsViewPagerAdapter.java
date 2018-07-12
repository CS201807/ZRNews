package party.hc.zrnews;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import party.hc.zrnews.pagers.BasePager;

/**
 * Created by ubuntu on 18-7-11.
 */

public class NewsViewPagerAdapter extends PagerAdapter {
    public NewsViewPagerAdapter(List<BasePager> list) {
        this.list = list;
    }

    private List<BasePager> list;



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BasePager pager = list.get(position);
        pager.iniData();
        View view = pager.mRootView;
        container.addView(view);
        return view;
       // return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position).mRootView);
        //super.destroyItem(container, position, object);
    }
}
