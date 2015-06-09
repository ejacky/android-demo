package com.bookdemo.menudemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentActivity extends Activity {
	private TextView tvOptionmenu1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_optionmenu1);
		tvOptionmenu1=(TextView)findViewById(R.id.tvOptionMenu1);
		tvOptionmenu1.setText("Ê¹ÓÃIntentÌø×ª");
	}
}
