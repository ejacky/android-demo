package com.bookdemo.listviewsimpleadapterdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	private ListView listview;
	private SimpleAdapter simpleAdapter;
	private List<Map<String, Object>> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = (ListView) findViewById(R.id.lvArray);
		// 填充数据
		putData();
		// 这里使用当前的布局资源作为ListView的模板。
		// 使用这种方式，SimpleAdapter会忽略ListView控件，仅以ListView之外的控件作为模板。
		simpleAdapter = new SimpleAdapter(MainActivity.this, data,
				R.layout.activity_main,
				new String[] { "date", "icon", "temp" }, new int[] {
						R.id.tvDate, R.id.ivIcon, R.id.tvTemp });
		listview.setAdapter(simpleAdapter);
	}

	private void putData() {
		data = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("date", "2014-1-1");
		map1.put("icon", R.drawable.fine);
		map1.put("temp", "-5~5°");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("date", "2014-1-2");
		map2.put("icon", R.drawable.rain);
		map2.put("temp", "-7~3°");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("date", "2014-1-3");
		map3.put("icon", R.drawable.thundershower);
		map3.put("temp", "-6~6°");
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("date", "2014-1-4");
		map4.put("icon", R.drawable.snow);
		map4.put("temp", "-9~2°");
		data.add(map1);
		data.add(map2);
		data.add(map3);
		data.add(map4);
	}

}
