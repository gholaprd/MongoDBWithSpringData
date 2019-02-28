package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Rameshwar.Gholap
 *
 */
@RestController

public class ApiCall {
	

	@Autowired
	private ProductRepo  productRepo;

	/**
	 * 
	 * @return list of products
	 */
	
	@GetMapping(value="getAll")
	public ResponseEntity<?>getAllProducts(){
	
		List<Products>list=(List<Products>) productRepo.findAll();
		return new ResponseEntity<List<Products>>(list,HttpStatus.OK);
	}
}
