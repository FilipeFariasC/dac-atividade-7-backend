package br.edu.ifpb.dac.atividadesete.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.atividadesete.exception.AuthorNotFoundException;
import br.edu.ifpb.dac.atividadesete.model.Author;
import br.edu.ifpb.dac.atividadesete.model.dto.AuthorPostDto;
import br.edu.ifpb.dac.atividadesete.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private MapperService mapper;
	
	public Author save(AuthorPostDto postDto) {
		
		Author author = mapper.mapDtoToAuthor(postDto);
		
		return authorRepo.save(author);
	}
	public List<Author> findAll(){
		return authorRepo.findAll();
	}
	public Author findById(Long id) throws AuthorNotFoundException {
		Optional<Author> register = authorRepo.findById(id);
		
		if(register.isEmpty()) 
			throw new AuthorNotFoundException(id);
		
		return register.get();
	}
	
	public Author update(Long id, AuthorPostDto postDto) throws AuthorNotFoundException {
		Optional<Author> register = authorRepo.findById(id);
		
		if(register.isEmpty())
			throw new AuthorNotFoundException(id);
		
		Author author = mapper.mapDtoToAuthor(postDto);
		
		return authorRepo.save(author);
	}
	public void delete(Long id) throws AuthorNotFoundException {
		if(!authorRepo.existsById(id))
			throw new AuthorNotFoundException(id);
		
		authorRepo.deleteById(id);
	}
	
}
