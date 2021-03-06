package com.bookdemo.cachedemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;

public class MyCacheStorage {
	// 需要保存当前调用对象的Context
	private Context context;

	public MyCacheStorage(Context context) {
		this.context = context;
	}

	/**
	 * 保存内容到缓存中
	 * 
	 * @param filename
	 *            文件名
	 * @param content
	 *            内容
	 */
	public void save(String filename, String content) throws IOException {

		File file = new File(context.getCacheDir(), filename);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(content.getBytes());
		fos.close();
	}

	/**
	 * 通过文件名获取内容
	 * 
	 * @param filename
	 *            文件名
	 * @return 文件内容
	 */
	public String get(String filename) throws IOException {

		File file = new File(context.getCacheDir(), filename);
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = -1;
		while ((len = fis.read(data)) != -1) {
			baos.write(data, 0, len);
		}
		return new String(baos.toByteArray());
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
		File file = new File(context.getCacheDir(), filename);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(content.getBytes());
		fos.close();
	}

	/**
	 * 删除缓存中对应的文件
	 * 
	 * @param filename
	 *            文件名
	 * @return 是否成功
	 */
	public boolean delete(String filename) {
		File file = new File(context.getCacheDir(), filename);		
		return file.delete();
	}

	/**
	 * 获取应用缓存中的所有文件名
	 * 
	 * @return 文件名数组
	 */
	public String[] queryAllFile() {		
		return context.getCacheDir().list();
	}
}
