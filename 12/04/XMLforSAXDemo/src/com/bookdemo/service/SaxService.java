package com.bookdemo.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.bookdemo.handler.MyHandler;

import android.util.Log;


public class SaxService {
	private static final String TAG="main";
	public SaxService() {
		
	}
	
	public static List<HashMap<String, String>> readXML(InputStream inputStream,String nodeName)
	{
		try {
			//ʵ����SAX������
			SAXParserFactory factory=SAXParserFactory.newInstance();
			//ʵ����SAX��������
			SAXParser sParser=factory.newSAXParser();
			//ʵ����DefaultHandler��������Ҫ�����Ľڵ�
			MyHandler myHandler=new MyHandler(nodeName);
			// ��ʼ����
			sParser.parse(inputStream, myHandler);
			// �������֮�󣬹ر���
			inputStream.close();
			Log.i(TAG, "�ɹ���������XML������");
			//���ؽ��������
			return myHandler.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}	
}
