package com.nhuocquy.service;

import org.springframework.stereotype.Service;

import com.nhuocquy.dao.DAOPost;
import com.nhuocquy.dao.DAOTopic;
import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.Post;
import com.nhuocquy.model.Topic;

@Service
public class TopicAndPostService {
	DAOTopic daoTopic = new DAOTopic();
	DAOPost daoPost = new DAOPost();
	public Topic findById(long id){
		try {
			return daoTopic.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean createNewTopic(Topic topic){
		try {
			long id = daoTopic.save(topic);
			topic.setIdTopic(id);
			return true;
		} catch (DAOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Post findByIdPost(long id){
		try {
			return daoPost.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean createNewPost(Post post){
		try {
			daoPost.save(post);
			return true;
		} catch (DAOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateLike(Post post){
		try {
			daoPost.updateLike(post);
			return true;
		} catch (DAOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
