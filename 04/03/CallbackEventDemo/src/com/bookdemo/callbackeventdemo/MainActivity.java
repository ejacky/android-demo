package com.bookdemo.callbackeventdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button OpenCallbackBasePage, OpenCallbackCastPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		OpenCallbackBasePage = (Button) findViewById(R.id.OpenCallbackBasePage);
		OpenCallbackCastPage = (Button) findViewById(R.id.OpenCallbackCastPage);

		OpenCallbackBasePage.setOnClickListener(click);
		OpenCallbackCastPage.setOnClickListener(click);
	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent;
			switch (v.getId()) {
			case R.id.OpenCallbackBasePage:
				intent=new Intent(MainActivity.this, CallbackEventBaseActivity.class);
				startActivity(intent);
				break;
			case R.id.OpenCallbackCastPage:
				intent=new Intent(MainActivity.this, CallbackEventCastActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}

		}
	};
}
