package br.edu.ifpb.dac.atividadesete.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.atividadesete.exception.AuthorNotFoundException;
import br.edu.ifpb.dac.atividadesete.exception.InvalidPublicationDateException;
import br.edu.ifpb.dac.atividadesete.exception.WorkNotFoundException;
import br.edu.ifpb.dac.atividadesete.model.Work;
import br.edu.ifpb.dac.atividadesete.model.dto.WorkDto;
import br.edu.ifpb.dac.atividadesete.model.dto.WorkPostDto;
import br.edu.ifpb.dac.atividadesete.service.MapperService;
import br.edu.ifpb.dac.atividadesete.service.WorkService;

@RestController
@RequestMapping("/api/works")
public class WorkController {
	@Autowired
	private WorkService workService;
	
	@Autowired
	private MapperService mapperService;
	
	@PostMapping
	public ResponseEntity<?> save(
		@Valid
		@RequestBody
		WorkPostDto postDto) {
		
		try {
			Work work = workService.create(postDto);
			
			WorkDto dto = mapperService.mapWorkToDto(work);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		} catch (AuthorNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		} catch (InvalidPublicationDateException exception) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
		}
		
	}
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<WorkDto> dtos = workService.findAll().stream().map(mapperService::mapWorkToDto).toList();
		
		return ResponseEntity.ok(dtos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		try {
			Work work = workService.findById(id);

			WorkDto dto = mapperService.mapWorkToDto(work);
			return ResponseEntity.ok(dto);
		} catch (WorkNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(
			@PathVariable("id") Long id,
			@Valid
			@RequestBody
			WorkPostDto postDto) {
		
		try {
			Work work = workService.update(id, postDto);
			
			WorkDto dto = mapperService.mapWorkToDto(work);
			
			return ResponseEntity.ok(dto);
		} catch (AuthorNotFoundException | WorkNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		} catch (InvalidPublicationDateException exception) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		
		try {
			workService.delete(id);
			
			return ResponseEntity.noContent().build();
		} catch (WorkNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
		
	}
	

	
}