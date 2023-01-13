package com.technicalTest.springboot.app.users.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.technicalTest.springboot.app.users.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	//Búsquedas
	@Transactional(readOnly= true)
	Users findByFirstName(String firstName);
	
	@Transactional(readOnly= true)
	Users findByCreateAt(Date createAt);
	
	@Transactional(readOnly= true)
	Users findByEmail(String email);
}
