package com.nhuocquy.service;

import org.springframework.stereotype.Service;

import com.nhuocquy.dao.DAOAccount;
import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Account;

@Service
public class AccountService {
	private DAOAccount dao = new DAOAccount(Account.class);
	public Account login(String username, String password) throws DAOException {
		return dao.login(username, password);
	}
}
