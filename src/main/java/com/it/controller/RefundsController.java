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


import com.it.dto.RefundsDTO;


import com.it.service.RefundService;

@RestController
@RequestMapping("/v1/refunds")
public class RefundsController {
	
	@Autowired
	private RefundService refundService;
	
	@GetMapping
	public ResponseEntity<Object> getAllRefunds(){
		return ResponseEntity.ok(refundService.findRefunAll());
	}
	
	@GetMapping("/{rfId}")
	public ResponseEntity<Object> getByRefunId(@PathVariable(name = "rfId") Integer rfId){

		return ResponseEntity.ok(refundService.findRefunByRfId(rfId));
	}
	
	@PostMapping
	public ResponseEntity<Object> saveRefun(@RequestBody RefundsDTO refundsDTO ){
		return ResponseEntity.ok(refundService.saveRefun(refundsDTO));
	}
	
	@PutMapping("/{rfId}")
	public ResponseEntity<Object> updateRefunds(@PathVariable(name = "rfId") Integer rfId, @RequestBody RefundsDTO refundsDTO){
		return ResponseEntity.ok(refundService.updateRefun(rfId, refundsDTO));
	}
	
	@DeleteMapping("/{rfId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "rfId") Integer rfId){
		return ResponseEntity.ok(refundService.deleteRefun(rfId));
	}
}
