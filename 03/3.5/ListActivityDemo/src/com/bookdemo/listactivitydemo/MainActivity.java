package com.bookdemo.listactivitydemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ListActivity;

public class MainActivity extends ListActivity {
	private String[] presidents = { "����", "����", "�Ϻ�", "����" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		ListView listview = getListView();
		// ���һ��TextView��Ϊ��ͷ
		TextView tvHeader = new TextView(MainActivity.this);
		tvHeader.setText("�����б�ͷ");
		listview.addHeaderView(tvHeader);
		// ���һ��TextView��Ϊ��β
		TextView tvFooter = new TextView(MainActivity.this);
		tvFooter.setText("�����б�β");
		listview.addFooterView(tvFooter);
		listview.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, presidents));

	}

	@Override
	protected void onListItemClick(ListView parent, View view, int position,
			long id) {
		// ע�⣬������˱�ͷ��position��λ��Ҳ������ͷ��β
		TextView textView = (TextView) view;
		Toast.makeText(this, "��ѡ�����" + textView.getText(), Toast.LENGTH_SHORT)
				.show();
	}
}