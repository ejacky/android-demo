package com.bookdemo.toastdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btnToast1, btnCustomToast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnToast1 = (Button) findViewById(R.id.btnToast1);
		btnCustomToast = (Button) findViewById(R.id.btnCustomToast);

		btnToast1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 实例化一个Toast对象
				Toast toast = Toast.makeText(MainActivity.this, "Toast提示消息",
						Toast.LENGTH_SHORT);
				// 设置显示的位置，为屏幕居中
				toast.setGravity(Gravity.CENTER, 0, 0);
				// 显示Toast消息提示
				toast.show();
			}
		});

		btnCustomToast.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// 实例化一个View对象
				View view = LayoutInflater.from(MainActivity.this).inflate(
						R.layout.toast_layout, null);
				TextView tv = (TextView) view.findViewById(R.id.text);
				tv.setText("自定义提示Toast");
				// 实例化一个Toast对象
				Toast toast = new Toast(MainActivity.this);
				// 设置Toast对象显示的View
				toast.setView(view);
				// 显示自定义的Toast消息提示
				toast.show();
			}
		});
	}
}
