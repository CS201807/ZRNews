package party.hc.zrnews.UI;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.R;

/**
 * Created by ubuntu on 18-7-13.
 */

public class SowingPics extends LinearLayout {

    public SowingPics(final Context context, List<String> urls,List<String > titles, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.sowing_pics, this);
        Banner banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(urls);
if(titles.size()!=0){
            //设置banner样式
    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
}
            //设置标题集合（当banner样式有显示title时）
//        List<String> titles=new ArrayList<>();
//        titles.add("标题1");
//        titles.add("标题2");
//        titles.add("标题3");
//        titles.add("标题4");
        banner.setBannerTitles(titles);
       banner.setOnBannerListener(new OnBannerListener() {
           @Override
           public void OnBannerClick(int position) {
               Toast.makeText(context, "你点击了：" + position, Toast.LENGTH_SHORT).show();
           }
       });
        //banner设置方法全部调用完毕时最后调用
        banner.start();


    }

//    setContentView(R.layout.activity_main);
//    Banner banner = (Banner) findViewById(R.id.banner);
//    //设置banner样式
//    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//    //设置图片加载器
//    banner.setImageLoader(new GlideImageLoader());
//    //设置图片集合
//    banner.setImages(images);
//    //设置banner动画效果
//    banner.setBannerAnimation(Transformer.DepthPage);
//    //设置标题集合（当banner样式有显示title时）
//    banner.setBannerTitles(titles);
//    //设置自动轮播，默认为true
//    banner.isAutoPlay(true);
//    //设置轮播时间
//    banner.setDelayTime(1500);
//    //设置指示器位置（当banner模式中有指示器时）
//    banner.setIndicatorGravity(BannerConfig.CENTER);
//    //banner设置方法全部调用完毕时最后调用
//    banner.start();
}
