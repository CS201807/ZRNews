package party.hc.zrnews.mainFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import party.hc.zrnews.R;

/**
 * Created by ubuntu on 18-7-12.
 */

public class firstFragment extends BFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view =inflater.inflate(R.layout.new_pager,null);
        return view;
        //       return super.onCreateView(inflater, container, savedInstanceState);

    }
}
