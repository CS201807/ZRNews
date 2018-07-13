package party.hc.zrnews;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.mainFragments.BFragment;
import party.hc.zrnews.mainFragments.MainFragmentAdapter;
import party.hc.zrnews.mainFragments.NewsFragment;
import party.hc.zrnews.mainFragments.firstFragment;
import party.hc.zrnews.pagers.BasePager;
import party.hc.zrnews.pagers.HotPager;
import party.hc.zrnews.pagers.LivePager;
import party.hc.zrnews.pagers.MePager;
import party.hc.zrnews.pagers.NewsPager;
import party.hc.zrnews.pagers.VideoPager;

public class MainActivity extends AppCompatActivity {
    private ArrayList<NewsBean> newsList;
    //List<BasePager> list;
    List<BFragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listview
        ListView listView=(ListView) findViewById(R.id.listView1);
         newsList=new ArrayList<>();
        initData();
        listView.setAdapter(new NewsAdapter(this,newsList));
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
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.radioButton6:
                        viewPager.setCurrentItem(2,false);
                        break;
                    case R.id.radioButton5:
                        viewPager.setCurrentItem(3,false);
                        break;


                }
            }
        });


    }
    private void setData() {
        list=new ArrayList<>();
        list.add(new firstFragment());
        list.add(new NewsFragment());
        list.add(new firstFragment());
        list.add(new firstFragment());
//        list = new ArrayList<>();
//        list.add(new NewsPager(MainActivity.this));
//        list.add(new VideoPager(MainActivity.this));
//        list.add(new HotPager(MainActivity.this));
//        list.add(new LivePager(MainActivity.this));
//        list.add(new MePager(MainActivity.this));
    }

    private void  initData(){
        for(int i=0;i<100;i++){

            newsList.add(new NewsBean("nihao"+i));
        }

    }

}
