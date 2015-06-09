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
				// ʵ����һ��Toast����
				Toast toast = Toast.makeText(MainActivity.this, "Toast��ʾ��Ϣ",
						Toast.LENGTH_SHORT);
				// ������ʾ��λ�ã�Ϊ��Ļ����
				toast.setGravity(Gravity.CENTER, 0, 0);
				// ��ʾToast��Ϣ��ʾ
				toast.show();
			}
		});

		btnCustomToast.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ʵ����һ��View����
				View view = LayoutInflater.from(MainActivity.this).inflate(
						R.layout.toast_layout, null);
				TextView tv = (TextView) view.findViewById(R.id.text);
				tv.setText("�Զ�����ʾToast");
				// ʵ����һ��Toast����
				Toast toast = new Toast(MainActivity.this);
				// ����Toast������ʾ��View
				toast.setView(view);
				// ��ʾ�Զ����Toast��Ϣ��ʾ
				toast.show();
			}
		});
	}
}
