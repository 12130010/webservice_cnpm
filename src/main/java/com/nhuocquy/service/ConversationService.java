package com.nhuocquy.service;

import org.springframework.stereotype.Service;

import com.nhuocquy.dao.DAOConversation;
import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Conversation;

@Service
public class ConversationService {
	private DAOConversation conversationDAO = new DAOConversation(Conversation.class);
	public Conversation getConversation(long... ids){
		try {
			return conversationDAO.getConversation(ids);
		} catch (DAOException e) {
//			e.printStackTrace();
			return null;
		}
	}
	public Conversation getConversation(long id){
		try {
			return conversationDAO.findById(id);
		} catch (DAOException e) {
//			e.printStackTrace();
			return null;
		}
	}
}
