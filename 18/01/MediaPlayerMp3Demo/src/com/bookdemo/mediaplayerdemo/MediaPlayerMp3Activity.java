package com.bookdemo.mediaplayerdemo;

import java.io.File;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MediaPlayerMp3Activity extends Activity {
	private EditText et_path;
	private Button btn_play, btn_pause, btn_replay, btn_stop;
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et_path = (EditText) findViewById(R.id.et_path);
		btn_play = (Button) findViewById(R.id.btn_play);
		btn_pause = (Button) findViewById(R.id.btn_pause);
		btn_replay = (Button) findViewById(R.id.btn_replay);
		btn_stop = (Button) findViewById(R.id.btn_stop);

		btn_play.setOnClickListener(click);
		btn_pause.setOnClickListener(click);
		btn_replay.setOnClickListener(click);
		btn_stop.setOnClickListener(click);

	}

	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case R.id.btn_play:
				play();
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
	 * ��������
	 */
	protected void play() {
		String path = et_path.getText().toString().trim();
		File file = new File(path);
		if (file.exists() && file.length() > 0) {
			try {
				mediaPlayer = new MediaPlayer();
				// ����ָ������ý���ַ
				mediaPlayer.setDataSource(path);
				// ������Ƶ��������
				mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

				// ͨ���첽�ķ�ʽװ��ý����Դ
				mediaPlayer.prepareAsync();
				mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
					@Override
					public void onPrepared(MediaPlayer mp) {
						// װ����� ��ʼ������ý��
						mediaPlayer.start();
						Toast.makeText(MediaPlayerMp3Activity.this, "��ʼ����", 0).show();
						// �����ظ����ţ��Ѳ��Ű�ť����Ϊ������
						btn_play.setEnabled(false);
					}
				});
				// ����ѭ������
				// mediaPlayer.setLooping(true);
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

					@Override
					public void onCompletion(MediaPlayer mp) {
						// �ڲ�����ϱ��ص�
						btn_play.setEnabled(true);
					}
				});

				mediaPlayer.setOnErrorListener(new OnErrorListener() {

					@Override
					public boolean onError(MediaPlayer mp, int what, int extra) {
						// ��������������²���
						replay();
						return false;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "����ʧ��", 0).show();
			}
		} else {
			Toast.makeText(this, "�ļ�������", 0).show();
		}

	}

	/**
	 * ��ͣ
	 */
	protected void pause() {
		if (btn_pause.getText().toString().trim().equals("����")) {			
			// ����
			mediaPlayer.start();
			btn_pause.setText("��ͣ");
			Toast.makeText(this, "��������", 0).show();
			return;
		}
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			// ��ͣ
			mediaPlayer.pause();
			btn_pause.setText("����");
			Toast.makeText(this, "��ͣ����", 0).show();
		}

	}

	/**
	 * ���²���
	 */
	protected void replay() {
		// �ж��Ƿ����ڲ���
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			// �Ѳ��Ž�������Ϊ0
			mediaPlayer.seekTo(0);
			Toast.makeText(this, "���²���", 0).show();
			btn_pause.setText("��ͣ");
			return;
		}
		// ���²���
		play();
	}

	/**
	 * ֹͣ����
	 */
	protected void stop() {
		// �ж��Ƿ����ڲ���
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			// ֹͣ����
			mediaPlayer.stop();
			// �ͷ���Դ
			mediaPlayer.release();
			mediaPlayer = null;
			btn_play.setEnabled(true);
			Toast.makeText(this, "ֹͣ����", 0).show();
		}
	}

	@Override
	protected void onDestroy() {
		// ��activity������ʱ�������Դ
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			// ֹͣ����
			mediaPlayer.stop();
			// �ͷ���Դ
			mediaPlayer.release();
			mediaPlayer = null;
		}
		super.onDestroy();
	}
}
