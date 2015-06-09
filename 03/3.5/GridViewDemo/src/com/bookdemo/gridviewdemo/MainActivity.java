package com.bookdemo.gridviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	private ImageView imageView;
	// 构建一个Drawable ID数组
	private int[] resIds = new int[] { R.drawable.bmp1, R.drawable.bmp2,
			R.drawable.bmp3, R.drawable.bmp4, R.drawable.bmp5, R.drawable.bmp6,
			R.drawable.bmp7, R.drawable.bmp8, R.drawable.bmp9 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView gridView = (GridView) findViewById(R.id.gridview);
		imageView = (ImageView) findViewById(R.id.iamgeview);
		
		// 构造数据
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < resIds.length; i++) {
			Map<String, Object> cell = new HashMap<String, Object>();
			cell.put("imageview", resIds[i]);
			list.add(cell);
		}
		
		// 构造Adapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
				list, R.layout.cell, new String[] { "imageview" },
				new int[] { R.id.ivCell });
		// 为GridView指定Adapter
		gridView.setAdapter(simpleAdapter);
		// 为GridView指定点击项事件监听器
		gridView.setOnItemClickListener(itemClick);
		imageView.setImageResource(resIds[0]);
	}
	
	private OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// 点击后，修改预览图
			imageView.setImageResource(resIds[position]);
		}
	};
}
