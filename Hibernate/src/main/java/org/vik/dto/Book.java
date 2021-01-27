package org.vik.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="BOOK")
@Embeddable
public class Book {

	//@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private int bookId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DES")
	private String desc;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "ISBN")
	private String isbn;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
