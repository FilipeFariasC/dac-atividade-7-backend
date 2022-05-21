package br.edu.ifpb.dac.atividadesete.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="work")
public class Work {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(min=1)
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Author author;
	
	@NotNull
	private LocalDate publicationDate;
	
	@NotNull
	@NotEmpty
	@Size(min=1)
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Work other = (Work) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return String.format("id: %d\ntitulo:%s\n", id, title);
	}
	
}
