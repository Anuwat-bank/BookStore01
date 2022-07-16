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

import com.it.dto.UserDetailsDTO;

import com.it.service.UserDetailService;

@RestController
@RequestMapping("/v1/userDetails")
public class UserDetailController {

	@Autowired
	private UserDetailService userDetailService;

	@GetMapping
	public ResponseEntity<Object> getAllUserDetailEntity() {

		return ResponseEntity.ok(userDetailService.findUserDetailAll());
	}

	@GetMapping("/{userDetailId}")
	public ResponseEntity<Object> getUserDetailByUserDetailId(
			@PathVariable(name = "userDetailId") Integer userDetailId) {

		return ResponseEntity.ok(userDetailService.findUserDetailByuserDetailId(userDetailId));
	}

	@PostMapping
	public ResponseEntity<Object> saveUserDetail(@RequestBody UserDetailsDTO userDetailsDto) {
		return ResponseEntity.ok(userDetailService.saveUserDetail(userDetailsDto));
	}

	@PutMapping("/{userDetailId}")
	public ResponseEntity<Object> updateUserDetail(@PathVariable(name = "userDetailId") Integer userDetailId,
			@RequestBody UserDetailsDTO userDetailsDto) {
		return ResponseEntity.ok(userDetailService.updateUserDetail(userDetailId, userDetailsDto));
	}

	@DeleteMapping("/{userDetailId}")
	public ResponseEntity<Object> deleteByUserDetailId(@PathVariable(name = "userDetailId") Integer userDetailId) {
		return ResponseEntity.ok(userDetailService.deleteUserDetailByUserDetailId(userDetailId));
	}
}
