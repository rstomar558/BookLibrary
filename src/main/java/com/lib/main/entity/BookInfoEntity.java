package com.lib.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lib.main.dto.BookInformationDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "book_info")
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoEntity {

	@Id
	private String id;
	private String title;
	private String author;
	private String isbn;
	private String publishedDate;
	private String genre;
	
	public BookInfoEntity(BookInformationDTO request) {
		this.id = request.getBookId();
		this.title = request.getTitleOfBook();
		this.author = request.getAuthorOfBook();
		this.isbn = request.getIsbnOfBook();
		this.publishedDate = request.getPublishedDateOfBook();
		this.genre = request.getGenreOfBook();
	}
}
