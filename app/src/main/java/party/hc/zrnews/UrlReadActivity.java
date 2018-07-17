package party.hc.zrnews;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class UrlReadActivity extends AppCompatActivity  {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_read);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String url=getIntent().getStringExtra("url");
        myWebView=(WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient(){
        });
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //设置缓存
        webSettings.setJavaScriptEnabled(true);//设置能够解析Javascript
        webSettings.setDomStorageEnabled(true);//设置适应Html5 //重点是这个设置
        myWebView.loadUrl(url);
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
