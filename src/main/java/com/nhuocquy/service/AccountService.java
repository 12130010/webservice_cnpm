package com.nhuocquy.service;

import org.springframework.stereotype.Service;

import com.nhuocquy.dao.AccountDAO;
import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Account;

@Service
public class AccountService {
	private AccountDAO dao = new AccountDAO(Account.class);
	public Account login(String username, String password) throws DAOException {
		return dao.login(username, password);
	}
}
