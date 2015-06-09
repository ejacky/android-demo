package com.bookdemo.buttonbasedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private Button btn_text, btn_img, btn_imgtext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_text = (Button) findViewById(R.id.btn_text);
		btn_img = (Button) findViewById(R.id.btn_img);
		btn_imgtext = (Button) findViewById(R.id.btn_imgtext);
		
		btn_text.setOnClickListener(click);
		btn_img.setOnClickListener(click);
		btn_imgtext.setOnClickListener(click);
	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this, "按钮被点击了", Toast.LENGTH_SHORT)
					.show();
		}
	};
}
