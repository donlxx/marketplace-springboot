package com.itlize.marketplace.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itlize.marketplace.Repository.UserRepository;
import com.itlize.marketplace.beans.User;
import com.itlize.marketplace.beans.UserProfile;
import com.itlize.marketplace.http.Response;


@Service
public class UserService {
	
	@Autowired
	UserRepository up;

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	public User getById(int id) {

		return up.findById(id).get();

	}
	
	public User getByUsername(String username){
		return up.findByUsername(username);
	}

	public List<User> getAll() {
		System.out.println("users Service: ");

		return up.findAll();
	}

	public Response register(User user) {
//		User tempUser= up.findByUsername(user.getUsername());
//		if(tempUser!=null) return new Response(false);
//		System.out.print("user password: " + user.getPassword());
////		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		System.out.print("user hashed password: " + user.getPassword());
//		UserProfile userProfile = new UserProfile(2);
//		user.setUserProfile(userProfile);
//		System.out.println("*********userService: register*************");
		up.save(user);
		System.out.println(user);
		return new Response(true);
	}
	
	public Response registerAdmin(User user) {
		
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserProfile userProfile = new UserProfile(1);
		user.setUserProfile(userProfile);
		up.save(user);
		System.out.println(user);
		return new Response(true);
	}
	
	public Response editUser(User user) {
		
		User tempUser=up.findByUsername(user.getUsername());
		if(tempUser!=null) {
			
			System.out.println("*************in edit service**************");

		tempUser.setEmail(user.getEmail());
		tempUser.setName(user.getName());
		tempUser.setPhone(user.getPhone());
		tempUser.setSex(user.getSex());
		System.out.println("***********************************");
		System.out.println("***********************************");
		System.out.println("***********************************");
		System.out.println("***********************************");

		System.out.println("the edited user is : "+tempUser);
		up.save(tempUser);
		return new Response(true);}
		return new Response(false);
	}

	public Response changePassword(User user) {
		
			User u = up.findByUsername(user.getUsername());
//			u.setPassword(passwordEncoder.encode(user.getPassword()));
			up.save(u);
			return new Response(true);
	}

//	public boolean isAdmin(Collection<? extends GrantedAuthority> userProfiles) {
//		boolean isAdmin = false;
//		for (GrantedAuthority userProfile : userProfiles) {
//			if (userProfile.getAuthority().equals("admin"))
//				;
//		}
//
//		return isAdmin;
//	}

	public Response deleteUser(int id) {
		if (up.findById(id).get() != null) {
			up.deleteById(id);
			return new Response(true);
		} else {
			return new Response(false, "User is not found!");
		}
	}


}
