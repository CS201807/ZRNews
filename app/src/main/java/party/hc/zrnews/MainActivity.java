package party.hc.zrnews;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.mainFragments.BFragment;
import party.hc.zrnews.mainFragments.FollowsFragment;
import party.hc.zrnews.mainFragments.MainFragmentAdapter;
import party.hc.zrnews.mainFragments.NewsFragment;
import party.hc.zrnews.mainFragments.SelfFragment;
import party.hc.zrnews.mainFragments.VideosFragment;
import party.hc.zrnews.mainFragments.firstFragment;

public class MainActivity extends AppCompatActivity {
     //List<BasePager> list;
    List<BFragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar
        final Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        final FrameLayout search_frameLayout=(FrameLayout)findViewById(R.id.search_frameLayout);
        //main viewPager
        final ViewPager viewPager=(ViewPager) findViewById(R.id.viewPager1);
        setData();
        viewPager.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(),list));
        //bottom buttons
        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radioButton:
                        search_frameLayout.setVisibility(View.VISIBLE);
                        toolbar.setVisibility(View.VISIBLE);
                        viewPager.setCurrentItem(0,false);

//                        //创建一个Fragment
//                        FragmentManager manager=getSupportFragmentManager();
//                        //开启一个事务
//                        FragmentTransaction transaction=manager.beginTransaction();
//                        firstFragment firstFragment=new firstFragment();
//                        //放到对应位置
//                        transaction.replace(R.id.fl_contents,firstFragment,false??);
//                        transaction.commit();
                        break;
                    case R.id.radioButton7:
                        search_frameLayout.setVisibility(View.GONE);
                        toolbar.setVisibility(View.VISIBLE);
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.radioButton6:
                        viewPager.setCurrentItem(2,false);
                        search_frameLayout.setVisibility(View.GONE);
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radioButton5:
                        search_frameLayout.setVisibility(View.GONE);
                        toolbar.setVisibility(View.GONE);
                        viewPager.setCurrentItem(3,false);
                        break;


                }
            }
        });


    }
    private void setData() {
        list=new ArrayList<>();
        list.add(new NewsFragment());
        list.add(new VideosFragment());
        list.add(new FollowsFragment());
        list.add(new SelfFragment());
    }
}
