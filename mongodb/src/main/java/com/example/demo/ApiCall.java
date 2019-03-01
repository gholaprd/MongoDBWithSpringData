package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Rameshwar.Gholap
 *
 */
@RestController

public class ApiCall {

	@Autowired
	private ProductRepo productRepo;

	/**
	 * 
	 * @return list of products
	 */

	@GetMapping(value = "getAll")
	public ResponseEntity<?> getAllProducts() {

		List<Products> list = (List<Products>) productRepo.findAll();
		System.out.println(list);
		return new ResponseEntity<List<Products>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "findByPid")
	public ResponseEntity<?> getDetailsByPid(@RequestParam("pid") String pid) {

		List<Products> listOfProducts = productRepo.findByPid(pid);
		if(listOfProducts.isEmpty()) {
			return new ResponseEntity<String>("unable to find products of this=="+pid ,HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Products>>(listOfProducts,HttpStatus.OK);
	}
}
