package com.bookdemo.videoviewdemo;

import java.io.File;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class ControllerActivity extends Activity {
	private VideoView vv_video;
	private MediaController mController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_controller);
		vv_video=(VideoView) findViewById(R.id.vv_video);
		// 实例化MediaController
		mController=new MediaController(this);
		File file=new File("/sdcard/ykzzldx.mp4");
		if(file.exists()){
			// 设置播放视频源的路径
			vv_video.setVideoPath(file.getAbsolutePath());
			// 为VideoView指定MediaController
			vv_video.setMediaController(mController);
			// 为MediaController指定控制的VideoView
			mController.setMediaPlayer(vv_video);
			// 增加监听上一个和下一个的切换事件，默认这两个按钮是不显示的
			mController.setPrevNextListeners(new OnClickListener() {
				
				@Override
				public void onClick(View v) {					
					Toast.makeText(ControllerActivity.this, "下一个",0).show();
				}
			}, new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(ControllerActivity.this, "上一个",0).show();
				}
			});
		}
	}
}
