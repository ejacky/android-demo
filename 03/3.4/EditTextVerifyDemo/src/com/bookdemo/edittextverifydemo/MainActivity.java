package com.bookdemo.edittextverifydemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity {
	private Button btnValidation;
	private EditText etNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnValidation = (Button) findViewById(R.id.btnValidation);
		etNum = (EditText) findViewById(R.id.etNum);

		btnValidation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ��ȡ�ı����ֵ
				String num = etNum.getText().toString().trim();
				// ��֤�Ƿ���xyz
				if (!num.equals("xyz")) {
					etNum.setError("������xyz");
				}
			}
		});
	}

}
