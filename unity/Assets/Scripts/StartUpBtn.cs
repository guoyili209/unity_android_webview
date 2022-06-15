using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class StartUpBtn : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    public void ShowWebView(){
        var unityClass = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
        AndroidJavaObject currentActivity = unityClass.GetStatic<AndroidJavaObject>("currentActivity");
        var bridge = new AndroidJavaClass("com.test.webview.UnityBridge");
        bridge.CallStatic("InitActivity",currentActivity);
        bridge.CallStatic("ShowWebView","http://192.168.10.164:8080/index.html");
    }
}
