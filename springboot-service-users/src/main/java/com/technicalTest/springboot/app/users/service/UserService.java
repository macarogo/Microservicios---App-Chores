package com.technicalTest.springboot.app.users.service;

//import java.util.Date;
import java.util.List;

import com.technicalTest.springboot.app.users.dto.UserDto;
import com.technicalTest.springboot.app.users.model.Chores;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);
	public List<UserDto> getAllUser();
	public UserDto getUserById(Long id);
	public UserDto updateUser(UserDto userDto, Long id);
	public void deleteUser(Long id);
	
	//Por búsqueda
	public UserDto findByFirstName(String firstName);
	public UserDto findByEmail(String email);
	//public UserDto findByCreateAt(Date createAt);
	
	//RestTemplate
	List<Chores> getChores(Long userId);
	Chores saveChores(Long userId, Chores chores);
}
