package party.hc.zrnews.pagers;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by 18573 on 2018/7/11.
 * 新闻页面
 */

public class HotPager extends BasePager {

    public HotPager(Context context) {
        super(context);
    }

    @Override
    public void iniData() {
        TextView tv = new TextView(context);
        //Set the pager with an adapter


        flContent.addView(tv);
    }
}
