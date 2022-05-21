package br.edu.ifpb.dac.atividadesete.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkPostDto {

	@NotNull
	@NotEmpty
	@Size(min=1)
	private String title;
	
	@NotNull
	@Min(0)
	private Long authorId;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate publicationDate;
	
	@NotNull
	@NotEmpty
	@Size(min=1)
	private String genre;
	
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
