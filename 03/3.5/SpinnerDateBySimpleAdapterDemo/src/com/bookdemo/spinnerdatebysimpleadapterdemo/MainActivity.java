package com.bookdemo.spinnerdatebysimpleadapterdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spinner = (Spinner) findViewById(R.id.spinnerAdapter);
		// 声明一个SimpleAdapter独享，设置数据与对应关系
		SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
				getData(), R.layout.items, new String[] { "ivLogo",
						"weather" }, new int[] { R.id.imageview,
						R.id.textview });
		// 绑定Adapter到Spinner中
		spinner.setAdapter(simpleAdapter);
		// Spinner被选中事件绑定。
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// parent为一个Map结构的数据
				Map<String, Object> map = (Map<String, Object>) parent
						.getItemAtPosition(position);
				Toast.makeText(MainActivity.this,
						map.get("weather").toString(),
						Toast.LENGTH_SHORT).show();

			}
		});
	}

	public List<Map<String, Object>> getData() {
		// 生成数据源
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 每个Map结构为一条数据，key与Adapter中定义的String数组中定义的一一对应。
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ivLogo", R.drawable.fine);
		map.put("weather", "晴天");
		list.add(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("ivLogo", R.drawable.cloudy);
		map2.put("weather", "多云");
		list.add(map2);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("ivLogo", R.drawable.rain);
		map3.put("weather", "小雨");
		list.add(map3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("ivLogo", R.drawable.snow);
		map4.put("weather", "小雪");
		list.add(map4);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("ivLogo", R.drawable.thundershower);
		map5.put("weather", "雷阵雨");
		list.add(map5);
		return list;
	}
}
