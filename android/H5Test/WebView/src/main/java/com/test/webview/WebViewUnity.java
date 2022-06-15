package com.test.webview;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.function.Function;

//import com.unity3d.player.UnityPlayerActivity;

public class WebViewUnity extends DialogFragment {
    public WebView mWebView;
    public String url;

    public WebViewUnity() {

    }

    static WebViewUnity newInstance(int num) {
        WebViewUnity f = new WebViewUnity();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveedInstanceState) {
        Dialog dialog = getDialog();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = com.google.android.material.R.style.Animation_Design_BottomSheetDialog;
        View view = inflater.inflate(com.test.webview.R.layout.layout_webview, container, false);
        mWebView = view.findViewById(R.id.wv_webview);

        initWebSetting(mWebView);
        mWebView.loadUrl(url);

        Log.d("H5", String.valueOf(mWebView));

        FloatingActionButton close_btn = view.findViewById(R.id.close_wv);
        close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        return view;
    }

    private void initWebSetting(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webSettings.setJavaScriptEnabled(true);

        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });

//        webSettings.setUserAgentString();
//        webSettings.setUserAgentString();
//        webView.setWebChromeClient();
//        webView.addJavascriptInterface(new AndroidJavaScriptObj(),"android");
    }

    public void ShowWebView() {
        //访问网页
//        webView.loadUrl("http://192.168.10.164:8080/index.html");
        mWebView.loadUrl("http://192.168.10.164:8080/index.html");
//        webView.loadUrl("http://webglreport.com/");

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*
        此方法在视图View已经创建后返回的，但是这个view 还没有添加到父级中。
        我们在这里可以重新设定view的各个数据，但是不能修改对话框最外层的ViewGroup的布局参数。
        因为这里的view还没添加到父级中，我们需要在下面onStart生命周期里修改对话框尺寸参数
         */
    }

    @Override
    public void onStart() {
        /*
            因为View在添加后,对话框最外层的ViewGroup并不知道我们导入的View所需要的的宽度。 所以我们需要在onStart生命周期里修改对话框尺寸参数
         */
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
//        getDialog().getWindow().setWindowAnimations(R.style.BottomDialog);
        super.onStart();
    }
}