package com.test.h5webview;


import android.app.Activity;
import android.os.Bundle;

public class WebViewActivity extends Activity {

    public static WebViewUnity webViewUnity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        String url = this.getIntent().getStringExtra("url");
        if (webViewUnity == null) {
            webViewUnity = new WebViewUnity();
        }
//        webViewUnity.url = "http://www.baidu.com";
        webViewUnity.url = url;
        webViewUnity.show(getFragmentManager(), "main");

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent mainIntent = new Intent(SplashScreen.this,   AndroidNews.class);
//                WebViewActivity.this.startActivity(mainIntent);
//                WebViewActivity.this.finish();
//
//            }
//        }, 3000);
    }
}