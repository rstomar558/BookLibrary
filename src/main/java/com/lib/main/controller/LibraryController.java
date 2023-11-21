package com.lib.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.main.dto.BookInformationDTO;
import com.lib.main.entity.BookInfoEntity;
import com.lib.main.service.BookLibraryService;

import lombok.Generated;

@RestController
@RequestMapping("/book")
@Generated
public class LibraryController {

	@Autowired
	BookLibraryService service;
	
	@GetMapping("/retriveall")
	public List<BookInfoEntity> retriveListOfBook() {
		return service.fetchListOfBookFromDatabase();
	}
	
	@GetMapping("/retrive/{id}")
	public BookInfoEntity retriveBook(@PathVariable String id) {
		return service.fetchBookFromDatabase(id);
	}
	
	@PostMapping("/insert")
	public void insertBook(@RequestBody BookInformationDTO request) {
		service.insertBookIntoDatabase(request);
	}
	
	@GetMapping("/update/{id}/{date}")
	public void updateBook(@PathVariable String id, @PathVariable String date) {
		service.updateBookIntoDatabase(id, date);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteBook(@PathVariable String id) {
		service.deleteBookFromDatabase(id);
	}
}
