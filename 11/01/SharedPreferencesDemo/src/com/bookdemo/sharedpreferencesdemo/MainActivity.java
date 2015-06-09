package com.bookdemo.sharedpreferencesdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MainActivity extends Activity {
	private Button btnWrite, btnRead;
	private EditText etName, etAge, etHeight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etName = (EditText) findViewById(R.id.etName);
		etAge = (EditText) findViewById(R.id.etAge);
		etHeight = (EditText) findViewById(R.id.etHeight);

		btnWrite = (Button) findViewById(R.id.btnWrite);
		btnRead = (Button) findViewById(R.id.btnRead);

		btnWrite.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// �õ�ҳ��ؼ�������ֵ
				String name = etName.getText().toString();
				int age = Integer.parseInt(etAge.getText().toString());
				float height = Float.parseFloat(etHeight.getText().toString());

				// ��ȡSharedPreferences����
				SharedPreferences preferences = getSharedPreferences(
						"userInfo", MODE_WORLD_WRITEABLE);
				// ��ȡEditor����
				Editor editor = preferences.edit();
				editor.putString("name", name);
				editor.putInt("age", age);
				editor.putFloat("height", height);
				// �ύ����
				editor.commit();
				Toast.makeText(getApplicationContext(), "д��ɹ�",
						Toast.LENGTH_SHORT).show();
			}
		});

		btnRead.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��ȡSharedPreferences����
				SharedPreferences preferences = getSharedPreferences(
						"userInfo", MODE_WORLD_WRITEABLE);
				// ��ȡ����
				String name = preferences.getString("name", "");
				int age = preferences.getInt("age", -1);
				float height = preferences.getFloat("height", -1);
				// ��ʾ��ȡ������
				Toast.makeText(getApplicationContext(),
						"name:" + name + "\nage:" + age + "\nheight:" + height,
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}
