package com.lib.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookInformationDTO {

	private String bookId;
	private String titleOfBook;
	private String authorOfBook;
	private String isbnOfBook;
	private String publishedDateOfBook;
	private String genreOfBook;
}
