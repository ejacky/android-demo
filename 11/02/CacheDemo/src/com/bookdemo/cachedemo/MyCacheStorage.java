package com.bookdemo.cachedemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;

public class MyCacheStorage {
	// ��Ҫ���浱ǰ���ö����Context
	private Context context;

	public MyCacheStorage(Context context) {
		this.context = context;
	}

	/**
	 * �������ݵ�������
	 * 
	 * @param filename
	 *            �ļ���
	 * @param content
	 *            ����
	 */
	public void save(String filename, String content) throws IOException {

		File file = new File(context.getCacheDir(), filename);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(content.getBytes());
		fos.close();
	}

	/**
	 * ͨ���ļ�����ȡ����
	 * 
	 * @param filename
	 *            �ļ���
	 * @return �ļ�����
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
	 * ��׷�ӵķ�ʽ���ļ���ĩβ�������
	 * 
	 * @param filename
	 *            �ļ���
	 * @param content
	 *            ׷�ӵ�����
	 */
	public void append(String filename, String content) throws IOException {
		File file = new File(context.getCacheDir(), filename);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(content.getBytes());
		fos.close();
	}

	/**
	 * ɾ�������ж�Ӧ���ļ�
	 * 
	 * @param filename
	 *            �ļ���
	 * @return �Ƿ�ɹ�
	 */
	public boolean delete(String filename) {
		File file = new File(context.getCacheDir(), filename);		
		return file.delete();
	}

	/**
	 * ��ȡӦ�û����е������ļ���
	 * 
	 * @return �ļ�������
	 */
	public String[] queryAllFile() {		
		return context.getCacheDir().list();
	}
}
