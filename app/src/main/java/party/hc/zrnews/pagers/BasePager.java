package party.hc.zrnews.pagers;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import party.hc.zrnews.R;


/**
 * Created by 18573 on 2018/7/11.
 */

public class BasePager {
    public View mRootView;
    public Context context;
    public FrameLayout flContent;

    public BasePager(Context context) {
        this.context = context;
         mRootView= initView();

    }

    /**
     * 初始化视图
     * @return
     */
    public View initView() {
        View view = View.inflate(context, R.layout.view,null);
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);
        return view;
    }

    /**
     * 初始化数据
     */
    public void iniData(){

    }
}
