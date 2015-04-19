package com.nhuocquy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Account;
import com.nhuocquy.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Account login(@RequestParam(defaultValue = "") String username ,@RequestParam(defaultValue = "") String password){
		try {
			return accountService.login(username, password);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
