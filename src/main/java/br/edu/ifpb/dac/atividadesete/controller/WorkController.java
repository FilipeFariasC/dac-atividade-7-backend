package br.edu.ifpb.dac.atividadesete.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ifpb.dac.atividadesete.model.Obra;
import br.edu.ifpb.dac.atividadesete.model.dto.WorkPostDto;
import br.edu.ifpb.dac.atividadesete.service.AuthorService;
import br.edu.ifpb.dac.atividadesete.service.ValidacaoService;
import br.edu.ifpb.dac.atividadesete.service.WorkService;

@Controller
public class WorkController {
	@Autowired
	private AuthorService autorService;
	
	@Autowired
	private WorkService workService;
	
	@Autowired
	private ValidacaoService validador;
	
	private String titulo;
	
	private Long idAutor;
	
	
	public ResponseEntity<?> salvar(
		@Valid
		@RequestBody
		WorkPostDto postDto) {
		
	}
	public ResponseEntity<?> findAllWorks(){
	}
	
	public ResponseEntity<?>  atualizar(Obra obra) {
		
	}
	public void excluir(Obra obra) {
		
	}
	

	
}