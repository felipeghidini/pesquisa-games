package com.devsuperior.springpesquisagames.dto;

import java.io.Serializable;

import com.devsuperior.springpesquisagames.model.Game;
import com.devsuperior.springpesquisagames.model.enums.Platform;

public class GameDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private Platform platform;
	
	public GameDTO() {
		
	}
	
	public GameDTO(Game model) {
		id = model.getId();
		title = model.getTitle();
		platform = model.getPlatform();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	

}
