package com.technicalTest.springboot.app.chores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technicalTest.springboot.app.chores.entity.Chores;

@Repository
public interface ChoresRepository extends JpaRepository<Chores, Long>{
	
	List<Chores> findByUserId(Long userId);
}
