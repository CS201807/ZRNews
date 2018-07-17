package party.hc.zrnews.mainFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import party.hc.zrnews.R;
import party.hc.zrnews.UI.SowingPics;

/**
 * Created by ubuntu on 18-7-12.
 */

public class firstFragment extends BFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view =inflater.inflate(R.layout.new_pager,null);
        LinearLayout layout=view.findViewById(R.id.testLayout);
        List<String> strings=new ArrayList<>();

        strings.add("https://www.baidu.com/img/bd_logo1.png?where=super");
        strings.add("https://www.baidu.com/img/bd_logo1.png?where=super");

        strings.add("https://www.baidu.com/img/bd_logo1.png?where=super");
        strings.add("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1591167482,3441760007&fm=173&app=25&f=JPEG?w=218&h=146&s=CD81AC5042207107989BE253030040FB");
       // layout.addView(new SowingPics(,null));
        return view;
        //       return super.onCreateView(inflater, container, savedInstanceState);

    }
}
