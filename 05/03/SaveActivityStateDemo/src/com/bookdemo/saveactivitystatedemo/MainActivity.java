package com.bookdemo.saveactivitystatedemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity {
	private EditText etUsername;
	private final static String TAG = "main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "---onCreate�������ص�---");

		etUsername = (EditText) findViewById(R.id.etUsername);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.i("main", "---onSaveInstanceState�������ص�---");
		outState.putString("username", etUsername.getText().toString());
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		Log.i("main", "---onRestoreInstanceState�������ص�---");
		etUsername.setText(savedInstanceState.getString("username"));
		super.onRestoreInstanceState(savedInstanceState);
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
