package com.lib.main.serviceTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;

import com.lib.main.dto.BookInformationDTO;
import com.lib.main.entity.BookInfoEntity;
import com.lib.main.repository.BookLibraryRepository;
import com.lib.main.service.BookLibraryService;

@SpringBootTest
public class BookLibraryServiceTest {

	@Autowired
	BookLibraryService service;

	@MockBean
	BookLibraryRepository repo;

	List<BookInfoEntity> allBooks = new ArrayList<BookInfoEntity>();

	BookInfoEntity bookInfo = null;

	Optional<BookInfoEntity> bookByIdOpt = null;

	BookInformationDTO bookInformationDTO = null;

	BookInfoEntity bookInfoData = null;

	@BeforeEach
	public void setUp() {

		// create new Obj And Set The Data
		bookInfo = new BookInfoEntity();
		bookInfo.setId("123");
		bookInfo.setAuthor("Pankaj Kumar");
		bookInfo.setGenre("AnyName");
		bookInfo.setIsbn("1275AGSL904AE");
		bookInfo.setPublishedDate("2023-10-10");
		bookInfo.setTitle("BioGraphi");
		// Add in list
		allBooks.add(bookInfo);

		// add in Optional
		bookByIdOpt = Optional.of(bookInfo);

		bookInformationDTO = new BookInformationDTO();
		bookInformationDTO.setAuthorOfBook("Pankaj Kumar");
		bookInformationDTO.setBookId("123");
		bookInformationDTO.setGenreOfBook("AnyName");
		bookInformationDTO.setIsbnOfBook("1275AGSL904AE");
		bookInformationDTO.setPublishedDateOfBook("2023-10-10");
		bookInformationDTO.setTitleOfBook("BioGraphi");

		bookInfoData = new BookInfoEntity(bookInformationDTO);
	}

	@AfterEach
	public void setDown() {

		// If need to closed any Obj After Each method then We add code.

	}

	@Test
	public void fetchListOfBookFromDatabaseTest() {
		when(repo.findAll()).thenReturn(allBooks);
		service.fetchListOfBookFromDatabase();
	}

	@SuppressWarnings("serial")
	@Test
	public void fetchListOfBookFromDatabaseTestFailedCase() {
		when(repo.findAll()).thenThrow(new DataAccessException("while fetching List Of Book getting exception") {
		});
		service.fetchListOfBookFromDatabase();
	}

	@Test
	public void fetchBookFromDatabaseSuccessCase() {

		String id = "123";

		when(repo.findById(id)).thenReturn(bookByIdOpt);

		service.fetchBookFromDatabase(id);
	}

	@SuppressWarnings("serial")
	@Test
	public void fetchBookFromDatabaseFailedCase() {

		String id = "123";

		when(repo.findById(id)).thenThrow(new DataAccessException("while fetching List Of Book getting exception") {
		});

		service.fetchBookFromDatabase(id);
	}

	@Test
	public void insertBookIntoDatabaseSuccessCase() {

		when(repo.save(bookInfoData)).thenReturn(bookInfoData);

		service.insertBookIntoDatabase(bookInformationDTO);

	}

	@Test
	public void insertBookIntoDatabaseFailedCasse() {

		when(repo.save(bookInfoData));

		service.insertBookIntoDatabase(bookInformationDTO);

	}

	@Test
	public void updateBookIntoDatabaseSuccessCase() {

		String id = "123";

		String date = "2023-10-10";

		when(repo.updatePublishDate(id, date)).thenReturn(1);

		service.updateBookIntoDatabase(id, date);

	}

	@SuppressWarnings("serial")
	@Test
	public void updateBookIntoDatabaseFailedCase() {

		String id = "123";

		String date = "2023-10-10";

		when(repo.updatePublishDate(id, date))
				.thenThrow(new DataAccessException("while updating book in db getting exception") {
				});

		service.updateBookIntoDatabase(id, date);

	}
	
	@Test
	public void deleteBookFromDatabase() {
		
		String id = "123";
		
		service.deleteBookFromDatabase(id);
		
	}
	
}
