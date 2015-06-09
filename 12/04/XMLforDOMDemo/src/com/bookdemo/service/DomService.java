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
		//��ȡ���������Լ�ͨ��DOM���������ȡDOMBuilder����
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		//����XML���������õ�Document���󣬱�ʾһ��XML�ĵ�
		Document document=builder.parse(inputStream);
		//����ĵ��еĴ��Լ��ڵ㣬persons
		Element element=document.getDocumentElement();
		// ��ȡElement��һ����person�ڵ㼯�ϣ���NodeList����ʽ��š�
		NodeList personNodes=element.getElementsByTagName("person");
		for(int i=0;i<personNodes.getLength();i++)
		{
			//ѭ����ȡ����Ϊi��person�ڵ�
			Element personElement=(Element) personNodes.item(i);
			Person person=new Person();
			//ͨ������������ȡ�ڵ������id
			person.setId(Integer.parseInt(personElement.getAttribute("id")));
			//��ȡ����i��person�ڵ��µ��ӽڵ㼯��
			NodeList childNodes=personElement.getChildNodes();
			for(int j=0;j<childNodes.getLength();j++)
			{
				//ѭ������ÿ��person�µ��ӽڵ㣬����жϽڵ�������ELEMENT_NODE���Ϳ������ݽڵ����Ƹ������
				if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE)
				{
					if("name".equals(childNodes.item(j).getNodeName()))
					{
						//��Ϊ�ı�Ҳ��һ���ı��ڵ㣬
						//���������ȡ��name�ڵ��ʱ��
						//ͨ��getFirstChild()����ֱ�ӻ��name�ڵ���µĵ�һ���ڵ㣬����name�ڵ����ı��ڵ�
						//ȡ��valueֵ�������ı�������
						person.setName(childNodes.item(j).getFirstChild().getNodeValue());
					}
					else if("age".equals(childNodes.item(j).getNodeName()))
					{
						person.setAge(Integer.parseInt(childNodes.item(j).getFirstChild().getNodeValue()));
					}
				}
			}
			//�ѽ�����person��������list������
			list.add(person);
		}
		Log.i(TAG, "�ɹ�����XML������");
		return list;
	}
}
