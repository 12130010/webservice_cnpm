package com.nhuocquy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "conversation")
public class Conversation {
	@Id
	@GeneratedValue
	private long idCon;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Friend> friends;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Message> listMes;

	public Conversation() {
		friends = new ArrayList<Friend>();
		listMes = new ArrayList<Message>();
	}

	public long getIdCon() {
		return idCon;
	}

	public void setIdCon(long idCon) {
		this.idCon = idCon;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	public List<Message> getListMes() {
		return listMes;
	}

	public void setListMes(List<Message> listMes) {
		this.listMes = listMes;
	}

}
