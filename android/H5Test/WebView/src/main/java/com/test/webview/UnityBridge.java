package com.test.webview;

import android.app.Activity;
import android.content.Intent;

public class UnityBridge {

    public static Activity mainActivity;

    public static void InitActivity(Activity m) {
        mainActivity = m;
    }

    public static void ShowWebView(String url) {
        Intent intent = new Intent(mainActivity.getBaseContext(), WebViewActivity.class);
        intent.putExtra("url", url);
        mainActivity.startActivity(intent);
        mainActivity.overridePendingTransition(R.anim.tanslate_in_down,R.anim.no_animation);
    }
}
