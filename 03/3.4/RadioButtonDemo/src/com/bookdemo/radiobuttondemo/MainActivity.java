package com.bookdemo.radiobuttondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private RadioGroup rg_gender;
	private Button btn_Gender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rg_gender = (RadioGroup) findViewById(R.id.rg_gender);
		btn_Gender = (Button) findViewById(R.id.btn_Gender);
		btn_Gender.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 获取单选按钮的选项个数
				int len = rg_gender.getChildCount();
				String msgString = "";
				for (int i = 0; i < len; i++) {
					// RadioGroup中包含的子View就是一个RadioButton
					RadioButton radiobutton = (RadioButton) rg_gender.getChildAt(i);
					if (radiobutton.isChecked()) {
						// 如果被选中，则break循环，并且记录选中信息
						msgString = "您选择的性别是： "
								+ radiobutton.getText().toString();
						break;
					}
				}
				if (msgString.equals("")) {
					Toast.makeText(MainActivity.this,
							"请先选择性别！", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(MainActivity.this, msgString,
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

}
