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

import com.it.dto.UserDTO;

import com.it.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<Object> getAllUsers() {
		return ResponseEntity.ok(userService.findUserAll());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "userId") Integer userId) {

		return ResponseEntity.ok(userService.findUserByuserId(userId));
	}

	@PostMapping
	public ResponseEntity<Object> saveUsers(@RequestBody UserDTO userDto) {
		return ResponseEntity.ok(userService.saveUserAll(userDto));
	}

	@PutMapping("/{userId}")
	public ResponseEntity<Object> updateUser(@PathVariable(name = "userId") Integer userId,
			@RequestBody UserDTO userDto) {
		return ResponseEntity.ok(userService.updateUser(userId, userDto));
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "userId") Integer userId) {
		return ResponseEntity.ok(userService.deleteUserByUserId(userId));
	}

}
