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
	// ��Ҫ���浱ǰ���ö����Context
	private Context context;

	public MyExternalStorage(Context context) {
		this.context = context;
	}

	/**
	 * �������ݵ��ⲿ�洢����
	 * 
	 * @param filename
	 *            �ļ���
	 * @param content
	 *            ����
	 */
	public void save(String filename, String content) throws IOException {
		// �ж��Ƿ�����ⲿ�洢��
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			// �õ��ļ�Ŀ¼
			File files=new File(Environment.getExternalStorageDirectory().getPath()+"/External/");
			// �ж��Ƿ����ExternalĿ¼
			if(!files.exists()){
				// ��������ڴ���ExternalĿ¼
				files.mkdir();
			}			
			File file = new File(files, filename);
			
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		}
	}

	/**
	 * ͨ���ļ�����ȡ����
	 * 
	 * @param filename
	 *            �ļ���
	 * @return �ļ�����
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
	 * ��׷�ӵķ�ʽ���ļ���ĩβ�������
	 * 
	 * @param filename
	 *            �ļ���
	 * @param content
	 *            ׷�ӵ�����
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
	 * ɾ�������ж�Ӧ���ļ�
	 * 
	 * @param filename
	 *            �ļ���
	 * @return �Ƿ�ɹ�
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
	 * ��ȡSd����ExternalĿ¼�е������ļ���
	 * 
	 * @return �ļ�������
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
