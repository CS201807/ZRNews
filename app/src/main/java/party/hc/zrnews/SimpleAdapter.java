package party.hc.zrnews;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import party.hc.zrnews.pagers.BasePager;

/**
 * Created by ubuntu on 18-7-11.
 */

public class SimpleAdapter  extends PagerAdapter {
    public SimpleAdapter(List<View> list) {
        this.list = list;
    }

    private List<View> list;

    @Override
    public CharSequence getPageTitle(int position) {
        return "你好！";
    }

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
        View view = list.get(position);

        container.addView(view);
        return view;
        // return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
        //super.destroyItem(container, position, object);
    }
}

