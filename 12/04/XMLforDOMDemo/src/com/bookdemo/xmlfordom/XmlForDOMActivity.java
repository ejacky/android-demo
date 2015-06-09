package com.bookdemo.xmlfordom;

import java.io.InputStream;
import java.util.List;
import com.bookdemo.domain.Person;
import com.bookdemo.http.HttpUtils;
import com.bookdemo.service.DomService;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class XmlForDOMActivity extends Activity {
	private static final String TAG="main";
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button=(Button)findViewById(R.id.btn);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Android 4.0+不能在主线程中访问网络
				Thread thread=new Thread(new Runnable() {					
					@Override
					public void run() {
						try {
							String path="http://192.168.1.103:8888/bookdemo/person.xml";
							// 获取网络XML文件的数据流
							InputStream inputStream=HttpUtils.getXML(path);
							List<Person> list=DomService.getPersons(inputStream);
							for(Person person:list)
							{
								//以日志的形式打印对象内容
								Log.i(TAG, person.toString());					
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}					
				});
				thread.start();
			}			
		});		
	}
}
