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

		// 初始化DatePicker，并在日期改变的时候打印改变后的日期
		datePicker.init(2013, 8, 20, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				// 获取一个日历对象，并初始化为当前选中的时间
				Calendar calendar = Calendar.getInstance();
				calendar.set(year, monthOfYear, dayOfMonth);
				SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
				Toast.makeText(MainActivity.this,
						format.format(calendar.getTime()), Toast.LENGTH_SHORT)
						.show();
			}
		});
		
		// 设置TimePicker为24小时制
		timePicker.setIs24HourView(true);
		// 添加时间更改事件的监听器，在时间更改后打印出来
		timePicker
				.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
					@Override
					public void onTimeChanged(TimePicker view, int hourOfDay,
							int minute) {
						Toast.makeText(MainActivity.this,
								hourOfDay + "点" + minute + "分钟",
								Toast.LENGTH_SHORT).show();
					}
				});
	}

}
