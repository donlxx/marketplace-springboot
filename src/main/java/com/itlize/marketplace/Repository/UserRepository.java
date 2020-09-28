package com.itlize.marketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itlize.marketplace.beans.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUsername(String username);
}
