package com.nhuocquy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhuocquy.dao.DAOGroupTopic;
import com.nhuocquy.dao.exception.DAOException;
import com.nhuocquy.model.GroupTopic;

@Service
public class GroupTopicService {
	DAOGroupTopic daoGroupTopic = new DAOGroupTopic();

	public List<GroupTopic> getAllGroupTopic() {
		try {
			return daoGroupTopic.selectAll();
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public GroupTopic findById(long id) {
		GroupTopic groupTopic = null;
		try {
			groupTopic = daoGroupTopic.findById(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return groupTopic;
	}
}
