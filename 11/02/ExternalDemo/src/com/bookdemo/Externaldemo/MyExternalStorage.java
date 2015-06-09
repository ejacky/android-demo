package com.bookdemo.Externaldemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;

public class MyExternalStorage {
	// 需要保存当前调用对象的Context
	private Context context;

	public MyExternalStorage(Context context) {
		this.context = context;
	}

	/**
	 * 保存内容到外部存储器中
	 * 
	 * @param filename
	 *            文件名
	 * @param content
	 *            内容
	 */
	public void save(String filename, String content) throws IOException {
		// 判断是否存在外部存储器
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			// 得到文件目录
			File files=new File(Environment.getExternalStorageDirectory().getPath()+"/External/");
			// 判断是否存在External目录
			if(!files.exists()){
				// 如果不存在创建External目录
				files.mkdir();
			}			
			File file = new File(files, filename);
			
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		}
	}

	/**
	 * 通过文件名获取内容
	 * 
	 * @param filename
	 *            文件名
	 * @return 文件内容
	 */
	public String get(String filename) throws IOException {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File files=new File(Environment.getExternalStorageDirectory().getPath()+"/External/");
			if(!files.exists()){
				files.mkdir();
			}			
			File file = new File(files, filename);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] data = new byte[1024];
			int len = -1;
			while ((len = fis.read(data)) != -1) {
				baos.write(data, 0, len);
			}
			return new String(baos.toByteArray());
		}
		return "";
	}

	/**
	 * 以追加的方式在文件的末尾添加内容
	 * 
	 * @param filename
	 *            文件名
	 * @param content
	 *            追加的内容
	 */
	public void append(String filename, String content) throws IOException {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File files=new File(Environment.getExternalStorageDirectory().getPath()+"/External/");
			if(!files.exists()){
				files.mkdir();
			}			
			File file = new File(files, filename);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		}
	}

	/**
	 * 删除缓存中对应的文件
	 * 
	 * @param filename
	 *            文件名
	 * @return 是否成功
	 */
	public boolean delete(String filename) {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File files=new File(Environment.getExternalStorageDirectory().getPath()+"/External/");
			if(!files.exists()){
				files.mkdir();
			}			
			File file = new File(files, filename);
			return file.delete();
		}
		return false;
	}

	/**
	 * 获取Sd卡中External目录中的所有文件名
	 * 
	 * @return 文件名数组
	 */
	public String[] queryAllFile() {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File files=new File(Environment.getExternalStorageDirectory().getPath()+"/External/");
			if(!files.exists()){
				files.mkdir();
			}			
			return files.list();
		}
		return null;
	}
}
