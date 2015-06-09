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
	 * 把服务器传递过的XML流数据解析成对象 
	 * @param inputStream  XML流
	 * @param encode  编码格式
	 * @return
	 */
	public static List<Person> parserXML(InputStream inputStream, String encode)
			throws XmlPullParserException, IOException {
		List<Person> list = null;
		Person person = null;
		//获得一个XMLPULL工厂类的实例
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		//获得一个XML解析器的实例
		XmlPullParser parser = factory.newPullParser();
		//设置解析器的输入，使用inputStream流式数据。
		parser.setInput(inputStream, encode);
		//判断当前的事件类型
		int eventType = parser.getEventType();
		//循环读取，知道事件类型为文档结束
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			// 通过判断事件类型来选择执行不同的代码
			case XmlPullParser.START_DOCUMENT:
				//文档开始的时候，实例化list对象，用于存放XML解析后的数据
				list=new ArrayList<Person>();				
				break;
			case XmlPullParser.START_TAG:
				//读取标签的时候触发这个事件
				if(parser.getName().equals("person"))
				{
					//如果当前读取到的节点是person节点，那么实例化一个person对象。
					person=new Person();
					//获得person节点中的属性ID
					int id=Integer.parseInt(parser.getAttributeValue(0));
					person.setId(id);
				}
				else if(parser.getName().equals("name"))
				{
					if(person!=null)
					{
						//获得name节点的下一个element Text
						String name=parser.nextText();
						person.setName(name);
					}
				}
				else if(parser.getName().equals("age"))
				{
					if(person!=null)
					{
						//获得age节点的下一个element Text
						int age=Integer.parseInt(parser.nextText());
						person.setAge(age);
					}
				}
				break;
			case XmlPullParser.END_TAG:
				if(parser.getName().equals("person"))
				{
					//读到结束节点标签，如果为person，则把之前读取到的person对象加入list中，
					//并且制空person对象。
					list.add(person);
					person=null;
				}
				break;
			}
			//读取
			eventType=parser.next();
		}
		Log.i(TAG, "成功解析网络XML数据流");
		return list;
	}
}
