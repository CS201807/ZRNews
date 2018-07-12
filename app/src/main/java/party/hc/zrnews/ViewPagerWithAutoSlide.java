package party.hc.zrnews;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;

/**
 * Created by ubuntu on 18-7-11.
 */

public class ViewPagerWithAutoSlide extends ViewPager  {
    Handler handler;
    public ViewPagerWithAutoSlide(Context context) {
        super(context);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setCurrentItem(getCurrentItem() + 1);
            }
        }, 4000);
        this.addOnPageChangeListener(new OnPageChangeListener() {
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
    }


}
