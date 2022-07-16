package com.it.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.OrdersDTO;



import com.it.service.OrderService;




@RestController
@RequestMapping("/v1/orders")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<Object> getAllOrders(){
		return ResponseEntity.ok(orderService.findOrderAll());
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "orderId") Integer orderId){
	
		return ResponseEntity.ok(orderService.findOrderById(orderId));	
	}
	
	@PostMapping
	public ResponseEntity<Object> saveOrders(@RequestBody OrdersDTO ordersDto){
		return ResponseEntity.ok(orderService.saveOrder(ordersDto));
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity<Object> saveOrders(@PathVariable(name = "orderId") Integer orderId, @RequestBody OrdersDTO ordersDto){
		return ResponseEntity.ok(orderService.updateOrder(orderId, ordersDto));
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "orderId") Integer orderId){
		return ResponseEntity.ok(orderService.deleteOrder(orderId));
	}
	

}
