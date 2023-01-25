package com.technicalTest.springboot.app.users.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.technicalTest.springboot.app.users.model.Chores;


@FeignClient(name= "service-chores", url= "localhost:8002/chores")
//@RequestMapping("/chores")
public interface ChoresFeignClient {
	
	@PostMapping()
	Chores save(@RequestBody Chores chores);
}
