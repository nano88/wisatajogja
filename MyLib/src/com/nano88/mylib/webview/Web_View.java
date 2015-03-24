package com.nano88.mylib.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.nano88.mylib.R;

public class Web_View extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web__view);
		
		WebView myWebView = (WebView) findViewById(R.id.wv);
		myWebView.loadUrl("http://www.facebook.com/habib.inoeng");
	}
}
//jangan lupa tambahkan script berikut ke AndroidManifest
//<uses-permission android:name="android.permission.INTERNET" />