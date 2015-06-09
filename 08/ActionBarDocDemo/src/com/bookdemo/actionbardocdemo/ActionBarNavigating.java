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
		// ָ��ActionBar�ı���
		actionBar.setTitle("����");
		// ָ��ActionBar��ͼ��
		actionBar.setIcon(R.drawable.edge);
		// ָ��ActionBar��ͼ��ɵ��
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// ��ӦActionBarͼ��ĵ���¼�
		if (item.getItemId() == android.R.id.home) {
			Intent intent = new Intent(ActionBarNavigating.this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
