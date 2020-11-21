package com.devsuperior.springpesquisagames.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.springpesquisagames.dto.GameDTO;
import com.devsuperior.springpesquisagames.model.Game;
import com.devsuperior.springpesquisagames.repository.GameRepository;


@Service
public class GameService {
	
	@Autowired
	public GameRepository gameRepository;
	
	@Transactional(readOnly = true) // isso indica que é apenas para leitura
	public List<GameDTO> findAll(){
		List <Game> list = gameRepository.findAll();
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}
}
