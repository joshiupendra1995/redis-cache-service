package com.uj.rediscache.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.uj.rediscache.dto.UserDto;
import com.uj.rediscache.entity.User;

@Component
public class UserMapper {

	public UserDto getUserDto(User user) {
		return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getMobile());
	}

	public User getUser(UserDto userDto) {
		return new User(null, userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getMobile());
	}

	public List<UserDto> getUsers(List<User> users) {
		List<UserDto> usersList = new ArrayList<>();
		users.forEach(user -> usersList.add(getUserDto(user)));
		return usersList;
	}
}
