package com.example.mebee.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    /**
     * 每个活动被调用时先调用onCreate()方法，这是关于Android中Activity生命周期的知识
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    /**
     * 初始化
     */
    public void Init(){

        mWebView = (WebView) findViewById(R.id.WebView);//获取view

        WebSettings WebSet = mWebView.getSettings();    //获取webview设置
        WebSet.setJavaScriptEnabled(true);              //设置JavaScript支持

        mWebView.loadUrl("http://iamhouhuan.vicp.io:40710/h_listening/login/login.jsp");
                                                        //设置webview打开的链接

        mWebView.setWebViewClient(new WebViewClient(){  //设置不适用第三方浏览器打开网页
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });

    }


    /**
     * 从写返回键功能
     */
    @Override
    public void onBackPressed() {

        if(mWebView.canGoBack()) {
            mWebView.goBack();//返回上一页面
        }
        else {
            System.exit(0);//退出程序
        }
    }
}
