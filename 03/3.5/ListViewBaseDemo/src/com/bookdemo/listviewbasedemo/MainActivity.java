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
		getData();// �������
		listview = (ListView) findViewById(R.id.listviewsimple);
		// �趨�б����ѡ��ģʽΪ��ѡ
		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_single_choice, data);
		listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listview.setAdapter(adapter);
	}

	private void getData() {
		data = new ArrayList<String>();
		data.add("����");
		data.add("�Ϻ�");
		data.add("����");
		data.add("����");
		data.add("�人");
		data.add("�˲�");
		data.add("�ɶ�");
		data.add("����");
		data.add("����");
		data.add("����");
		data.add("���");
	}
}