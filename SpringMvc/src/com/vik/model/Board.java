package com.vik.model;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vik.embeddable.Contact;

public class Board {
	
	@NotNull
	@Digits(integer=10, fraction=0, message="Maximum {2} digits allowed")
	private Long boardId;
	
	@Size(min=1, max=200)
	private String boardName;
	
	@Size(min=1, max=1000, message="{0} must have length {2} to {1}")
	private String desc;
	
	@Valid
	private Contact contact;

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
