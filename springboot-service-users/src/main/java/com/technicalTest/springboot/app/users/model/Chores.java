package com.technicalTest.springboot.app.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chores {
	
	private String title;
	private String content;
	private Long userId;
}