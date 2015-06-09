package com.bookdemo.listactivitydemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ListActivity;

public class MainActivity extends ListActivity {
	private String[] presidents = { "北京", "深圳", "上海", "广州" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		ListView listview = getListView();
		// 添加一个TextView作为表头
		TextView tvHeader = new TextView(MainActivity.this);
		tvHeader.setText("城市列表头");
		listview.addHeaderView(tvHeader);
		// 添加一个TextView作为表尾
		TextView tvFooter = new TextView(MainActivity.this);
		tvFooter.setText("城市列表尾");
		listview.addFooterView(tvFooter);
		listview.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, presidents));

	}

	@Override
	protected void onListItemClick(ListView parent, View view, int position,
			long id) {
		// 注意，如果加了表头，position的位置也包含表头表尾
		TextView textView = (TextView) view;
		Toast.makeText(this, "你选择的是" + textView.getText(), Toast.LENGTH_SHORT)
				.show();
	}
}