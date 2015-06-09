package com.bookdemo.activitybasedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewActivity extends Activity {
	private Button btnFinish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);

		btnFinish = (Button) findViewById(R.id.btnFinish);
		btnFinish.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(NewActivity.this, "您关闭了新开启的Activity",
						Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}
}
