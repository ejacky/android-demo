package com.bookdemo.xmlforpull;

import java.io.InputStream;
import java.util.List;
import com.bookdemo.Http.HttpUtils;
import com.bookdemo.domain.Person;
import com.bookdemo.parser.PullXMLTools;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class XmlForPullActivity extends Activity {
	private static final String TAG="main";
	private Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn=(Button)findViewById(R.id.btn);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Thread thread=new Thread(new Runnable() {					
					@Override
					public void run() {
						String path="http://192.168.1.103:8888/bookdemo/person.xml";
						// 获取网络XML文件的数据流
						InputStream inputStream=HttpUtils.getXML(path);
						List<Person> list=null;
						try {
							list = PullXMLTools.parserXML(inputStream, "utf-8");
							for(Person person:list)
							{
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
