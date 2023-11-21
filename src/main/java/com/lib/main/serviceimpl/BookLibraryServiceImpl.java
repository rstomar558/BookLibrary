package com.lib.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.main.dto.BookInformationDTO;
import com.lib.main.entity.BookInfoEntity;
import com.lib.main.repository.BookLibraryRepository;
import com.lib.main.service.BookLibraryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookLibraryServiceImpl implements BookLibraryService {

	@Autowired
	BookLibraryRepository repo;

	@Override
	public List<BookInfoEntity> fetchListOfBookFromDatabase() {
		List<BookInfoEntity> allBooks = null;
		try {
			log.info("Received request to fetch books from db");
			allBooks = repo.findAll();
			log.info("All Data successfully retrived from db: " + allBooks);
		} catch (Exception e) {
			log.error("Exception occured AT: " + e.getStackTrace()[0].getLineNumber() + ". Message: " + e.getMessage());
		}
		return allBooks;
	}

	@Override
	public BookInfoEntity fetchBookFromDatabase(String id) {
		BookInfoEntity ent = null;
		try {
			log.info("Received request to fetch book from db");
			Optional<BookInfoEntity> bookById = repo.findById(id);
			ent = bookById.get();
			log.info("Data successfully retrived from db: " + ent);
		} catch (Exception e) {
			log.error("Exception occured AT: " + e.getStackTrace()[0].getLineNumber() + ". Message: " + e.getMessage());
		}
		return ent;
	}

	@Override
	public void insertBookIntoDatabase(BookInformationDTO request) {
		try {
			log.info("Received request to insert book in db");
			BookInfoEntity ent = new BookInfoEntity(request);
			repo.save(ent);
			log.info("Data successfully inserted to db");
		} catch (Exception e) {
			log.error("Exception occured AT: " + e.getStackTrace()[0].getLineNumber() + ". Message: " + e.getMessage());
		}
	}

	@Override
	public void updateBookIntoDatabase(String id, String date) {
		try {
			log.info("Received request to update book in db");
			repo.updatePublishDate(id, date);
			log.info("Data successfully updated in db");
		} catch (Exception e) {
			log.error("Exception occured AT: " + e.getStackTrace()[0].getLineNumber() + ". Message: " + e.getMessage());
		}
	}

	@Override
	public void deleteBookFromDatabase(String id) {
		log.info("Received request to delete book from db");
		repo.deleteById(id);
		log.info("Data successfully deleted from db");
	}

}
