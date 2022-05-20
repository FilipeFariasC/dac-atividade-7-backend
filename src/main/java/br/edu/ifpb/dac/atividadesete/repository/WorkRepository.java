package br.edu.ifpb.dac.atividadesete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.dac.atividadesete.model.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {
	
	@Query("SELECT a.works FROM Author a WHERE a.id = :id")
	List<Work> findByAuthor(@Param("id") Long id);
}
