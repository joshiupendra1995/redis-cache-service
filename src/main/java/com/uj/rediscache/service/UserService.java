package com.uj.rediscache.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import com.uj.rediscache.dto.UserDto;
import com.uj.rediscache.entity.User;
import com.uj.rediscache.mapper.UserMapper;
import com.uj.rediscache.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserMapper mapper;

	@Caching(evict = { @CacheEvict(value = "usersList", allEntries = true), }, put = {
			@CachePut(value = "user", key = "#user.getUserId()") })
	public User saveUser(UserDto user) {
		return userRepo.save(mapper.getUser(user));
	}

	@Cacheable(value = "users")
	public List<UserDto> getUsersList() {
		log.info("User List Service called!!!");
		List<User> users = userRepo.findAll();
		return mapper.getUsers(users);
	}
}
