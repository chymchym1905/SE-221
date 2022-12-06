package com.uwc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.uwc.dto.UserDto;
import com.uwc.entity.User;
import com.uwc.repository.UserRepository;
import com.uwc.service.UserService;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void add(UserDto dto) {
		User user = new User();
		user.setUsername(dto.getUsername());;
		user.setEmail(dto.getEmail());
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12)));
		//user.setPassword(dto.getPassword());
		user.setPhone_number(dto.getPhone_number());
		user.setBirthday(dto.getBirthday());
		user.setRole_id(dto.getRole_id());
		user.setIsAvailable(dto.getIsAvailable());
		userRepository.save(user);
	}

	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();

		List<User> users = userRepository.findAll();
		for (User user : users) {
			dtos.add(new UserDto(user.getId(), user.getUsername(),
					user.getEmail(),user.getPhone_number() , 
					user.getIsAvailable(),user.getPassword() , 
					user.getBirthday(), user.getRegisdate(),
					user.getRole_id() ));
		}
		

		return dtos;
	}

	@Override
	public UserDto findById(int id) {
		User user = userRepository.findById(id).get();
		// 		SOME BUGS HERE --------> FIX IT LATER
		return new UserDto(user.getId(), user.getUsername(),
				user.getEmail(),user.getPhone_number() , 
				user.getIsAvailable(),user.getPassword() , 
				user.getBirthday(), user.getRegisdate(),user.getRole_id());
	
	}

	@Override
	public void update(UserDto dto) {
		User user = userRepository.findById(dto.getId()).get();
		//	SOME BUGS HERE --------> FIX IT LATER

		user.setEmail(dto.getEmail());
		user.setUsername(dto.getUsername());
		user.setIsAvailable(dto.getIsAvailable());
		user.setPhone_number(dto.getPhone_number());
		user.setBirthday(dto.getBirthday());
		user.setRegisdate(dto.getRegisdate());
		user.setRole_id(dto.getRole_id());
		user.setIsAvailable(dto.getIsAvailable());
		userRepository.save(user);
		
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);	
	}

	@Override
	public List<UserDto> search(String keyword) {
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		List<User> users = userRepository.search(keyword);
		// 		SOME BUGS HERE --------> FIX IT LATER 
		for (User user : users) {
			
			dtos.add(new UserDto(user.getId(), user.getUsername(),
					user.getEmail(),user.getPhone_number() , 
					user.getIsAvailable(),user.getPassword() , 
					user.getBirthday(), user.getRegisdate(),user.getRole_id()));
			
		}
		
		return dtos;
	}

	@Override
	public UserDto findByUsername(String username) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
