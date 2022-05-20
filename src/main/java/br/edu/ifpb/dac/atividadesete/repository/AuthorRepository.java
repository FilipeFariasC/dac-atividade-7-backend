package br.edu.ifpb.dac.atividadesete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.atividadesete.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
