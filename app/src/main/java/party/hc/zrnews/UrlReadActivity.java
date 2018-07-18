package party.hc.zrnews;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import org.json.JSONException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import party.hc.zrnews.DB.NewsCache;
import party.hc.zrnews.UI.CommentLine;
import party.hc.zrnews.UI.MWebView;
import party.hc.zrnews.bean.CommentBean;
import party.hc.zrnews.bean.DetailBean;
import party.hc.zrnews.bean.HistoryBean;
import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.conn.GetDetails;
import party.hc.zrnews.conn.GetNews;
import party.hc.zrnews.conn.HttpUtil;
import party.hc.zrnews.conn.User;
import party.hc.zrnews.tools.MArrayList;
import party.hc.zrnews.tools.SerializeUtils;
import party.hc.zrnews.tools.Tools;

public class UrlReadActivity extends AppCompatActivity  {
    MWebView myWebView;
    String url;
    String dom;
    DetailBean detailBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_read);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String url=getIntent().getStringExtra("url");
        //intent.putExtra("type","nojs");
        String type=getIntent().getStringExtra("type");

        myWebView=(MWebView) findViewById(R.id.webView);

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //设置缓存
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        if(type.equals("nojs")){
            webSettings.setJavaScriptEnabled(false);//设置能够解析Javascript
        }
        else {
            webSettings.setJavaScriptEnabled(true);//设置能够解析Javascript
        }
        //

        //webSettings.setJavaScriptEnabled(true);//设置能够解析Javascript

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
              new LoadDataThread().start();

            }
        });

        webSettings.setDomStorageEnabled(true);//设置适应Html5 //重点是这个设置

        myWebView.loadUrl(url);

        ImageButton jump_to_comment =(ImageButton)findViewById(R.id.comment_button);
        final ObservableScrollView scrollView=(ObservableScrollView)findViewById(R.id.viewObj);
        jump_to_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.scrollTo(0,myWebView.getMeasuredHeight());
            }
        });
        final EditText editText=(EditText)findViewById(R.id.editText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (i == KeyEvent.KEYCODE_ENTER&& keyEvent.getAction() == KeyEvent.ACTION_UP) {
                  //detailBean;
                   new commentThread().start();
                }
                return false;

            }
        });
        ImageButton imageButton=(ImageButton) findViewById(R.id.add_to_C);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(is_in_shoucang()){
                    removeFromShoucang();
                }else {
                    addToShouCang();
                }
                updateShouCangbutton();
            }
        });
        updateShouCangbutton();

        final ImageButton share=(ImageButton)findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.share(UrlReadActivity.this,"",getIntent().getStringExtra("url"));
            }
        });

    }

    private void removeFromShoucang() {
        String type=getIntent().getStringExtra("type");
        if(type.equals("js")){
            return ;
        }
        //intent.putExtra("his","nohis");
        NewsCache cache=new NewsCache(getApplicationContext());
        ArrayList<HistoryBean> newsList=new ArrayList<>();
        try {
            newsList= (ArrayList<HistoryBean>) SerializeUtils.serializeToObject(cache.getReadPageIndexByURL("addtoC"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String bean=getIntent().getStringExtra("url");
//        NewsBean bean1=new NewsBean();
//        try {
//            bean1= (NewsBean) SerializeUtils.serializeToObject(bean);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        for(int i=0;i<newsList.size();i++){
            if(newsList.get(i).getUrl().equals(bean)){
                newsList.remove(i);
            }
        }

        String s= null;
        try {
            s = SerializeUtils.serialize(newsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(cache.checkByKey("addtoC")){
            cache.updateValue("addtoC",s);
        }else {
            cache.insert("addtoC",s);
        }


    }

    void updateShouCangbutton(){
        ImageButton imageButton=(ImageButton) findViewById(R.id.add_to_C);
        if(is_in_shoucang()){

            imageButton.setImageResource(R.drawable.star_fill);

        }
        else {
            imageButton.setImageResource(R.drawable.star);
        }
    }
    void Init_pinglunqu(){
        LinearLayout layout = (LinearLayout) findViewById(R.id.content_layout);
        layout.removeAllViews();
        List<CommentBean> been= detailBean.getCbl();
        for(int i=0;i<been.size();i++) {

            CommentLine view = new CommentLine(this);
            view.init(been.get(i));
            layout.addView(view);
        }
        View view1=View.inflate(this,R.layout.comment_bottom,null);
        layout.addView(view1);

    }
    private String result;
    class commentThread extends  Thread{
        @Override
        public void run() {
            final EditText editText=(EditText)findViewById(R.id.editText);
            SharedPreferences editor = getSharedPreferences("userdata", MODE_PRIVATE);
            String id=editor.getString("id",null);
            User user=new User(id);
            try {
               result= user.addComment(detailBean,editText.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            handler.sendEmptyMessage(0x102);//通过handler发送一个更新数据的标记
        }

    }
    class LoadDataThread extends  Thread{
        @Override
        public void run() {
            String Id=getIntent().getStringExtra("id");
            try {
                detailBean= new DetailBean();
                GetDetails.getDetails(Id,detailBean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            addtoHistory();


            handler.sendEmptyMessage(0x101);//通过handler发送一个更新数据的标记
        }

    }

    /**
     * 处理消息
     */
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x101:
                    Init_pinglunqu();
                    break;
                case 0x102:
                    if(result.equals("false")){
                        Toast.makeText(UrlReadActivity.this,"评论失败！",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    Toast.makeText(UrlReadActivity.this,"评论成功！",Toast.LENGTH_SHORT).show();
                    final EditText editText=(EditText)findViewById(R.id.editText);
                    editText.setText("");
                    new LoadDataThread().start();
                      break;
            }
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        myWebView.onPause();
        myWebView.pauseTimers();
    }

    @Override
    public void onResume() {
        super.onResume();
        myWebView.resumeTimers();
        myWebView.onResume();
    }


    @Override
    protected void onDestroy() {
        myWebView.destroy();
        myWebView = null;
        super.onDestroy();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void  addtoHistory(){
//        for(int i=0;i<10;i++){
//
//            newsList.add(new NewsBean());
//        }
        String type=getIntent().getStringExtra("type");
        if(type.equals("js")){
            return ;
        }
        //intent.putExtra("his","nohis");
        String his=getIntent().getStringExtra("his");
        if(his!=null){
            return ;
        }
        NewsCache cache=new NewsCache(getApplicationContext());
        ArrayList<HistoryBean> newsList=new ArrayList<>();
        try {
            newsList= (ArrayList<HistoryBean>) SerializeUtils.serializeToObject(cache.getReadPageIndexByURL("addtoHistory"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String bean=getIntent().getStringExtra("bean");
        if(bean==null){
            return;
        }
        NewsBean bean1=new NewsBean();
        try {
             bean1= (NewsBean) SerializeUtils.serializeToObject(bean);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<newsList.size();i++){
            if(newsList.get(i).getId().equals(bean1.getId())){
                return;
            }
        }
        newsList.add(new HistoryBean(bean1.getId(),bean1.getTitle(),bean1.getDate(), "",bean1.getAuthor(),bean1.getUrl(),bean1.getThumbnail()));

        //添加缓存功能


            String s= null;
            try {
                s = SerializeUtils.serialize(newsList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(cache.checkByKey("addtoHistory")){
                cache.updateValue("addtoHistory",s);
            }else {
                cache.insert("addtoHistory",s);
            }

    }

    public void addToShouCang(){
        String type=getIntent().getStringExtra("type");
        if(type.equals("js")){
            return ;
        }
        //intent.putExtra("his","nohis");
        NewsCache cache=new NewsCache(getApplicationContext());
        ArrayList<HistoryBean> newsList=new ArrayList<>();
        try {
            newsList= (ArrayList<HistoryBean>) SerializeUtils.serializeToObject(cache.getReadPageIndexByURL("addtoC"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String bean=getIntent().getStringExtra("bean");
        NewsBean bean1=new NewsBean();
        try {
            bean1= (NewsBean) SerializeUtils.serializeToObject(bean);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<newsList.size();i++){
            if(newsList.get(i).getId().equals(bean1.getId())){
                return;
            }
        }
        newsList.add(new HistoryBean(bean1.getId(),bean1.getTitle(),bean1.getDate(), "",bean1.getAuthor(),bean1.getUrl(),bean1.getThumbnail()));

        //添加缓存功能


        String s= null;
        try {
            s = SerializeUtils.serialize(newsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(cache.checkByKey("addtoC")){
            cache.updateValue("addtoC",s);
        }else {
            cache.insert("addtoC",s);
        }
    }
    public boolean is_in_shoucang(){
     String type=getIntent().getStringExtra("type");
        if(type.equals("js")){
            return false;
        }
        //intent.putExtra("his","nohis");
        NewsCache cache=new NewsCache(getApplicationContext());
        ArrayList<HistoryBean> newsList=new ArrayList<>();
        try {
            newsList= (ArrayList<HistoryBean>) SerializeUtils.serializeToObject(cache.getReadPageIndexByURL("addtoC"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
       String bean=getIntent().getStringExtra("url");
//        NewsBean bean1=new NewsBean();
//        try {
//            bean1= (NewsBean) SerializeUtils.serializeToObject(bean);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        for(int i=0;i<newsList.size();i++){
            if(newsList.get(i).getUrl().equals(bean)){
                return true;
            }
        }
        return false;
    }

}
