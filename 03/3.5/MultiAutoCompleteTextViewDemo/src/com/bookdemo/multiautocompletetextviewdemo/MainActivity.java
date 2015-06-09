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

		// ��ȡ�����ļ��еĿؼ�����
		multiautotext = (MultiAutoCompleteTextView) findViewById(R.id.multiautotext);

		// ��������Դ
		String[] autoStrings = new String[] { "New York", "Tokyo", "Beijing",
				"london", "Seoul Special", "Los Angeles" };
		// ����ArrayAdapter�������趨�Ե��������б���չʾ���ڶ��������趨����
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_dropdown_item_1line,
				autoStrings);

		// ����MultiAutoCompleteTextView��Adapter
		multiautotext.setAdapter(adapter);
		// �趨ѡ����ʹ�ö��ŷָ���
		multiautotext
				.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
}
