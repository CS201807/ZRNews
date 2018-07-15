package party.hc.zrnews.mainFragments.NewsPageFragments;

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

/**
 * Created by ubuntu on 18-7-11.
 */

public class NewsAdapter extends BaseAdapter {
    private Context context;

    public NewsAdapter(Context context, List<NewsBean> data) {
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
        ViewHolder holder;
        if(view==null){
            view=View.inflate(context, R.layout.conponent_style4,null);
            holder=new ViewHolder();
            holder.tvName=(TextView)view.findViewById(R.id.CS4_title);
            view.setTag(holder);
        }
        View v=view;
        holder=(ViewHolder) v.getTag();
        holder.tvName.setText(data.get(i).getTitle());
        return v;
    }

    private class ViewHolder {
        public TextView tvName;
    }
}
