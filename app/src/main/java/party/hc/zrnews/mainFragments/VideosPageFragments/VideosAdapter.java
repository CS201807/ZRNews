package party.hc.zrnews.mainFragments.VideosPageFragments;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import party.hc.zrnews.R;
import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.mainFragments.NewsPageFragments.NewsAdapter;

/**
 * Created by ubuntu on 18-7-15.
 */

public class VideosAdapter extends BaseAdapter {
    private Context context;

    public VideosAdapter(Context context, List<NewsBean> data) {
        this.context = context;
        this.data = data;
        map=new HashMap<>();
    }
    private Map<Integer,Boolean> map;
    private List<NewsBean> data;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        VideosAdapter.ViewHolder holder;
        if(view==null){
            view=View.inflate(context, R.layout.new_item,null);
            holder=new VideosAdapter.ViewHolder();
            holder.tvName=(TextView)view.findViewById(R.id.textView2);
            view.setTag(holder);
        }
        View v=view;
        holder=(VideosAdapter.ViewHolder) v.getTag();
        holder.tvName.setText(data.get(i).getTitle());
        return v;
    }

    private class ViewHolder {
        public TextView tvName;
    }
}
