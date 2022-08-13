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

import com.it.dto.PaymentsDTO;


import com.it.service.PaymentService;



@RestController
@RequestMapping("/v1/payments")
public class PaymentsController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public ResponseEntity<Object> getAllPayments(){
		return ResponseEntity.ok(paymentService.findPayAll());
	}
	
	@GetMapping("/{tranSecId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "tranSecId") Integer orderId){
		return ResponseEntity.ok(paymentService.findPaymentsByOrderId(orderId));
	}
	
	@PostMapping
	public ResponseEntity<Object> savePayments(@RequestBody PaymentsDTO paymentsDTO ){
		return ResponseEntity.ok(paymentService.savePayment(paymentsDTO));
	}
	
	@PutMapping("/{tranSecId}")
	public ResponseEntity<Object> updatePayments(@PathVariable(name = "tranSecId") Integer tranSecId, @RequestBody PaymentsDTO paymentsDTO){
		return ResponseEntity.ok(paymentService.updatePayment(tranSecId, paymentsDTO));
	}
	
	@DeleteMapping("/{tranSecId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "tranSecId") Integer tranSecId){
		return ResponseEntity.ok(paymentService.deletePayment(tranSecId));
	}
}
