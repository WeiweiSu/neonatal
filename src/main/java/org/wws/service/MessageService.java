package org.wws.service;

import java.util.List;

import org.wws.pojo.Message;

public interface MessageService {
	public void addMessage(Message message);
	public List<Message> listMessages();
	public Message getMessage(Integer id);
	public void removeMessage(Integer id);

	public List<Message> listMessagesByUserName(String username);
}
