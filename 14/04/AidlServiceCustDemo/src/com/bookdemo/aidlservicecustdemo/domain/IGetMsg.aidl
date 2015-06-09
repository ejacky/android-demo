package com.bookdemo.aidlservicecustdemo.domain;

// 这是两个自定义类
import com.bookdemo.aidlservicecustdemo.domain.Message;
import com.bookdemo.aidlservicecustdemo.domain.User;

interface IGetMsg{
	// 在AIDL接口中定义一个getMes方法
	List<Message> getMes(in User us);
}