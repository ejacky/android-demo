package com.bookdemo.xmlforsaxdemo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import com.bookdemo.http.HttpUtils;
import com.bookdemo.service.SaxService;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class XmlForSAXActivity extends Activity {
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
				//Android4.0+��Ҫ�����̷߳�������
				Thread thread=new Thread(new Runnable() {
					
					@Override
					public void run() {
						// ����XML�ĵ���λ��
						String path="http://192.168.1.103:8888/bookdemo/person.xml";
						//��ȡ�������ϵ�XML����ȡXML��
						InputStream inputStream=HttpUtils.getXML(path);
						try {
							//���������趨��Ҫ�����Ľڵ�
							List<HashMap<String, String>> list=SaxService.readXML(inputStream, "person");
							for(HashMap<String,String> map:list)
							{
								//��ӡ��LogCat��
								Log.i(TAG, map.toString());
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
