package com.bookdemo.datetimepickerdemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	private DatePicker datePicker;
	private TimePicker timePicker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		datePicker = (DatePicker) findViewById(R.id.dpPicker);
		timePicker = (TimePicker) findViewById(R.id.tpPicker);

		// ��ʼ��DatePicker���������ڸı��ʱ���ӡ�ı�������
		datePicker.init(2013, 8, 20, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				// ��ȡһ���������󣬲���ʼ��Ϊ��ǰѡ�е�ʱ��
				Calendar calendar = Calendar.getInstance();
				calendar.set(year, monthOfYear, dayOfMonth);
				SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��");
				Toast.makeText(MainActivity.this,
						format.format(calendar.getTime()), Toast.LENGTH_SHORT)
						.show();
			}
		});
		
		// ����TimePickerΪ24Сʱ��
		timePicker.setIs24HourView(true);
		// ���ʱ������¼��ļ���������ʱ����ĺ��ӡ����
		timePicker
				.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
					@Override
					public void onTimeChanged(TimePicker view, int hourOfDay,
							int minute) {
						Toast.makeText(MainActivity.this,
								hourOfDay + "��" + minute + "����",
								Toast.LENGTH_SHORT).show();
					}
				});
	}

}
