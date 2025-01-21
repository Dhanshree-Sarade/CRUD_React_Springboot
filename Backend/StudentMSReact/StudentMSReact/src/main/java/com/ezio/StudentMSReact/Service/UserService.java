package com.ezio.StudentMSReact.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.StudentMSReact.Entity.User;
import com.ezio.StudentMSReact.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> showUser(){
		return userRepository.findAll();
	}

	public User userById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User editUser(User newUser, Long id) {
		return userRepository.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setUsername(newUser.getUsername());
			user.setEmail(newUser.getEmail());
			return userRepository.save(user);
		}).orElseThrow();
	}
	
	public String deleteuser(Long id) {
		userRepository.deleteById(id);
		return "Record deleted successfully";
	}
}
