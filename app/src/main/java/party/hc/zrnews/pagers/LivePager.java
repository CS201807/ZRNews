package party.hc.zrnews.pagers;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by 18573 on 2018/7/11.
 * 新闻页面
 */

public class LivePager extends BasePager {

    public LivePager(Context context) {
        super(context);
    }

    @Override
    public void iniData() {
        TextView tv = new TextView(context);
        tv.setText("直播");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(Color.RED);
        flContent.addView(tv);
    }
}
