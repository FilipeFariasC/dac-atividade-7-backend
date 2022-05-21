package br.edu.ifpb.dac.atividadesete.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(min=1)
	private String name;
	
	@NotNull
	private LocalDate birthDate;
	
	@NotNull
	@NotEmpty
	@Size(min=1)
	private String birthPlace;
	
	@OneToMany(mappedBy= "author", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<Work> works = new HashSet<>();
	
	
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
	
	public void addWork(Work work) {
		if(work != null)
			this.works.add(work);
	}
	
	public void removeWork(Work work) {
		if(work != null)
			this.works.remove(work);
	}

	public Set<Work> getWorks() {
		return works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
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
		Author other = (Author) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return String.format("id: %d\nnome:%s\n", id, name);
	}
}
