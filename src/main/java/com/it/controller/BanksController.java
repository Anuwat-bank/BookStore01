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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.BanksDTO;

import com.it.service.BankService;

@RestController
@RequestMapping("/v1/banks")
public class BanksController {

	@Autowired
	private BankService bankService;
  
	@GetMapping
	public ResponseEntity<Object> getAllBanks() {
		return ResponseEntity.ok(bankService.findBanksAll());
	}

	@GetMapping("/{bankId}")
	public ResponseEntity<Object> getBanksByBankId(@PathVariable(name = "bankId") Integer bankId) {
		return ResponseEntity.ok(bankService.findBanksByBankId(bankId));
	}

	@PostMapping
	public ResponseEntity<Object> saveBank(@RequestBody BanksDTO banksDTO) {
		return ResponseEntity.ok(bankService.saveBank(banksDTO));
	}

	@PutMapping("/{bankId}")
	public ResponseEntity<Object> updateBanks(@PathVariable(name = "bankId") Integer bankId,
			@RequestBody BanksDTO bankDto) {
		return ResponseEntity.ok(bankService.updateBank(bankId, bankDto));
	}

	@DeleteMapping("/{bankId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "bankId") Integer bankId) {
		return ResponseEntity.ok(bankService.deleteBank(bankId));
	}
	
	@GetMapping("/userId")
	public ResponseEntity<Object> getAllByUserId(@RequestParam Integer  userId) {
		return ResponseEntity.ok(bankService.findBanksByUserId(userId));
	}

}
