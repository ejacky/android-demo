package com.bookdemo.actionbardocdemo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class ActionBarNavigating extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		
		ActionBar actionBar = getActionBar();
		// 指定ActionBar的标题
		actionBar.setTitle("返回");
		// 指定ActionBar的图标
		actionBar.setIcon(R.drawable.edge);
		// 指定ActionBar的图标可点击
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// 响应ActionBar图标的点击事件
		if (item.getItemId() == android.R.id.home) {
			Intent intent = new Intent(ActionBarNavigating.this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
