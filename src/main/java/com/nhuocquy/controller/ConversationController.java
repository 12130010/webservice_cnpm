package com.nhuocquy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhuocquy.model.Conversation;
import com.nhuocquy.service.ConversationService;

@Controller
public class ConversationController {
	@Autowired
	ConversationService conversationService;
	
	@RequestMapping(value = "/getconversation",method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Conversation getConversation (@RequestBody long... ids){
		if(ids.length ==1)
			return conversationService.getConversation(ids[0]);
		else
			return conversationService.getConversation(ids);
	}
}
