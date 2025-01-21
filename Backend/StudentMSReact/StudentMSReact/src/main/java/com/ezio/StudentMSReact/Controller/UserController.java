package com.ezio.StudentMSReact.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezio.StudentMSReact.Entity.User;
import com.ezio.StudentMSReact.Service.UserService;

@Controller
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	@ResponseBody
	public User newUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/showUser")
	@ResponseBody
	public List<User> displayUsers(){
		return userService.showUser();
	}
	
	@GetMapping("/showUserById/{id}")
	@ResponseBody
	public User findByUserId(@PathVariable Long id) {
		return userService.userById(id);
	}
	
	@PutMapping("/editUser/{id}")
	@ResponseBody
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.editUser(user, id);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteuser(id);
	}
	
	
	@GetMapping("/index")
		public String indexPage() {
			return "index";
		}
	
	
}
