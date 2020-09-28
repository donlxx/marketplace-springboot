package com.itlize.marketplace.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itlize.marketplace.beans.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {
	
}
