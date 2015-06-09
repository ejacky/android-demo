package com.bookdemo.resourcesdemo;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class ResourcesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String strJava = getResources().getString(R.string.strcode);
		TextView tvRes = (TextView) findViewById(R.id.tvRes);
		tvRes.setText(strJava);

	}
}
