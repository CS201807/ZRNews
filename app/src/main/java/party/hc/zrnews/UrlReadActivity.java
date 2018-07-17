package party.hc.zrnews;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
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
import party.hc.zrnews.bean.NewsBean;
import party.hc.zrnews.conn.GetNews;
import party.hc.zrnews.conn.HttpUtil;
import party.hc.zrnews.tools.SerializeUtils;

public class UrlReadActivity extends AppCompatActivity  {
    MWebView myWebView;
    String url;
    String dom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_read);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String url=getIntent().getStringExtra("url");
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
        //webSettings.setJavaScriptEnabled(true);//设置能够解析Javascript

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Init_pinglunqu();
//                myWebView.loadUrl("javascript:\n" +
//                        "var lastObj = document.getElementsByTagName(\"body\")[0].lastChild;\n" +
//                        "//alert(lastObj.innerHTML);\n" +
//                        "var p = document.createElement(\"ol\"); // 创建一个元素节点 \n" +
//                        "p.innerHTML = '<li>万物生</li><li>荷塘月色</li>';\n" +
//
//                        "function insertAfter( newElement, targetElement ){ // newElement是要追加的元素 targetElement 是指定元素的位置 \n" +
//                        "    var parent = targetElement.parentNode; // 找到指定元素的父节点 \n" +
//                        "    if( parent.lastChild == targetElement ){ // 判断指定元素的是否是节点中的最后一个位置 如果是的话就直接使用appendChild方法 \n" +
//                        "        parent.appendChild( newElement, targetElement ); \n" +
//                        "    }else{ \n" +
//                        "        parent.insertBefore( newElement, targetElement.nextSibling ); \n" +
//                        "    }; \n" +
//                        "};\n"+
//                        "insertAfter(p,lastObj); // 因为js没有直接追加到指定元素后面的方法 所以要自己创建一个方法 \n" );
//
//                //view.loadUrl("javascript:alert(234567)");
            }
        });

        webSettings.setDomStorageEnabled(true);//设置适应Html5 //重点是这个设置
//
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setUseWideViewPort(true);
//        webSettings.setBuiltInZoomControls(true);
//        webSettings.setDisplayZoomControls(false);
//        webSettings.setSupportZoom(true);
//        webSettings.setDefaultTextEncodingName("utf-8");
        //String str = HttpUtil.postHttpRequset(url,"");
       // myWebView.loadData(str, "text/html; charset=UTF-8", null
        myWebView.loadUrl(url);
        //View convertView = getLayoutInflater().inflate(R.layout.comment_line, myWebView, false);
        //vh = new ViewHolder();
       // convertView.setTag(vh);

       // myWebView.addView (convertView,myWebView.);

        ImageButton jump_to_comment =(ImageButton)findViewById(R.id.comment_button);
        final ObservableScrollView scrollView=(ObservableScrollView)findViewById(R.id.viewObj);
        jump_to_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.scrollTo(0,myWebView.getMeasuredHeight());
            }
        });
    }
    void Init_pinglunqu(){
        LinearLayout layout = (LinearLayout) findViewById(R.id.content_layout);
        for(int i=0;i<4;i++) {

            CommentLine view = new CommentLine(this);
            view.init(new CommentBean());
            layout.addView(view);
        }
        View view1=View.inflate(this,R.layout.comment_bottom,null);
        layout.addView(view1);

    }

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
}
