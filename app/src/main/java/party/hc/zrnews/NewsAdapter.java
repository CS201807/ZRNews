package party.hc.zrnews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import party.hc.zrnews.bean.NewsBean;

/**
 * Created by ubuntu on 18-7-11.
 */

public class NewsAdapter extends BaseAdapter {
    private Context context;

    public NewsAdapter(Context context, List<NewsBean> data) {
        this.context = context;
        this.data = data;
    }

    private List<NewsBean> data;
    public NewsAdapter(Context context) {
        this.context = context;
    }

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
            view=View.inflate(context,R.layout.new_item,null);
            holder=new ViewHolder();
            holder.tvName=(TextView)view.findViewById(R.id.textView2);
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
