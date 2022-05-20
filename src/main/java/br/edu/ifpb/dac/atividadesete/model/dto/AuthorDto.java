package br.edu.ifpb.dac.atividadesete.model.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class AuthorDto {

	private Long id;
	private String name;
	private LocalDate birthDate;
	private String birthPlace;
	private Set<WorkDto> works = new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Set<WorkDto> getWorks() {
		return works;
	}
	public void setWorks(Set<WorkDto> works) {
		this.works = works;
	}
	
	
}
