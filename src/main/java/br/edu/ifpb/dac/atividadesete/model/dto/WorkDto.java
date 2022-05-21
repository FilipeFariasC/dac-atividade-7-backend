package br.edu.ifpb.dac.atividadesete.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkDto {

	private Long id;
	private String title;
	private Long authorId;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate publicationDate;
	private String genre;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
