package com.bookdemo.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

import com.bookdemo.domain.Person;


public class PullXMLTools {
	private static final String TAG="main";
	public PullXMLTools() {
		
	}

	/**
	 * �ѷ��������ݹ���XML�����ݽ����ɶ��� 
	 * @param inputStream  XML��
	 * @param encode  �����ʽ
	 * @return
	 */
	public static List<Person> parserXML(InputStream inputStream, String encode)
			throws XmlPullParserException, IOException {
		List<Person> list = null;
		Person person = null;
		//���һ��XMLPULL�������ʵ��
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		//���һ��XML��������ʵ��
		XmlPullParser parser = factory.newPullParser();
		//���ý����������룬ʹ��inputStream��ʽ���ݡ�
		parser.setInput(inputStream, encode);
		//�жϵ�ǰ���¼�����
		int eventType = parser.getEventType();
		//ѭ����ȡ��֪���¼�����Ϊ�ĵ�����
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			// ͨ���ж��¼�������ѡ��ִ�в�ͬ�Ĵ���
			case XmlPullParser.START_DOCUMENT:
				//�ĵ���ʼ��ʱ��ʵ����list�������ڴ��XML�����������
				list=new ArrayList<Person>();				
				break;
			case XmlPullParser.START_TAG:
				//��ȡ��ǩ��ʱ�򴥷�����¼�
				if(parser.getName().equals("person"))
				{
					//�����ǰ��ȡ���Ľڵ���person�ڵ㣬��ôʵ����һ��person����
					person=new Person();
					//���person�ڵ��е�����ID
					int id=Integer.parseInt(parser.getAttributeValue(0));
					person.setId(id);
				}
				else if(parser.getName().equals("name"))
				{
					if(person!=null)
					{
						//���name�ڵ����һ��element Text
						String name=parser.nextText();
						person.setName(name);
					}
				}
				else if(parser.getName().equals("age"))
				{
					if(person!=null)
					{
						//���age�ڵ����һ��element Text
						int age=Integer.parseInt(parser.nextText());
						person.setAge(age);
					}
				}
				break;
			case XmlPullParser.END_TAG:
				if(parser.getName().equals("person"))
				{
					//���������ڵ��ǩ�����Ϊperson�����֮ǰ��ȡ����person�������list�У�
					//�����ƿ�person����
					list.add(person);
					person=null;
				}
				break;
			}
			//��ȡ
			eventType=parser.next();
		}
		Log.i(TAG, "�ɹ���������XML������");
		return list;
	}
}
