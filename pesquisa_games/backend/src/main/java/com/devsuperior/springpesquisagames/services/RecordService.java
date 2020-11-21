package com.devsuperior.springpesquisagames.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.springpesquisagames.dto.RecordDTO;
import com.devsuperior.springpesquisagames.dto.RecordInsertDTO;
import com.devsuperior.springpesquisagames.model.Game;
import com.devsuperior.springpesquisagames.model.Record;
import com.devsuperior.springpesquisagames.repository.GameRepository;
import com.devsuperior.springpesquisagames.repository.RecordRepository;


@Service
public class RecordService {
	
	@Autowired
	public RecordRepository recordRepository;
	
	@Autowired
	public GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		
		Record entity = new Record();
		
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);
		
		entity = recordRepository.save(entity);
		return new RecordDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return recordRepository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
	}
}
