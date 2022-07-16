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

import com.it.dto.ReviewsDTO;


import com.it.service.ReviewService;



@RestController
@RequestMapping("/v1/reviews")
public class ReviewsController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<Object> getAllReviews(){
		return ResponseEntity.ok(reviewService.findReviewAll());
	}
	
	@GetMapping("/{rvId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "rvId") Integer rvId){
		return ResponseEntity.ok(reviewService.findReviewByRvId(rvId));
	}
	
	@PostMapping
	public ResponseEntity<Object> saveReviews(@RequestBody ReviewsDTO reviewsDTO ){
		return ResponseEntity.ok(reviewService.saveReview(reviewsDTO));
	}
	
	@PutMapping("/{rvId}")
	public ResponseEntity<Object> updateReviews(@PathVariable(name = "rvId") Integer rvId, @RequestBody ReviewsDTO reviewsDTO){
		return ResponseEntity.ok(reviewService.updateReview(rvId, reviewsDTO));
	}
	
	@DeleteMapping("/{rvId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "rvId") Integer rvId){
		return ResponseEntity.ok(reviewService.deleteRefun(rvId));
	}

}
