package party.hc.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;


public class MainActivity extends Activity {

    //定义一串数据源。这里是定义死的，当然大部分都是来源于网络解析的数据
    private static final String[] CONTENT = new String[]{"Recent", "Artists", "Albums", "Songs", "Playlists", "Genres", "Recent", "Artists", "Albums", "Songs", "Playlists", "Genres"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //固定使用布局
        setContentView(R.layout.activity_main);
        //获取实例
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        //设置viewpage的适配器
        MyAdapter adapter = new MyAdapter();
        pager.setAdapter(adapter);

        //把viewpage和TabPageIndicator关联
        TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return CONTENT.length;//告诉viewpage，我有多少条数据，要加载
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;//官方推荐写法
        }

        /**
         * 页签显示数据的方法
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //先使每页page上显示text文本
            // 本page要展示的内容。替换掉Fragmenlayout那张白纸。 改变子类自己的界面数据与样式。暂时先用textview代表整块view
            TextView textView = new TextView(MainActivity.this);
            textView.setText(CONTENT[position]);//为每一页加载的page设置显示的内容
            textView.setTextSize(25);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.GREEN);

            //别忘记把view添加到page里面
            container.addView(textView);
            return textView;

        }

    }
}