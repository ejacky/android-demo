package com.bookdemo.aidlservicecustdemo.domain;

import com.bookdemo.aidlservicecustdemo.domain.Message;
import com.bookdemo.aidlservicecustdemo.domain.User;

interface IGetMsg{
	List<Message> getMes(in User us);
}