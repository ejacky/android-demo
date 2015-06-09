package com.bookdemo.actionbardocdemo;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class ActionList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		// 通过字符串数组，创建SpinnerAdapter数据适配器
		SpinnerAdapter adapter = ArrayAdapter.createFromResource(
				getApplicationContext(), R.array.arr_city,
				android.R.layout.simple_spinner_dropdown_item);

		ActionBar actionBar = getActionBar();
		// 指定当前ActionBar支持下拉导航
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		// 指定下拉导航的数据以及选择回调事件监听器
		actionBar.setListNavigationCallbacks(adapter,
				new OnNavigationListener() {

					@Override
					public boolean onNavigationItemSelected(int itemPosition,
							long itemId) {
						String[] arr_city = getResources().getStringArray(
								R.array.arr_city);
						Toast.makeText(ActionList.this,
								"您选择的城市：" + arr_city[itemPosition], 0).show();
						return true;
					}
				});
	}
}
