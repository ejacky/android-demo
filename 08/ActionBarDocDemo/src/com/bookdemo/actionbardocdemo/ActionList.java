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
		// ͨ���ַ������飬����SpinnerAdapter����������
		SpinnerAdapter adapter = ArrayAdapter.createFromResource(
				getApplicationContext(), R.array.arr_city,
				android.R.layout.simple_spinner_dropdown_item);

		ActionBar actionBar = getActionBar();
		// ָ����ǰActionBar֧����������
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		// ָ�����������������Լ�ѡ��ص��¼�������
		actionBar.setListNavigationCallbacks(adapter,
				new OnNavigationListener() {

					@Override
					public boolean onNavigationItemSelected(int itemPosition,
							long itemId) {
						String[] arr_city = getResources().getStringArray(
								R.array.arr_city);
						Toast.makeText(ActionList.this,
								"��ѡ��ĳ��У�" + arr_city[itemPosition], 0).show();
						return true;
					}
				});
	}
}
