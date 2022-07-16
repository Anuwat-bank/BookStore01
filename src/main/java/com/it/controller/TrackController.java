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

import com.it.dto.TrackDTO;


import com.it.service.TrackService;

@RestController
@RequestMapping("/v1/tracks")
public class TrackController {
	
	@Autowired
	private  TrackService trackService;
	
	@GetMapping
	public ResponseEntity<Object> getAllTracks() {
		return ResponseEntity.ok(trackService.findTrackAll());
	}

	@GetMapping("/{trackId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "trackId") Integer trackId) {

		return ResponseEntity.ok(trackService.findTrackByTrackId(trackId));
	}

	@PostMapping
	public ResponseEntity<Object> saveTracks(@RequestBody TrackDTO trackDto) {
		return ResponseEntity.ok(trackService.saveTrack(trackDto));
	}

	@PutMapping("/{trackId}")
	public ResponseEntity<Object> updateTracks(@PathVariable(name = "trackId") Integer trackId,
			@RequestBody TrackDTO trackDto) {
		return ResponseEntity.ok(trackService.updateTrack(trackId, trackDto));
	}

	@DeleteMapping("/{trackId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "trackId") Integer trackId) {
		return ResponseEntity.ok(trackService.deleteTrack(trackId));
	}

}
