package com.bookdemo.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.util.Log;

import com.bookdemo.domain.Person;



public class DomService {
	private static final String TAG="main";
	public DomService() {
		
	}

	public static List<Person> getPersons(InputStream inputStream) throws Exception
	{
		List<Person> list=new ArrayList<Person>();
		//获取工厂对象，以及通过DOM工厂对象获取DOMBuilder对象
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		//解析XML输入流，得到Document对象，表示一个XML文档
		Document document=builder.parse(inputStream);
		//获得文档中的次以及节点，persons
		Element element=document.getDocumentElement();
		// 获取Element下一级的person节点集合，以NodeList的形式存放。
		NodeList personNodes=element.getElementsByTagName("person");
		for(int i=0;i<personNodes.getLength();i++)
		{
			//循环获取索引为i的person节点
			Element personElement=(Element) personNodes.item(i);
			Person person=new Person();
			//通过属性名，获取节点的属性id
			person.setId(Integer.parseInt(personElement.getAttribute("id")));
			//获取索引i的person节点下的子节点集合
			NodeList childNodes=personElement.getChildNodes();
			for(int j=0;j<childNodes.getLength();j++)
			{
				//循环遍历每个person下的子节点，如果判断节点类型是ELEMENT_NODE，就可以依据节点名称给予解析
				if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE)
				{
					if("name".equals(childNodes.item(j).getNodeName()))
					{
						//因为文本也是一个文本节点，
						//所以这里读取到name节点的时候，
						//通过getFirstChild()可以直接获得name节点的下的第一个节点，就是name节点后的文本节点
						//取其value值，就是文本的内容
						person.setName(childNodes.item(j).getFirstChild().getNodeValue());
					}
					else if("age".equals(childNodes.item(j).getNodeName()))
					{
						person.setAge(Integer.parseInt(childNodes.item(j).getFirstChild().getNodeValue()));
					}
				}
			}
			//把解析的person对象加入的list集合中
			list.add(person);
		}
		Log.i(TAG, "成功解析XML数据流");
		return list;
	}
}
