package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.service.OrderStoreService;

@RestController
@RequestMapping("/v1/orderstore")
public class OrderStoreController {
	
	@Autowired
	private OrderStoreService orderStoreService;
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<Object> getByUserId(@PathVariable(name = "userId") Integer userId){
	
		return ResponseEntity.ok(orderStoreService.findOrderByUserId(userId));	
	}
	
	@GetMapping("/{cId}")
	public ResponseEntity<Object> getByCid(@RequestParam(name = "cId") Integer cId){
	
		return ResponseEntity.ok(orderStoreService.findByCid(cId));	
	}
	
	
	//@GetMapping("/getOrder/{cId}")
	//public ResponseEntity<Object> getBycId(@PathVariable(name = "cId") Integer cId){
	
		//return ResponseEntity.ok(orderStoreService.findOrderBycId(cId));	
	//}
	
}
