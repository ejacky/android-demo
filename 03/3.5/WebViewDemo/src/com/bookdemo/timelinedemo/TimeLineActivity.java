package com.bookdemo.timelinedemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TimeLineActivity extends Activity {
	private WebView wvShow;
	private static final String TAG = "main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_timeline);
		wvShow = (WebView) findViewById(R.id.wvShow);
		// 启用对JavaScript的支持
		wvShow.getSettings().setJavaScriptEnabled(true);

		final Activity activity = this;
		wvShow.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				Log.i(TAG, "onPageStarted被调用，开始请求网页，资源Url是"+url);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				Log.i(TAG, "onPageFinished被调用，结束请求网页，资源Url是"+url);
			}

			@Override
			public void onLoadResource(WebView view, String url) {
				super.onLoadResource(view, url);
				Log.i(TAG, "onLoadResource被调用，资源Url是"+url);
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Log.i(TAG, "onReceivedError被调用，请求网页发生错误");
			}
		});
		// 加载Web网页
		wvShow.loadUrl("http://wx.iyaohe.cc/timeline/timeline.html");
	}
}
