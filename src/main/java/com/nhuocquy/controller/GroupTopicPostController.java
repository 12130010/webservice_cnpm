package com.nhuocquy.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhuocquy.model.GroupTopic;
import com.nhuocquy.model.Post;
import com.nhuocquy.model.Topic;
import com.nhuocquy.myfile.MyStatus;
import com.nhuocquy.service.GroupTopicService;
import com.nhuocquy.service.TopicAndPostService;

@Controller
public class GroupTopicPostController {
	@Autowired
	GroupTopicService groupTopicService = new GroupTopicService();;
	@Autowired
	TopicAndPostService topicAndPostService ;
	
	@RequestMapping(value = "/getallgrouptopic", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<GroupTopic> getAllGroup(){
		return groupTopicService.getAllGroupTopic();
	}
	@RequestMapping(value = "/getgrouptopic/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody GroupTopic getGroupTopic(@PathVariable long id){
		return groupTopicService.findById(id);
	}
	@RequestMapping(value = "/gettopic/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Topic getTopic(@PathVariable long id){
		return topicAndPostService.findById(id);
	}
	@RequestMapping(value = "/createtopic" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MyStatus createNewTopic(@RequestBody Topic topic){
		MyStatus myStatus = new MyStatus();
		if(topicAndPostService.createNewTopic(topic)){
			myStatus.setCode(MyStatus.CODE_SUCCESS);
			myStatus.setMessage(MyStatus.MESSAGE_SUCCESS);
			myStatus.setObj(topic.getIdTopic());
		}else{
			myStatus.setCode(MyStatus.CODE_FAIL);
			myStatus.setMessage(MyStatus.MESSAGE_FAIL);
		}
		return myStatus;
	}
	@RequestMapping(value = "/getpost/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Post getPost(@PathVariable long id){
		return topicAndPostService.findByIdPost(id);
	}
	@RequestMapping(value = "/createpost" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MyStatus createNewPost(@RequestBody Post post){
		MyStatus myStatus = new MyStatus();
		if(topicAndPostService.createNewPost(post)){
			myStatus.setCode(MyStatus.CODE_SUCCESS);
			myStatus.setMessage(MyStatus.MESSAGE_SUCCESS);
		}else{
			myStatus.setCode(MyStatus.CODE_FAIL);
			myStatus.setMessage(MyStatus.MESSAGE_FAIL);
		}
		return myStatus;
		
	}
	@RequestMapping(value = "/updatelike" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MyStatus updateLike(@RequestBody Post post){
		MyStatus myStatus = new MyStatus();
		if(topicAndPostService.updateLike(post)){
			myStatus.setCode(MyStatus.CODE_SUCCESS);
			myStatus.setMessage(MyStatus.MESSAGE_SUCCESS);
		}else{
			myStatus.setCode(MyStatus.CODE_FAIL);
			myStatus.setMessage(MyStatus.MESSAGE_FAIL);
		}
		return myStatus;
		
	}
	public static void main(String[] args) {
		System.out.println(new GroupTopicPostController().getAllGroup());
	}
}
