package com.uj.rediscache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uj.rediscache.dto.UserDto;
import com.uj.rediscache.entity.User;
import com.uj.rediscache.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/save")
	public User saveUser(@RequestBody UserDto userDto) {
		return userService.saveUser(userDto);
	}

	@GetMapping("/user/all")
	public List<UserDto> getUsersList() {
		return userService.getUsersList();
	}

}
