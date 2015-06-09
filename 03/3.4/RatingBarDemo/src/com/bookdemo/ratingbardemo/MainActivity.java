package com.bookdemo.ratingbardemo;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {
	private RatingBar rbRating, rbRating1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rbRating = (RatingBar) findViewById(R.id.rbRating);
		rbRating1 = (RatingBar) findViewById(R.id.rbRating1);
		// 手动设置第一个RatingBar的属性值
		rbRating.setMax(50);
		rbRating.setProgress(20);
		// 为RatingBar设定改变的事件监听器
		rbRating.setOnRatingBarChangeListener(change);
		rbRating1.setOnRatingBarChangeListener(change);
	}

	private RatingBar.OnRatingBarChangeListener change = new RatingBar.OnRatingBarChangeListener() {

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {
			// 分别显示Progress属性和rating属性的不同
			int progress = ratingBar.getProgress();
			Toast.makeText(MainActivity.this,
					"progress:" + progress + " rating :" + rating,
					Toast.LENGTH_SHORT).show();
		}
	};
}
