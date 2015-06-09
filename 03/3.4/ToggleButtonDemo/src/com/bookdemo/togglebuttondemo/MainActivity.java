package com.bookdemo.togglebuttondemo;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.app.Activity;

public class MainActivity extends Activity {
	private ToggleButton tbtn_toggle;
	private LinearLayout llayout_orient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tbtn_toggle = (ToggleButton) findViewById(R.id.tbtn_toggle);
		llayout_orient = (LinearLayout) this.findViewById(R.id.llayout_orient);
		tbtn_toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// 通过判断是否选中，来设置LinearLayout的横向纵向排列
				if (isChecked) {
					llayout_orient.setOrientation(LinearLayout.VERTICAL);
				} else {
					llayout_orient.setOrientation(LinearLayout.HORIZONTAL);
				}
			}
		});
	}

}
