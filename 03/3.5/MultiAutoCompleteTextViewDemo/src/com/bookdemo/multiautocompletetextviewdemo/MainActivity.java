package com.bookdemo.multiautocompletetextviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {
	private MultiAutoCompleteTextView multiautotext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 获取布局文件中的控件对象
		multiautotext = (MultiAutoCompleteTextView) findViewById(R.id.multiautotext);

		// 设置数据源
		String[] autoStrings = new String[] { "New York", "Tokyo", "Beijing",
				"london", "Seoul Special", "Los Angeles" };
		// 设置ArrayAdapter，并且设定以单行下拉列表风格展示（第二个参数设定）。
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_dropdown_item_1line,
				autoStrings);

		// 设置MultiAutoCompleteTextView的Adapter
		multiautotext.setAdapter(adapter);
		// 设定选项间隔使用逗号分隔。
		multiautotext
				.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
}
