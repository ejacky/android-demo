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
	 * 解析Json数据成一个Person对象
	 * @param jsonString Json数据
	 * @return Person对象
	 */
	public static Person getPerson(String jsonString)
	{
		Person person=new Person();
		try {			
			//一个Json对象，使用JSONObject
			JSONObject jsonObject=new JSONObject(jsonString);
			//对JSONObject对象中直接以key的形式取其Value
			person.setId(jsonObject.getInt("id"));
			person.setName(jsonObject.getString("name"));
			person.setAge(jsonObject.getInt("age"));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return person;
	}
	
	/**
	 * 解析Json数据成一个Person的List泛型集合
	 * @param jsonString Json数据
	 * @return Person的List泛型集合
	 */
	public static List<Person> getPersonList(String jsonString)
	{
		List<Person> list=new ArrayList<Person>();
		try {
			//最外层是一个数组[]，所以使用JSONArray
			JSONArray jsonarr=new JSONArray(jsonString);
			Person person=null;			
			for(int i=0;i<jsonarr.length();i++)
			{
				//遍历数组获得数组中Json对象。
				person=new Person();
				JSONObject jsonObject= jsonarr.getJSONObject(i);
				//获取到Json对象，就可以直接通过Key获取Value
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
	 * 解析Json数据成一个Sting类型的List泛型集合
	 * @param jsonString Json数据
	 * @return Sting类型的List泛型集合
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
	 * 解析Json数据成一个List<Map<String, Object>>类型的数据
	 * @param jsonString Json数据
	 * @return List<Map<String, Object>>类型的数据
	 */
	public static List<Map<String, Object>> getMapList(String jsonString)
	{
		List<Map<String, Object>> maps=new ArrayList<Map<String,Object>>();
		try {
			//最外层是一个Json数组
			JSONArray jsonArray=new JSONArray(jsonString);
			for(int i =0;i<jsonArray.length();i++)
			{
				//Json数组中又包含了一个Json数组
				Map<String,Object> map=new HashMap<String, Object>();
				JSONArray mapArray=jsonArray.getJSONArray(i);
				for(int j=0;j<mapArray.length();j++)
				{
					//第二层Json数组中才能取到Json对象，有对象就可以取值。
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
