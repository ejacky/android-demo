package com.bookdemo.drawabledemo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class DrawableActivity extends Activity {
	private Button btnLayer, btnStateList, btnShape, btnClip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLayer = (Button) findViewById(R.id.btnLayer);
		btnStateList = (Button) findViewById(R.id.btnStateList);
		btnShape = (Button) findViewById(R.id.btnShape);
		btnClip = (Button) findViewById(R.id.btnClip);

		btnClip.setOnClickListener(click);
		btnShape.setOnClickListener(click);
		btnStateList.setOnClickListener(click);
		btnLayer.setOnClickListener(click);
	}

	private View.OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = null;
			switch (v.getId()) {
			case R.id.btnLayer:
				intent = new Intent(DrawableActivity.this,
						LayerDrawableActivity.class);
				startActivity(intent);
				break;
			case R.id.btnStateList:
				intent = new Intent(DrawableActivity.this,
						StateListDrawableActivity.class);
				startActivity(intent);
				break;
			case R.id.btnClip:
				intent = new Intent(DrawableActivity.this,
						ClipDrawableActivity.class);
				startActivity(intent);
				break;
			case R.id.btnShape:
				intent = new Intent(DrawableActivity.this,
						ShapeDrawableActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}

		}
	};
}
