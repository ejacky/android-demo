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

		// ΪSeekBar�󶨸ı���¼�������
		seekbar1.setOnSeekBarChangeListener(seekBarChange);
		seekbar2.setOnSeekBarChangeListener(seekBarChange);
	}

	private OnSeekBarChangeListener seekBarChange = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// ֹͣ�϶���ʱ�򴥷�
			if (seekBar.getId() == R.id.seekbar1) {
				textview1.setText("seekbar1ֹͣ�϶�");
			} else {
				textview1.setText("seekbar2ֹͣ�϶�");
			}
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// ��ʼ�϶���ʱ�򴥷�
			if (seekBar.getId() == R.id.seekbar1) {
				textview1.setText("seekbar1��ʼ�϶�");
			} else {
				textview1.setText("seekbar2��ʼ�϶�");
			}
		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// �϶��ı���ֵ��ʱ�򴥷�
			if (seekBar.getId() == R.id.seekbar1) {
				textview2.setText("seekbar1�ĵ�ǰλ���ǣ�" + progress);
			} else {
				textview2.setText("seekbar2�ĵ�ǰλ���ǣ�" + progress);
			}
		}
	};

}
