package com.bookdemo.activitybasereturncodedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class NewActivity extends Activity {
	private Button btnReturn;
	private RadioGroup rgGender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);

		rgGender = (RadioGroup) findViewById(R.id.rgGender);
		btnReturn = (Button) findViewById(R.id.btnReturn);
		btnReturn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				int flag = -1;
				for (int i = 0; i < rgGender.getChildCount(); i++) {
					// �ж��û�ѡ����Ա�
					RadioButton radioButton = (RadioButton) rgGender
							.getChildAt(i);
					if (radioButton.isChecked()) {
						if (radioButton.getText().toString().equals("male")) {
							flag = 1;
						} else if (radioButton.getText().toString()
								.equals("female")) {
							flag = 0;
						}
					}
				}
				if (flag == -1) {
					Toast.makeText(NewActivity.this, "��ѡ���Ա�",
							Toast.LENGTH_SHORT).show();
				}else{
					// ������Ӧ�룬������Activity
					setResult(flag);
					finish();
				}				
			}
		});
	}
}
