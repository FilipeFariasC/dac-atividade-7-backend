package br.edu.ifpb.dac.atividadesete.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthorPostDto {

	
	@NotNull
	@NotEmpty
	@Size(min=1)
	private String name;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate birthDate;
	
	@NotNull
	@NotEmpty
	@Size(min=1)
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
