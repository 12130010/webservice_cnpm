package test;

import util.HibernateUtil;

import com.nhuocquy.dao.DAOAccount;
import com.nhuocquy.dao.DAOConversation;
import com.nhuocquy.dao.DAOMessageChat;
import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Account;
import com.nhuocquy.model.Conversation;
import com.nhuocquy.model.MessageChat;

public class TestDao {
	public static void main(String[] args) throws DAOException {
//		DAOConversation daoConversation = new DAOConversation(Conversation.class);
//		Conversation conversation = daoConversation.findById(1l);
//		System.out.println("========");
//		System.out.println(conversation);
//		conversation.getListMes().clear();
//		conversation.getListMes().add(new MessageChat());
//		System.out.println("========");
//		System.out.println(conversation);
//		daoConversation.saveMessageChatInConversation(conversation);
//		System.out.println("========");
//		conversation = daoConversation.findById(conversation.getIdCon());
//		System.out.println(conversation);
//		
//		DAOMessageChat chat = new DAOMessageChat(MessageChat.class);
//		chat.testBit(1,6);
//		HibernateUtil.shutdown();
		
		DAOAccount accountDAO = new DAOAccount(Account.class);
		try {
			System.out.println(accountDAO.login("nhuocquy", "nhuocquy"));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		HibernateUtil.shutdown();
	}
}
