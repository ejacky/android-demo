package com.bookdemo.intentactiondemo;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OneActivity extends Activity {
	private TextView tvShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page);

		tvShow = (TextView) findViewById(R.id.tvShow);
		// 得到当前Intent对象
		Intent intent = getIntent();

		// 获得Intent的Action属性值
		String action = intent.getAction();
		String category = "";
		// 获取Category属性值
		Set<String> set = intent.getCategories();
		if (set != null) {
			Object[] objs = getIntent().getCategories().toArray();

			if (objs.length > 0) {
				category = (String) objs[0];
			}
		}
		tvShow.setText("这是Activity1 \n action：" + action + "\n" + "categroy："
				+ category);
	}
}
