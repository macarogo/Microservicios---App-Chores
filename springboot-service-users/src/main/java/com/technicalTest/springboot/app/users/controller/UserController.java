package com.technicalTest.springboot.app.users.controller;

//import java.util.Date;
import java.util.List;

import javax.validation.Valid;

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

import com.technicalTest.springboot.app.users.dto.UserDto;
import com.technicalTest.springboot.app.users.entity.Users;
import com.technicalTest.springboot.app.users.model.Chores;
import com.technicalTest.springboot.app.users.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
	}
	
	@GetMapping("/listUsers")
	public ResponseEntity<List<UserDto>> listUsers(){
		List<UserDto> users= userService.getAllUser();
		if(users.isEmpty()) {
			throw new RuntimeException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/findUser/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable Long id){
		UserDto user= userService.getUserById(id);
		if( user == null) {
			throw new RuntimeException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserDto> userUpdate(@PathVariable Long id, @RequestBody UserDto userDto){
		if(userDto == null) {
			throw new RuntimeException();
			}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(userDto, id));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Users> userDelete(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<Users>(HttpStatus.ACCEPTED);
	}
	
	//Por búsqueda
	@GetMapping("/byFirstName/{firstName}")
	public ResponseEntity<UserDto> findByFirstName(@PathVariable String firstName){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByFirstName(firstName));
	}
	
	@GetMapping("/byEmail/{email}")
	public ResponseEntity<UserDto> findByEmail(@PathVariable String email){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByEmail(email));
	}
	
	/*@GetMapping("/byDate/{createAt}")
	public ResponseEntity<UserDto> findByDate(@PathVariable("createAt") Date createAt){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findByCreateAt(createAt));
	}*/
	
    //RestTemplate
	@GetMapping("/chores/{userId}")
	public ResponseEntity<List<Chores>> getChores(@PathVariable("userId") Long userId){
		UserDto user= userService.getUserById(userId);
		if(user== null) {
			throw new RuntimeException();
		}
		List<Chores> chores= userService.getChores(userId);
		return ResponseEntity.status(HttpStatus.OK).body(chores);
	}
	
	//FeignClient
	@PostMapping("/saveChores/{userId}")
	public ResponseEntity<Chores> chores(@PathVariable("userId") Long userId, @RequestBody Chores chores){
		if(userService.getUserById(userId) == null) {
			throw new RuntimeException();
		}
		Chores newChores= userService.saveChores(userId, chores);
		return ResponseEntity.status(HttpStatus.OK).body(newChores);
	}

}
