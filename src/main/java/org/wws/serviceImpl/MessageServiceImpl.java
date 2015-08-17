package org.wws.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wws.dao.MessageDAO;
import org.wws.pojo.Message;
import org.wws.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO messageDAO;
	
	@Transactional
	@Override
	public void addMessage(Message message) {
		messageDAO.addMessage(message);
	}

	@Transactional
	@Override
	public List<Message> listMessages() {
		return messageDAO.listMessages();
	}

	@Transactional
	@Override
	public Message getMessage(Integer id) {
		return messageDAO.getMessage(id);
	}

	@Transactional
	@Override
	public void removeMessage(Integer id) {
		messageDAO.removeMessage(id);
	}

	@Transactional
	@Override
	public List<Message> listMessagesByUserName(String username) {
		return messageDAO.listMessagesByUserName(username);
	}

}
