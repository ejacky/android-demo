package com.bookdemo.actionbardocdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AddActionItems extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_calculator:
			Toast.makeText(AddActionItems.this, item.getTitle(), 0).show();
			return true;
		case R.id.menu_calendar:
			Toast.makeText(AddActionItems.this, item.getTitle(), 0).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
