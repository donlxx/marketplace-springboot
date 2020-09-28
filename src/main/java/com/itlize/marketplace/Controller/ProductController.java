package com.itlize.marketplace.Controller;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.marketplace.Service.ProductService;
import com.itlize.marketplace.beans.Product;

@CrossOrigin(origins = "*", allowedHeaders = "*",allowCredentials="true")
@RestController
public class ProductController {
	@Autowired
	ProductService ps;
	
    @GetMapping("/product") 
    public ResponseEntity<List<Product>> getAllProducts() {
 
        List<Product> products = ps.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
    	Product product = ps.getById(id);
    	return new ResponseEntity<>(product, HttpStatus.OK);
    }
 
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product p) {
 
        ps.save(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
 
    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product p) {
 
        ps.edit(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
 
    @DeleteMapping("/product")
    public ResponseEntity<Product> deleteEmployee(@RequestBody Product p) {
 
        ps.delete(p);
        return new ResponseEntity<>(p , HttpStatus.OK);
    }

	
}
