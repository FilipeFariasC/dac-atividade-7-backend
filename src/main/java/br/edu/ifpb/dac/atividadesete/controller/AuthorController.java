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
import br.edu.ifpb.dac.atividadesete.model.Author;
import br.edu.ifpb.dac.atividadesete.model.dto.AuthorDto;
import br.edu.ifpb.dac.atividadesete.model.dto.AuthorPostDto;
import br.edu.ifpb.dac.atividadesete.service.AuthorService;
import br.edu.ifpb.dac.atividadesete.service.MapperService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private MapperService mapperService;
	
	@PostMapping
	public ResponseEntity<?> save(
		@Valid
		@RequestBody
		AuthorPostDto postDto) {
		
		Author author = authorService.save(postDto);
		
		AuthorDto dto = mapperService.mapAuthorToDto(author);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	@GetMapping
	public ResponseEntity<?>  findAll(){
		List<AuthorDto> authors = authorService.findAll().stream().map(mapperService::mapAuthorToDto).toList();
		
		
		return ResponseEntity.ok(authors);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			Author author = authorService.findById(id);
			
			AuthorDto dto = mapperService.mapAuthorToDto(author);
			return ResponseEntity.ok(dto);
		} catch (AuthorNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>  update(
		@PathVariable("id") Long id,
		@Valid
		@RequestBody AuthorPostDto postDto
		) {
		
		try {
			Author author = authorService.update(id, postDto);
			
			AuthorDto dto = mapperService.mapAuthorToDto(author);
			return ResponseEntity.ok(dto);
		} catch (AuthorNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			authorService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (AuthorNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
	}

	
}
