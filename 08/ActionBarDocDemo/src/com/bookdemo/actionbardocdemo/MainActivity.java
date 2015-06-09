package com.bookdemo.actionbardocdemo;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnActionItem, btnNavigating, btnNavigatingxml,
			btnActionView, btnActionProvider, btnActionTab,btnActionList;
	private ShareActionProvider mShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnActionItem = (Button) findViewById(R.id.btnActionItem);
		btnNavigating = (Button) findViewById(R.id.btnNavigating);
		btnNavigatingxml = (Button) findViewById(R.id.btnNavigatingxml);
		btnActionView = (Button) findViewById(R.id.btnActionView);
		btnActionProvider = (Button) findViewById(R.id.btnActionProvider);
		btnActionTab = (Button) findViewById(R.id.btnActionTab);
		btnActionList = (Button) findViewById(R.id.btnActionList);

		btnActionList.setOnClickListener(click);
		btnActionTab.setOnClickListener(click);
		btnActionProvider.setOnClickListener(click);
		btnActionView.setOnClickListener(click);
		btnNavigatingxml.setOnClickListener(click);
		btnNavigating.setOnClickListener(click);
		btnActionItem.setOnClickListener(click);
		// ActionBar actionBar = getActionBar();
		// actionBar.setDisplayHomeAsUpEnabled(true);

		// btnTow = (Button) findViewById(R.id.btnTow);
		// btnTow.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// Intent intent = new Intent(MainActivity.this, TwoActivity.class);
		// startActivity(intent);
		// }
		// });
	}

	private View.OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = null;
			switch (v.getId()) {
			case R.id.btnActionItem:
				intent = new Intent(MainActivity.this, AddActionItems.class);
				startActivity(intent);
				break;
			case R.id.btnNavigating:
				intent = new Intent(MainActivity.this,
						ActionBarNavigating.class);
				startActivity(intent);
				break;
			case R.id.btnNavigatingxml:
				intent = new Intent(MainActivity.this,
						ActionBarNavigatingXML.class);
				startActivity(intent);
				break;
			case R.id.btnActionView:
				intent = new Intent(MainActivity.this, AddActionView.class);
				startActivity(intent);
				break;
			case R.id.btnActionProvider:
				intent = new Intent(MainActivity.this, AddActionProvider.class);
				startActivity(intent);
				break;
			case R.id.btnActionTab:
				intent = new Intent(MainActivity.this, AddActionTab.class);
				startActivity(intent);
				break;
			case R.id.btnActionList:
				intent = new Intent(MainActivity.this, ActionList.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	//
	// // Set up ShareActionProvider's default share intent
	// MenuItem shareItem = menu.findItem(R.id.action_share);
	//
	// mShareActionProvider =
	// (ShareActionProvider) shareItem.getActionProvider();
	// mShareActionProvider.setShareIntent(getDefaultIntent());
	//
	// return super.onCreateOptionsMenu(menu);
	// }

	// private Intent getDefaultIntent() {
	// Intent intent = new Intent(Intent.ACTION_SEND);
	// intent.setType("image/*");
	// return intent;
	// }
	//
	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// Toast.makeText(getApplicationContext(), item.getTitle(), 0).show();
	// return super.onOptionsItemSelected(item);
	// }
}
