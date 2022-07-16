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

import com.it.dto.OrderDetailsDTO;


import com.it.service.OrderDetailService;



@RestController
@RequestMapping("/v1/orderDetails")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@GetMapping
	public ResponseEntity<Object> getAllOrderDetails(){
		return ResponseEntity.ok(orderDetailService.findOrderDetailAll());
	}
	
	@GetMapping("/{orderDetailId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "orderDetailId") Integer orderDetailsId){
		
		return ResponseEntity.ok(orderDetailService.findOrderdetailByorderDetailId(orderDetailsId));	
	}
	
	@PostMapping
	public ResponseEntity<Object> saveOrderDetails(@RequestBody OrderDetailsDTO orderDetailsDTO ){
		return ResponseEntity.ok(orderDetailService.saveOrderDetail(orderDetailsDTO));
	}
	
	@PutMapping("/{orderDetailId}")
	public ResponseEntity<Object> updateOrderDetails(@PathVariable(name = "orderDetailId") Integer orderDetailsId, @RequestBody OrderDetailsDTO orderDetailsDTO){
		return ResponseEntity.ok(orderDetailService.updateOrderDetail(orderDetailsId, orderDetailsDTO));
	}
	
	@DeleteMapping("/{orderDetailId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "orderDetailId") Integer orderDetailsId){
		return ResponseEntity.ok(orderDetailService.deleteOrderDetailById(orderDetailsId));
	}

}
