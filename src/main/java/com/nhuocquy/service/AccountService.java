package com.nhuocquy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhuocquy.dao.DAOAccount;
import com.nhuocquy.dao.DAOConversation;
import com.nhuocquy.dao.DAOFriend;
import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Account;
import com.nhuocquy.model.Friend;

@Service
public class AccountService {
	private DAOAccount daoAccount = new DAOAccount(Account.class);
	private DAOFriend daoFriend = new DAOFriend(Friend.class);
	private Account account;
	public Account login(String username, String password) throws DAOException {
		account =  daoAccount.login(username, password);
		account.setPassword(null);
		return account;
	}
	public long signUp(Account acc) throws DAOException{
		return daoAccount.save(acc);
	}
	public Account findById(long id) throws DAOException{
		account =  daoAccount.findById(id);
		account.setPassword(null);
		return account;
	}
	public Friend findByIdFriend(long id) throws DAOException{
		return daoFriend.findById(id);
	}
	public boolean makeFriend(long idacc, long idfri) throws DAOException{
		return daoAccount.makeFriend(idacc, idfri);
	}
	public boolean unMakeFriend(long idacc, long idfri) throws DAOException{
		return daoAccount.unMakeFriend(idacc, idfri);
	}
	public boolean commitMakeFriend(long idacc, long idfri) throws DAOException{
		return daoAccount.commitMakeFriend(idacc, idfri);
	}
	public List<Friend>  getListAddFriend(long idacc) throws DAOException{
		return daoAccount.getListFriend(idacc);
	}
}
