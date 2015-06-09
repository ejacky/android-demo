package com.bookdemo.spinnerxmldatedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private Spinner spinnerBase1, spinnerBase2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spinnerBase1 = (Spinner) findViewById(R.id.spinnerBase1);
		spinnerBase2 = (Spinner) findViewById(R.id.spinnerBase2);
		spinnerBase1.setOnItemSelectedListener(select);
		spinnerBase2.setOnItemSelectedListener(select);
	}

	private AdapterView.OnItemSelectedListener select = new AdapterView.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// ѡ�����ʱ�򴥷�
			// ʹ��XMLֱ�Ӱ󶨵�ʱ��view�������ݵ���һ��TextView
			TextView textview = (TextView) view;
			Toast.makeText(MainActivity.this, textview.getText(),
					Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	};
}
