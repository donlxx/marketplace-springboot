package com.itlize.marketplace.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "ita_user_profile")
public class UserProfile {
	@Id
	@Column(name = "user_profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	
	@Column(name = "role")
	String role;

	public UserProfile() {
		super();
	}

	
	public UserProfile(int id) {
		super();
		this.id = id;
	}


	public UserProfile(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", role=" + role + "]";
	}

	

}
