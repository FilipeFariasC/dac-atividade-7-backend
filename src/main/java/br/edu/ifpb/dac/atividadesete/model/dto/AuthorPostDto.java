package br.edu.ifpb.dac.atividadesete.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthorPostDto {

	
	@NotNull
	@NotEmpty
	@Size(min=3)
	private String name;
	
	@NotNull
	private LocalDate birthDate;
	
	@NotNull
	@NotEmpty
	@Size(min=3)
	private String birthPlace;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
}
