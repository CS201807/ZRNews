package party.hc.zrnews.mainFragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapShader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import party.hc.zrnews.CollectActivity;
import party.hc.zrnews.HistoryActivity;
import party.hc.zrnews.MainActivity;
import party.hc.zrnews.MessageActivity;
import party.hc.zrnews.NewsFeedActivity;
import party.hc.zrnews.R;
import party.hc.zrnews.SelfInfoActivity;
import party.hc.zrnews.SettingsActivity;
import party.hc.zrnews.SuggestionActivity;
import party.hc.zrnews.UI.CircleTransform;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ubuntu on 18-7-15.
 */

public class SelfFragment extends BFragment  {

    SharedPreferences preferences;
    TextView username;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        preferences=getContext().getSharedPreferences("userdata",MODE_PRIVATE);
        switch (requestCode){

            case 1:
                if(resultCode==RESULT_OK||resultCode==0){
                    username.setText(preferences.getString("name",""));
                }
                break;
            default:
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=View.inflate(getContext(), R.layout.page_self,null);
        username=view.findViewById(R.id.self_username);
        preferences=getContext().getSharedPreferences("userdata",MODE_PRIVATE);
        username.setText(preferences.getString("name","最热新闻"));
        Button go=view.findViewById(R.id.go);
        Picasso.get().load(preferences.getString("avatar", String.valueOf(R.drawable.h))).transform(new CircleTransform()).into((ImageView) view.findViewById(R.id.iv));
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),SelfInfoActivity.class);
                startActivityForResult(intent,1);
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
        Button history=view.findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });
        Button message=view.findViewById(R.id.message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MessageActivity.class);
                startActivity(intent);
            }
        });
        Button newsFeed=view.findViewById(R.id.news_feed);
        newsFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), NewsFeedActivity.class);

                startActivity(intent);
            }
        });
        Button suggest=view.findViewById(R.id.suggest);
        suggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SuggestionActivity.class);
                startActivity(intent);
            }
        });
        Button settings=view.findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
