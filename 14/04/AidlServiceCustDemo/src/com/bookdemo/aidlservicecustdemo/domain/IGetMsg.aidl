package com.bookdemo.aidlservicecustdemo.domain;

// ���������Զ�����
import com.bookdemo.aidlservicecustdemo.domain.Message;
import com.bookdemo.aidlservicecustdemo.domain.User;

interface IGetMsg{
	// ��AIDL�ӿ��ж���һ��getMes����
	List<Message> getMes(in User us);
}