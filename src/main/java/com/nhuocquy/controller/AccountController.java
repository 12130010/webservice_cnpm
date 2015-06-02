package com.nhuocquy.controller;

import java.io.IOException;
import java.net.URI;
import java.nio.channels.NotYetConnectedException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Account;
import com.nhuocquy.model.Friend;
import com.nhuocquy.myfile.MyStatus;
import com.nhuocquy.service.AccountService;
import com.nhuocquy.service.MyWebsocket;

@Controller
public class AccountController {
	public static final String MESSAGE_ADD_FRIEND = (char) 0 + "addfriend+%s:%s";
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private AccountService accountService;
//	@Autowired
	private MyWebsocket websocket;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE , headers = {})
	public @ResponseBody Account login(@RequestParam(defaultValue = "") String username ,@RequestParam(defaultValue = "") String password){
		try {
			return accountService.login(username, password);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , headers = {})
	public @ResponseBody Account login2(@RequestParam(defaultValue = "") String username ,@RequestParam(defaultValue = "") String password){
		try {
			return accountService.login(username, password);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MyStatus signUp(@RequestBody Account acc){
		MyStatus myStatus = new MyStatus();
		try {
			myStatus.setObj(accountService.signUp(acc));
			myStatus.setCode(MyStatus.CODE_SUCCESS);
			myStatus.setMessage(MyStatus.MESSAGE_SUCCESS);
		} catch (DAOException e) {
			e.printStackTrace();
			myStatus.setCode(MyStatus.CODE_FAIL);
			myStatus.setMessage(MyStatus.MESSAGE_FAIL);
		}
		return myStatus;
	}
	@RequestMapping(value = "/getacc/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE , headers = {})
	public @ResponseBody Account findById(@PathVariable(value = "id") long id){
		try {
			return accountService.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/makefriend", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE , headers = {})
	public @ResponseBody MyStatus makeFriend(@RequestParam(value = "idacc") long idacc,@RequestParam(value = "idfri") long idfri){
		MyStatus myStatus = new MyStatus();
		try {
			if(accountService.makeFriend(idacc, idfri)){
				myStatus.setCode(MyStatus.CODE_SUCCESS);
				myStatus.setMessage(MyStatus.MESSAGE_SUCCESS);
					String message  = objectMapper.writeValueAsString(accountService.findByIdFriend(idfri));
						while(websocket == null || !websocket.isOpen())
							try {
								System.out.println("init");
								init();
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
//				}
					websocket.send(String.format(MESSAGE_ADD_FRIEND,idfri,message));
			}else{
				myStatus.setCode(MyStatus.CODE_FAIL);
				myStatus.setMessage(MyStatus.MESSAGE_FAIL);
			}
		} catch (NotYetConnectedException | DAOException | IOException e) {
			e.printStackTrace();
			myStatus.setCode(MyStatus.CODE_FAIL);
			myStatus.setMessage(MyStatus.MESSAGE_FAIL);
		}
		return myStatus;
	}
	
	@RequestMapping(value = "/unmakefriend", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE , headers = {})
	public @ResponseBody MyStatus unMakeFriend(@RequestParam(value = "idacc") long idacc,@RequestParam(value = "idfri") long idfri) throws DAOException{
		MyStatus myStatus = new MyStatus();
		if(accountService.unMakeFriend(idacc, idfri)){
			myStatus.setCode(MyStatus.CODE_SUCCESS);
			myStatus.setMessage(MyStatus.MESSAGE_SUCCESS);
		}else{
			myStatus.setCode(MyStatus.CODE_FAIL);
			myStatus.setMessage(MyStatus.MESSAGE_FAIL);
		}
		return myStatus;
	}
	@RequestMapping(value = "/commitmakefriend", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE , headers = {})
	public @ResponseBody MyStatus commitMakeFriend(@RequestParam(value = "idacc") long idacc,@RequestParam(value = "idfri") long idfri) throws DAOException{
		MyStatus myStatus = new MyStatus();
		if(accountService.commitMakeFriend(idacc, idfri)){
			myStatus.setCode(MyStatus.CODE_SUCCESS);
			myStatus.setMessage(MyStatus.MESSAGE_SUCCESS);
		}else{
			myStatus.setCode(MyStatus.CODE_FAIL);
			myStatus.setMessage(MyStatus.MESSAGE_FAIL);
		}
		return myStatus;
	}
	@RequestMapping(value = "/getlistaddfriend", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE , headers = {})
	public @ResponseBody List<Friend> getListAddFriend(@RequestParam(value="idacc") long idacc){
		try {
			return accountService.getListAddFriend(idacc);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public @ResponseBody MyStatus init(){
		new Thread(){
			public void run() {
				websocket = new MyWebsocket("ws://192.168.117.191:8080/tuyensinhchat/chat?id=0");
				while(websocket.isConnecting()){
					System.out.println("wait");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();;
		return new MyStatus();
	}
	
	
}
