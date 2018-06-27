package com.thinkxfactor.zomatoplus.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.thinkxfactor.zomatoplus.models.Users;
import com.thinkxfactor.zomatoplus.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/add")
	public Users adduser(@RequestBody Users user) {
		Users persistedUser=userRepository.save(user);
		return persistedUser;
	}
	
	@GetMapping("/getAll")
	public List<Users> getAll(){
		List<Users> listofusers=userRepository.findAll();
		return listofusers;
		}
	
	@PostMapping("/login")
	public String userLogin(@RequestParam("name") String name,@RequestParam("password") String password) {
		Users user=userRepository.findByNameAndPassword(name, password);
		if(user==null) {
			return "Login failed";
		}
		else
			return "Login Successful";
	}
	
/*@PostMapping("/login")
	public Users userLogin(@RequestBody Users user) {
		Users user1 = new Users("abcd","we627",892737352);
		user.setPassword(user1.getPassword());
		user.setPhone(user1.getPhone());
		user.setUsername(user1.getUsername());
		return user;
	}
	@GetMapping("/all")
	public List<Users> userList() {
		List<Users> users = new ArrayList<>();
		Users u1,u2,u3;
		u1=new Users("Arya","123456",45678903);
		u2=new Users("Sheldon","Bazinga",12345678);
		u3=new Users("Sansa","89uiyt",908123487);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		return users;
	}
	@PostMapping("/create")
	public Users userCreate(@RequestBody Users user1) {
		Users user= new Users("hi","abc",1928374);
		System.out.println(user.toString());
		return user;
	}*/
	


	

}