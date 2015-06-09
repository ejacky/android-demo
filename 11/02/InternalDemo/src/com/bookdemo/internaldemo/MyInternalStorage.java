package com.bookdemo.internaldemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;

public class MyInternalStorage {
	//��Ҫ���浱ǰ���ö����Context
    private Context context;

    public MyInternalStorage(Context context) {
        this.context = context;
    }
    /**
     * �������ݵ��ڲ��洢����
     * @param filename �ļ���
     * @param content ����
     */
    public void save(String filename, String content) throws IOException {
        // FileOutputStream fos=context.openFileOutput(filename,
        // Context.MODE_PRIVATE);
        File file = new File(context.getFilesDir(), filename);
        FileOutputStream fos = new FileOutputStream(file);

        fos.write(content.getBytes());
        fos.close();
    }
    /**
     *  ͨ���ļ�����ȡ����
     * @param filename �ļ���
     * @return �ļ�����
     */
    public String get(String filename) throws IOException {
        FileInputStream fis = context.openFileInput(filename);
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
     * @param filename �ļ���
     * @param content ׷�ӵ�����
     */
    public void append(String filename, String content) throws IOException {
        FileOutputStream fos = context.openFileOutput(filename,
                Context.MODE_APPEND);
        fos.write(content.getBytes());
        fos.close();
    }
    /**
     * ɾ���ļ�
     * @param filename �ļ���
     * @return �Ƿ�ɹ�
     */
    public boolean delete(String filename) {
        return context.deleteFile(filename);
    }
    /**
     * ��ȡ�ڲ��洢·���µ������ļ���
     * @return �ļ�������
     */
    public String[] queryAllFile() {
        return context.fileList();
    }
}
