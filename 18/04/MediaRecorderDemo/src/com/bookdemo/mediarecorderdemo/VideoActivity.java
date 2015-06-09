package com.bookdemo.mediarecorderdemo;

import java.io.File;
import android.app.Activity;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class VideoActivity extends Activity {
	private Button btn_VideoStart, btn_VideoStop;
	private SurfaceView sv_view;
	private boolean isRecording;
	private MediaRecorder mediaRecorder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);

		btn_VideoStart = (Button) findViewById(R.id.btn_VideoStart);
		btn_VideoStop = (Button) findViewById(R.id.btn_VideoStop);
		sv_view = (SurfaceView) findViewById(R.id.sv_view);

		btn_VideoStop.setEnabled(false);

		btn_VideoStart.setOnClickListener(click);
		btn_VideoStop.setOnClickListener(click);
		
		// ����Surface��ά���Լ��Ļ����������Android3.0�����豸֧��
		// sv_view.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	private View.OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_VideoStart:
				start();
				break;
			case R.id.btn_VideoStop:
				stop();
				break;
			default:
				break;
			}
		}
	};

	protected void start() {
		try {
			// ָ��¼����Ƶ�ļ���ŵĵ�ַ
			File file = new File("/sdcard/video.mp4");
			if (file.exists()) {
				// ����ļ����ڣ�ɾ��������ʾ���뱣֤�豸��ֻ��һ��¼���ļ�
				file.delete();
			}
			
			mediaRecorder = new MediaRecorder();
			// ��ʼǰ��������
			mediaRecorder.reset();
			// ������Ƶ¼��Դ
			mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			// ������Ƶͼ���¼��Դ
			mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
			// ����¼��ý��������ʽ
			mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
			// ������Ƶ�ı����ʽ
			mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
			// ������Ƶ�ı����ʽ
			mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
			// ������Ƶ�Ĳ����ʣ�ÿ��4֡
			mediaRecorder.setVideoFrameRate(4);
			// ����¼����Ƶ�ļ������·��
			mediaRecorder.setOutputFile(file.getAbsolutePath());
			// ���ò�����Ƶͼ���Ԥ������
			mediaRecorder.setPreviewDisplay(sv_view.getHolder().getSurface());
			
			mediaRecorder.setOnErrorListener(new OnErrorListener() {
				
				@Override
				public void onError(MediaRecorder mr, int what, int extra) {
					// ��������ֹͣ¼�Ʋ��ͷ���Դ
					mediaRecorder.stop();
					mediaRecorder.release();
					mediaRecorder = null;
					isRecording=false;
					btn_VideoStart.setEnabled(true);
					btn_VideoStop.setEnabled(false);
					Toast.makeText(VideoActivity.this, "¼�Ƴ���", 0).show();
				}
			});
			
			// ׼��¼��
			mediaRecorder.prepare();
			// ��ʼ¼��
			mediaRecorder.start();

			btn_VideoStart.setEnabled(false);
			btn_VideoStop.setEnabled(true);
			isRecording = true;
			Toast.makeText(VideoActivity.this, "��ʼ¼��", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ֹͣ¼��
	 */
	protected void stop() {
		if (isRecording) {
			// �������¼�ƣ�ֹͣ���ͷ���Դ
			mediaRecorder.stop();
			mediaRecorder.release();
			mediaRecorder = null;
			isRecording=false;
			btn_VideoStart.setEnabled(true);
			btn_VideoStop.setEnabled(false);
			Toast.makeText(VideoActivity.this, "ֹͣ¼�񣬲������ļ�", 0).show();
		}
	}

	@Override
	protected void onDestroy() {
		if (isRecording) {
			// Ӧ�����ٵ�ʱ���������¼�ƣ���ֹͣ�����ͷ���Դ
			mediaRecorder.stop();
			mediaRecorder.release();
			mediaRecorder = null;
		}
		super.onDestroy();
	}
}
