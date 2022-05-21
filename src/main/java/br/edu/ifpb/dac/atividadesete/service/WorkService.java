package br.edu.ifpb.dac.atividadesete.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.atividadesete.exception.AuthorNotFoundException;
import br.edu.ifpb.dac.atividadesete.exception.InvalidPublicationDateException;
import br.edu.ifpb.dac.atividadesete.exception.WorkNotFoundException;
import br.edu.ifpb.dac.atividadesete.model.Author;
import br.edu.ifpb.dac.atividadesete.model.Work;
import br.edu.ifpb.dac.atividadesete.model.dto.WorkPostDto;
import br.edu.ifpb.dac.atividadesete.repository.WorkRepository;

@Service
public class WorkService {
	
	@Autowired
	private WorkRepository workRepo;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private MapperService mapper;
	
	@Autowired
	private ValidationService validator;
	
	public Work create(WorkPostDto dto) throws AuthorNotFoundException, InvalidPublicationDateException {
		Author author = authorService.findById(dto.getAuthorId());
		
		Work work = mapper.mapDtoToWork(dto);
		work.setAuthor(author);
		if(!validator.validPublicationDate(work)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String publicationFormatted = work.getPublicationDate().format(formatter);
			String birthDateFormatted = author.getBirthDate().format(formatter);
			
			throw new InvalidPublicationDateException(publicationFormatted, birthDateFormatted);
		}
		
		
		return workRepo.save(work);
	}
	
	public List<Work> findAll(){
		return workRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	public Work findById(Long id) throws WorkNotFoundException {
		Optional<Work> register = workRepo.findById(id);
		
		if(register.isEmpty()) {
			throw new WorkNotFoundException(id);
		}
		
		return register.get();
	}
	
	public Work update(Long id, WorkPostDto dto) throws WorkNotFoundException, AuthorNotFoundException, InvalidPublicationDateException {
		Optional<Work> register = workRepo.findById(id);
		
		if(register.isEmpty()) {
			throw new WorkNotFoundException(id);
		}

		Work updated = mapper.mapDtoToWork(dto);
		
		Work work = register.get();
		Author author = work.getAuthor();
		Author update = author;
		if(!author.getId().equals(dto.getAuthorId())) {
			update = authorService.findById(dto.getAuthorId());
		}
		if(!validator.validPublicationDate(work)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String publicationFormatted = work.getPublicationDate().format(formatter);
			String birthDateFormatted = author.getBirthDate().format(formatter);
			
			throw new InvalidPublicationDateException(publicationFormatted, birthDateFormatted);
		}
		updated.setAuthor(update);
		updated.setId(id);
		
		return workRepo.save(updated);
	}
	
	public void delete(Long id) throws WorkNotFoundException {
		if(!workRepo.existsById(id)) {
			throw new WorkNotFoundException(id);
		}
		workRepo.deleteById(id);
	}
	
}
