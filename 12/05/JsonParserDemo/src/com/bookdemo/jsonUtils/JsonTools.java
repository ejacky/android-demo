package com.bookdemo.jsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bookdemo.domain.Person;



public class JsonTools {

	public JsonTools() {
		
	}
	
	/**
	 * ����Json���ݳ�һ��Person����
	 * @param jsonString Json����
	 * @return Person����
	 */
	public static Person getPerson(String jsonString)
	{
		Person person=new Person();
		try {			
			//һ��Json����ʹ��JSONObject
			JSONObject jsonObject=new JSONObject(jsonString);
			//��JSONObject������ֱ����key����ʽȡ��Value
			person.setId(jsonObject.getInt("id"));
			person.setName(jsonObject.getString("name"));
			person.setAge(jsonObject.getInt("age"));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return person;
	}
	
	/**
	 * ����Json���ݳ�һ��Person��List���ͼ���
	 * @param jsonString Json����
	 * @return Person��List���ͼ���
	 */
	public static List<Person> getPersonList(String jsonString)
	{
		List<Person> list=new ArrayList<Person>();
		try {
			//�������һ������[]������ʹ��JSONArray
			JSONArray jsonarr=new JSONArray(jsonString);
			Person person=null;			
			for(int i=0;i<jsonarr.length();i++)
			{
				//����������������Json����
				person=new Person();
				JSONObject jsonObject= jsonarr.getJSONObject(i);
				//��ȡ��Json���󣬾Ϳ���ֱ��ͨ��Key��ȡValue
				person.setId(jsonObject.getInt("id"));
				person.setName(jsonObject.getString("name"));
				person.setAge(jsonObject.getInt("age"));
				list.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
	/**
	 * ����Json���ݳ�һ��Sting���͵�List���ͼ���
	 * @param jsonString Json����
	 * @return Sting���͵�List���ͼ���
	 */
	public static List<String> getStringList(String jsonString)
	{
		List<String> list=new ArrayList<String>();
		try {
			JSONArray jsonArray=new JSONArray(jsonString);
			for(int i =0;i<jsonArray.length();i++)
			{
				String str=jsonArray.getString(i);
				list.add(str); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	/**
	 * ����Json���ݳ�һ��List<Map<String, Object>>���͵�����
	 * @param jsonString Json����
	 * @return List<Map<String, Object>>���͵�����
	 */
	public static List<Map<String, Object>> getMapList(String jsonString)
	{
		List<Map<String, Object>> maps=new ArrayList<Map<String,Object>>();
		try {
			//�������һ��Json����
			JSONArray jsonArray=new JSONArray(jsonString);
			for(int i =0;i<jsonArray.length();i++)
			{
				//Json�������ְ�����һ��Json����
				Map<String,Object> map=new HashMap<String, Object>();
				JSONArray mapArray=jsonArray.getJSONArray(i);
				for(int j=0;j<mapArray.length();j++)
				{
					//�ڶ���Json�����в���ȡ��Json�����ж���Ϳ���ȡֵ��
					JSONObject jsonObject=mapArray.getJSONObject(j);
					String key=jsonObject.getString("Key");
					Object value=jsonObject.get("Value");
					map.put(key, value);					
				}
				maps.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;		
	}	
}
