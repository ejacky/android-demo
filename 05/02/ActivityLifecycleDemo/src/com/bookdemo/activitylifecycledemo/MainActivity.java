package com.bookdemo.activitylifecycledemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private final static String TAG = "main";
	private Button btnOpenDialog,btnOpenNewAct;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "---onCreate�������ص�---");

		btnOpenDialog = (Button) findViewById(R.id.btnOpenDialog);
		btnOpenDialog.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						DialogActivity.class);
				startActivity(intent);
			}
		});
		
		btnOpenNewAct = (Button) findViewById(R.id.btnOpenNewAct);
		btnOpenNewAct.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						NewActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onStart() {
		Log.i(TAG, "---onStart�������ص�---");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, "---onRestart�������ص�---");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, "---onResume�������ص�---");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, "---onPause�������ص�---");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, "---onStop�������ص�---");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, "---onDestroy�������ص�---");
		super.onDestroy();
	}
}
