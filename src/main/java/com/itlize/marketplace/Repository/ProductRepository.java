package com.itlize.marketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itlize.marketplace.beans.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	Product findByName(String name);
}
