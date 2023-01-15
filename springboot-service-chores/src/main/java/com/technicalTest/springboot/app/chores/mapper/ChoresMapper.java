package com.technicalTest.springboot.app.chores.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.technicalTest.springboot.app.chores.dto.ChoresDto;
import com.technicalTest.springboot.app.chores.entity.Chores;

@Component
public class ChoresMapper {
	
	public ChoresDto choreEntity2DTO(Chores chores) {
		
		ChoresDto choresDto= new ChoresDto();
		choresDto.setTitle(chores.getTitle());
		choresDto.setContent(chores.getContent());
		choresDto.setUserId(chores.getUserId());
		return choresDto;
	}
	
	public List<ChoresDto> choresEntityList2DTO(List<Chores> choresList){
		List<ChoresDto> choresDtoList= new ArrayList<>();
		for(Chores chores : choresList) {
			choresDtoList.add(this.choreEntity2DTO(chores));
		}
		return choresDtoList;
	}
	
	public Chores choresDTO2Entity(ChoresDto choresDto) {
		
		Chores chores= new Chores();
		chores.setTitle(choresDto.getTitle());
		chores.setContent(choresDto.getContent());
		chores.setUserId(choresDto.getUserId());
		return chores;
	}
}
