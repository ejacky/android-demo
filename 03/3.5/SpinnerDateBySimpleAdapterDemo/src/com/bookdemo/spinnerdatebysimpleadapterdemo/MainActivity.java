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
		// ����һ��SimpleAdapter���������������Ӧ��ϵ
		SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
				getData(), R.layout.items, new String[] { "ivLogo",
						"weather" }, new int[] { R.id.imageview,
						R.id.textview });
		// ��Adapter��Spinner��
		spinner.setAdapter(simpleAdapter);
		// Spinner��ѡ���¼��󶨡�
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// parentΪһ��Map�ṹ������
				Map<String, Object> map = (Map<String, Object>) parent
						.getItemAtPosition(position);
				Toast.makeText(MainActivity.this,
						map.get("weather").toString(),
						Toast.LENGTH_SHORT).show();

			}
		});
	}

	public List<Map<String, Object>> getData() {
		// ��������Դ
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// ÿ��Map�ṹΪһ�����ݣ�key��Adapter�ж����String�����ж����һһ��Ӧ��
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ivLogo", R.drawable.fine);
		map.put("weather", "����");
		list.add(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("ivLogo", R.drawable.cloudy);
		map2.put("weather", "����");
		list.add(map2);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("ivLogo", R.drawable.rain);
		map3.put("weather", "С��");
		list.add(map3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("ivLogo", R.drawable.snow);
		map4.put("weather", "Сѩ");
		list.add(map4);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("ivLogo", R.drawable.thundershower);
		map5.put("weather", "������");
		list.add(map5);
		return list;
	}
}
