package com.bookdemo.autocomplettextviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
	private AutoCompleteTextView autotext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ��ȡ�����ļ��еĿؼ�����
		autotext = (AutoCompleteTextView) findViewById(R.id.autotext);

		// ��������Դ
		String[] autoStrings = new String[] { "New York", "Tokyo", "Beijing",
				"london", "Seoul Special", "Los Angeles" };
		// ����ArrayAdapter�������趨�Ե��������б���չʾ���ڶ��������趨����
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_dropdown_item_1line,
				autoStrings);
		// ����AutoCompleteTextView��Adapter
		autotext.setAdapter(adapter);
	}
}
