package party.hc.zrnews.mainFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import party.hc.zrnews.CollectActivity;
import party.hc.zrnews.MainActivity;
import party.hc.zrnews.R;
import party.hc.zrnews.SelfInfoActivity;

/**
 * Created by ubuntu on 18-7-15.
 */

public class SelfFragment extends BFragment  {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.page_self,null);
        Button go=view.findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),SelfInfoActivity.class);
                startActivity(intent);
            }
        });
        Button collect=view.findViewById(R.id.collect);
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), CollectActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
