package com.bookdemo.actionbardocdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public class AddActionProvider extends Activity {

	private ShareActionProvider mShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_menuprovider, menu);

		MenuItem shareItem = menu.findItem(R.id.action_share);
		// ��ȡѡ���ShareActionProvider
		mShareActionProvider = (ShareActionProvider) shareItem
				.getActionProvider();
		// ָ�������Intent
		mShareActionProvider.setShareIntent(getDefaultIntent());

		return super.onCreateOptionsMenu(menu);
	}

	// ���÷���ͼƬ����
	private Intent getDefaultIntent() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");
		return intent;
	}
}
