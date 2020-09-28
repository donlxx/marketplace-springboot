package com.itlize.marketplace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.marketplace.Service.UserService;
import com.itlize.marketplace.beans.User;
import com.itlize.marketplace.http.Response;


@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService us;
	@Autowired
    private PasswordEncoder bcryptEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		if(us.getByUsername(user.getUsername())!=null)
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		System.out.println(user);
		us.register(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
		
	}
	
	@GetMapping
	public List<User> getAll() {
		System.out.println("/users: ");
		return us.getAll();
	}
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return us.getById(id); 
	}
	
	@GetMapping("/checkusername/{username}")
	public Response checkUsername(@PathVariable String username) {
		if(us.getByUsername(username)==null) return new Response(true);
		else return new Response(false);
	}
	
	
	@PostMapping
	public Response addUser(@RequestBody User user) {
		return us.register(user);
	}
	
	@PostMapping("/admin")
	public Response addAdminUser(@RequestBody User user) {
		return us.registerAdmin(user);
	}
	
	@PostMapping("/edit")
	public Response editUser(@RequestBody User user) {
		System.out.println("*************in edit controller**************");
		return us.editUser(user);
	}
	
	@PutMapping
	public Response changeUser(@RequestBody User user) {
		return us.changePassword(user);
	}
	@DeleteMapping("/{id}")
	public Response deleteUser(@PathVariable int id) {
		return us.deleteUser(id);
	}
}
