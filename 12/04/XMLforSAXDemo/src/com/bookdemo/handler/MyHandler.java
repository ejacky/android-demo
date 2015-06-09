package com.bookdemo.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	//�������XML����
	private List<HashMap<String, String>> list = null; 
	//��ŵ�ǰ��Ҫ��¼�Ľڵ��XML����
	private HashMap<String, String> map = null;  
	//��ǰ��ȡ��XML�ڵ�
	private String currentTag = null;
	//��ǰ�ڵ��XML�ı�ֵ
	private String currentValue = null;
	//��Ҫ�����Ľڵ�����
	private String nodeName = null;

	public MyHandler(String nodeName) {
		// ������Ҫ�����Ľڵ�����
		this.nodeName = nodeName;
	}

	@Override
	public void startDocument() throws SAXException {
		// �����ĵ���ʼ��֪ͨ��
		// ʵ����ArrayList���ڴ�Ž���XML�������
		list = new ArrayList<HashMap<String, String>>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// ����Ԫ�ؿ�ʼ��֪ͨ��		
		if (qName.equals(nodeName)) {
			//�����ǰ���еĽڵ��������趨��Ҫ��ȡ�Ľڵ�������ͬ����ʵ����HashMap
			map = new HashMap<String, String>();
		}
		//AttributesΪ��ǰ�ڵ������ֵ�������������ֵ��������ֵҲ��ȡ��
		if (attributes != null && map != null) {
			for (int i = 0; i < attributes.getLength(); i++) {
				//��ȡ��������ֵ�����뵽Map�С�
				map.put(attributes.getQName(i), attributes.getValue(i));
			}
		}
		//��¼��ǰ�ڵ�����ơ�
		currentTag = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// ����Ԫ�����ַ����ݵ�֪ͨ��
		//��ǰ�ڵ���ֵ������²ż���ִ��
		if (currentTag != null && map != null) {
			//��ȡ��ǰ�ڵ���ı�ֵ��ch���ֱ��������Ǵ�ŵ��ı�ֵ��
			currentValue = new String(ch, start, length);
			if (currentValue != null && !currentValue.equals("")
					&& !currentValue.equals("\n")) {
				//��ȡ���ı���Ҫ�жϲ���Ϊnull�����ܵ��ڡ��������ܵ��ڡ�\n��
				map.put(currentTag, currentValue);
			}
		}
		//��ȡ��ɺ���Ҫ��յ�ǰ�ڵ�ı�ǩֵ�����������ı�ֵ��
		currentTag = null;
		currentValue = null;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// ����Ԫ�ؽ�����֪ͨ��
		if (qName.equals(nodeName)) {
			//�����ȡ�Ľ�Ͻڵ���������Ҫ��ע�Ľڵ㣬���map���뵽list�б���
			list.add(map);
			//ʹ��֮�����map����ʼ��һ�ֵĶ�ȡperson��
			map = null;
		}
	}

	public List<HashMap<String, String>> getList() {
		return list;
	}
}
