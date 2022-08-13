package com.it.controller;

import javax.servlet.http.HttpServletRequest;

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

import com.it.dto.BooksDTO;

import com.it.service.BookService;

@RestController
@RequestMapping("/v1/books")
public class BooksController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<Object> getAllBooks() {
		return ResponseEntity.ok(bookService.findBookAll());
	}

	@GetMapping("/{bId}")
	public ResponseEntity<Object> getById(@PathVariable(name = "bId") Integer bId) {

		return ResponseEntity.ok(bookService.findBookByBookId(bId));
	}

	@PostMapping
	public ResponseEntity<Object> saveBooks(@RequestBody BooksDTO bookDTO,HttpServletRequest request) {
		return ResponseEntity.ok(bookService.saveBook(bookDTO));
	}

	@PutMapping("/{bId}")
	public ResponseEntity<Object> saveBooks(@PathVariable(name = "bId") Integer bId, @RequestBody BooksDTO bookDTO) {
		return ResponseEntity.ok(bookService.updateBook(bId, bookDTO));
	}

	@DeleteMapping("/{bId}")
	public ResponseEntity<Object> deleteById(@PathVariable(name = "bId") Integer bId) {
		return ResponseEntity.ok(bookService.deleteBook(bId));
	}

}
