package com.lib.main.service;

import java.util.List;

import com.lib.main.dto.BookInformationDTO;
import com.lib.main.entity.BookInfoEntity;

public interface BookLibraryService {
	
	List<BookInfoEntity> fetchListOfBookFromDatabase();
	
	void insertBookIntoDatabase(BookInformationDTO request);
	
	BookInfoEntity fetchBookFromDatabase(String id);
	
	void updateBookIntoDatabase(String id, String date);

	void deleteBookFromDatabase(String id);

}
