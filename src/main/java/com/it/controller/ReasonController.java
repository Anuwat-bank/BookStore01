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
import com.it.dto.ReasonDTO;
import com.it.service.ReasonService;

@RestController
@RequestMapping("/v1/reasons")
public class ReasonController {
	
	@Autowired
	private ReasonService reasonService;
	
	@GetMapping
	public ResponseEntity<Object> getAllReasons() {
		return ResponseEntity.ok(reasonService.findReasonAll());
	}

	@GetMapping("/{reId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "reId") Integer reId) {
		
		return ResponseEntity.ok(reasonService.findReasonByReaId(reId));
	}

	@PostMapping
	public ResponseEntity<Object> saveReasons(@RequestBody ReasonDTO reasoDto) {
		return ResponseEntity.ok(reasonService.saveReason(reasoDto));
	}

	@PutMapping("/{reId}")
	public ResponseEntity<Object> updateReasons(@PathVariable(name = "reId") Integer reId,
			@RequestBody ReasonDTO reasoDto) {
		return ResponseEntity.ok(reasonService.updateReason(reId, reasoDto));
	}

	@DeleteMapping("/{reId}")
	public ResponseEntity<Object> deleteByReaId(@PathVariable(name = "reId") Integer reId) {
		return ResponseEntity.ok(reasonService.deleteReason(reId));
	}


}
