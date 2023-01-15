package com.technicalTest.springboot.app.chores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technicalTest.springboot.app.chores.dto.ChoresDto;
import com.technicalTest.springboot.app.chores.entity.Chores;
import com.technicalTest.springboot.app.chores.service.ChoresService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/chores")
public class ChoresController {
	
	@Autowired
	private ChoresService choresService;
	
	@PostMapping("/createChores")
	public ResponseEntity<ChoresDto> saveChores(@RequestBody @Valid ChoresDto choresDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(choresService.saveChores(choresDto));
	}
	
	@GetMapping("/listChores")
	public ResponseEntity<List<ChoresDto>> getListChores(){
		return ResponseEntity.status(HttpStatus.OK).body(choresService.getAllChores());
	}
	
	@GetMapping("/findChores/{id}")
	public ResponseEntity<ChoresDto> findById(@PathVariable Long id){
		ChoresDto choresDto= choresService.getById(id);
		if(choresDto == null) {
			throw new RuntimeException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(choresDto);
	}
	
	@PutMapping("/updateChores/{id}")
	public ResponseEntity<ChoresDto> choresUpadate(@RequestBody ChoresDto choresDto,@PathVariable Long id){
		if(choresDto == null ) {
			throw new RuntimeException();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(choresService.updateChores(choresDto, id));
	}
	
	@DeleteMapping("/deleteChores/{id}")
	public ResponseEntity<Chores> deleteChores(@PathVariable Long id){
		choresService.deleteChores(id);
		return new ResponseEntity<Chores>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/userId/{userId}")
	public ResponseEntity<List<ChoresDto>> getListByUserId(@PathVariable @Valid Long userId){
		return ResponseEntity.status(HttpStatus.OK).body(choresService.getByUserId(userId));
	}
}
