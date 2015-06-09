package com.bookdemo.seekbardemo;

import android.os.Bundle;
import android.app.Activity;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textview1, textview2;
	private SeekBar seekbar1, seekbar2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		seekbar1 = (SeekBar) findViewById(R.id.seekbar1);
		seekbar2 = (SeekBar) findViewById(R.id.seekbar2);

		// 为SeekBar绑定改变的事件监听器
		seekbar1.setOnSeekBarChangeListener(seekBarChange);
		seekbar2.setOnSeekBarChangeListener(seekBarChange);
	}

	private OnSeekBarChangeListener seekBarChange = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// 停止拖动的时候触发
			if (seekBar.getId() == R.id.seekbar1) {
				textview1.setText("seekbar1停止拖动");
			} else {
				textview1.setText("seekbar2停止拖动");
			}
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// 开始拖动的时候触发
			if (seekBar.getId() == R.id.seekbar1) {
				textview1.setText("seekbar1开始拖动");
			} else {
				textview1.setText("seekbar2开始拖动");
			}
		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// 拖动改变其值的时候触发
			if (seekBar.getId() == R.id.seekbar1) {
				textview2.setText("seekbar1的当前位置是：" + progress);
			} else {
				textview2.setText("seekbar2的当前位置是：" + progress);
			}
		}
	};

}
