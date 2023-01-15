package com.technicalTest.springboot.app.chores.service;

import java.util.List;

import com.technicalTest.springboot.app.chores.dto.ChoresDto;

public interface ChoresService {
	
	public ChoresDto saveChores(ChoresDto choresDto);
	public List<ChoresDto> getAllChores();
	public ChoresDto getById(Long id);
	public ChoresDto updateChores(ChoresDto choresDto, Long id);
	public void deleteChores(Long id);
	public List<ChoresDto> getByUserId(Long userId);
}
