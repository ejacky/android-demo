package com.bookdemo.intentactiondemo;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends Activity {
	private TextView tvShow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page);

		tvShow = (TextView) findViewById(R.id.tvShow);
		Intent intent = getIntent();

		String action = intent.getAction();
		String category = "";
		Set<String> set = intent.getCategories();
		if (set != null) {
			Object[] objs = getIntent().getCategories().toArray();

			if (objs.length > 0) {
				category = (String) objs[0];
			}
		}

		tvShow.setText("’‚ «Activity2 \n action£∫" + action + "\n" + "categroy£∫"
				+ category);
	}
}
