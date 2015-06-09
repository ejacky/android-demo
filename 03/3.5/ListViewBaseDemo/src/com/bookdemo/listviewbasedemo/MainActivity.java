package com.bookdemo.listviewbasedemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {
	private ListView listview;
	private ArrayAdapter<String> adapter;
	private List<String> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getData();// 填充数据
		listview = (ListView) findViewById(R.id.listviewsimple);
		// 设定列表项的选择模式为单选
		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_single_choice, data);
		listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listview.setAdapter(adapter);
	}

	private void getData() {
		data = new ArrayList<String>();
		data.add("北京");
		data.add("上海");
		data.add("广州");
		data.add("深圳");
		data.add("武汉");
		data.add("宜昌");
		data.add("成都");
		data.add("贵阳");
		data.add("杭州");
		data.add("济南");
		data.add("天津");
	}
}