package party.hc.zrnews.mainFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import party.hc.zrnews.R;

/**
 * Created by ubuntu on 18-7-15.
 */

public class SelfFragment extends BFragment  {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.page_self,null);
        return view;
    }
}
