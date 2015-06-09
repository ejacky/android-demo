package com.bookdemo.videoviewdemo;

import java.io.File;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class VideoViewActivity extends Activity {
	private final String TAG = "main";
	private EditText et_path;
	private Button btn_play, btn_pause, btn_replay, btn_stop;
	private SeekBar seekBar;
	private VideoView vv_video;
	private boolean isPlaying;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videoview);

		seekBar = (SeekBar) findViewById(R.id.seekBar);
		et_path = (EditText) findViewById(R.id.et_path);
		vv_video = (VideoView) findViewById(R.id.vv_videoview);

		btn_play = (Button) findViewById(R.id.btn_play);
		btn_pause = (Button) findViewById(R.id.btn_pause);
		btn_replay = (Button) findViewById(R.id.btn_replay);
		btn_stop = (Button) findViewById(R.id.btn_stop);

		btn_play.setOnClickListener(click);
		btn_pause.setOnClickListener(click);
		btn_replay.setOnClickListener(click);
		btn_stop.setOnClickListener(click);

		// Ϊ���������ӽ��ȸ����¼�
		seekBar.setOnSeekBarChangeListener(change);
	}

	private OnSeekBarChangeListener change = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// ��������ֹͣ�޸ĵ�ʱ�򴥷�
			// ȡ�õ�ǰ�������Ŀ̶�
			int progress = seekBar.getProgress();
			if (vv_video != null && vv_video.isPlaying()) {
				// ���õ�ǰ���ŵ�λ��
				vv_video.seekTo(progress);
			}
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {

		}
	};
	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.btn_play:
				play(0);
				break;
			case R.id.btn_pause:
				pause();
				break;
			case R.id.btn_replay:
				replay();
				break;
			case R.id.btn_stop:
				stop();
				break;
			default:
				break;
			}
		}
	};

	/**
	 * ��ʼ����
	 * @param msec ���ŵ���ʼλ��
	 */
	protected void play(int msec) {
		Log.i(TAG, "��ȡ��Ƶ�ļ���ַ");
		String path = et_path.getText().toString().trim();
		File file = new File(path);
		if (!file.exists()) {
			Toast.makeText(this, "��Ƶ�ļ�·������", 0).show();
			return;
		}
		
		Log.i(TAG, "ָ����ƵԴ·��");
		vv_video.setVideoPath(file.getAbsolutePath());
		Log.i(TAG, "��ʼ����");
		vv_video.start();
		
		// ���ճ�ʼλ�ò���
		vv_video.seekTo(msec);
		
		// ����ƵԴװ�����֮�󣬼�¼��Ƶ�����ʱ�������������̼߳�¼����
		vv_video.setOnPreparedListener(new OnPreparedListener() {
			
			@Override
			public void onPrepared(MediaPlayer mp) {
				// ���ý�������������Ϊ��Ƶ������󲥷�ʱ��
				seekBar.setMax(vv_video.getDuration());
				// ��ʼ�̣߳����½������Ŀ̶�
				new Thread() {

					@Override
					public void run() {
						try {
							isPlaying = true;
							while (isPlaying) {
								// ������ڲ��ţ�ÿ500�������һ�ν�����
								int current = vv_video.getCurrentPosition();
								seekBar.setProgress(current);
								Log.i(TAG, current+"");
								sleep(500);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		});		
		
		// ����֮�����ò��Ű�ť������
		btn_play.setEnabled(false);

		vv_video.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// �ڲ�����ϱ��ص�
				btn_play.setEnabled(true);
			}
		});

		vv_video.setOnErrorListener(new OnErrorListener() {

			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				// �������������²���
				play(0);
				isPlaying = false;
				return false;
			}
		});
	}

	/**
	 * ���¿�ʼ����
	 */
	protected void replay() {
		if (vv_video != null && vv_video.isPlaying()) {
			// ��ԭ���Ž��ȵ�
			vv_video.seekTo(0);
			Toast.makeText(this, "���²���", 0).show();
			btn_pause.setText("��ͣ");
			return;
		}
		isPlaying = false;
		play(0);

	}

	/**
	 * ��ͣ�����
	 */
	protected void pause() {
		if (btn_pause.getText().toString().trim().equals("����")) {
			btn_pause.setText("��ͣ");
			vv_video.start();
			Toast.makeText(this, "��������", 0).show();
			return;
		}
		if (vv_video != null && vv_video.isPlaying()) {
			vv_video.pause();
			btn_pause.setText("����");
			Toast.makeText(this, "��ͣ����", 0).show();
		}
	}

	/**
	 * ֹͣ����
	 */
	protected void stop() {
		// �ж��Ƿ��ڲ���
		if (vv_video != null && vv_video.isPlaying()) {
			// ֹͣ����
			vv_video.stopPlayback();
			btn_play.setEnabled(true);
			isPlaying = false;
		}
	}
}