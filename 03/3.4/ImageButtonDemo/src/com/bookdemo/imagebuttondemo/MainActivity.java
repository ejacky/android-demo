package com.bookdemo.imagebuttondemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private ImageButton ibtn_click;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ibtn_click = (ImageButton) findViewById(R.id.ibtn_click);
		ibtn_click.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "ImageButton±»µã»÷ÁË",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
