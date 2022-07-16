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

import com.it.dto.CatagorysDTO;
import com.it.service.CatagoryService;

@RestController
@RequestMapping("/v1/catagorys")
public class CatagoryController {
	
	@Autowired
	private CatagoryService catagoryService;
 
	@GetMapping
	public ResponseEntity<Object> getAllCatagorys() {
		return ResponseEntity.ok(catagoryService.findCatagoryAll());
	}

	@GetMapping("/{cateId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "cateId") Integer cateId) {
		return ResponseEntity.ok(catagoryService.findCateByCateId(cateId));	
	}

	@PostMapping
	public ResponseEntity<Object> saveCatagorys(@RequestBody CatagorysDTO cataDto) {
		return ResponseEntity.ok(catagoryService.saveCatagory(cataDto));
	}

	@PutMapping("/{cateId}")
	public ResponseEntity<Object> saveCatagorys(@PathVariable(name = "cateId") Integer cateId,
			@RequestBody CatagorysDTO cataDto) {
		return ResponseEntity.ok(catagoryService.updateCatagory(cateId, cataDto));
	}

	@DeleteMapping("/{cateId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "cateId") Integer cateId) {
		return ResponseEntity.ok(catagoryService.deleteCatagory(cateId));
	}

	
}
