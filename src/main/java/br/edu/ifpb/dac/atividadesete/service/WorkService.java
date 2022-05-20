package br.edu.ifpb.dac.atividadesete.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.atividadesete.exception.AuthorNotFoundException;
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
	
	public Work create(WorkPostDto dto) throws AuthorNotFoundException {
		Author author = authorService.findById(dto.getAuthorId());
		
		Work work = mapper.mapDtoToWork(dto);
		work.setAuthor(author);
		
		return workRepo.save(work);
	}
	
	public List<Work> findAll(){
		return workRepo.findAll();
	}
	public Work findById(Long id) throws WorkNotFoundException {
		Optional<Work> register = workRepo.findById(id);
		
		if(register.isEmpty()) {
			throw new WorkNotFoundException(id);
		}
		
		return register.get();
	}
	
	public Work update(Long id, WorkPostDto dto) throws WorkNotFoundException, AuthorNotFoundException {
		Optional<Work> register = workRepo.findById(id);
		
		if(register.isEmpty()) {
			throw new WorkNotFoundException(id);
		}
		Work work = register.get();
		Author author = work.getAuthor();
		Author update = author;
		if(!author.getId().equals(dto.getAuthorId())) {
			update = authorService.findById(dto.getAuthorId());
		}
		work.setAuthor(update);
		
		return workRepo.save(work);
	}
	public void delete(Long id) throws WorkNotFoundException {
		if(!workRepo.existsById(id)) {
			throw new WorkNotFoundException(id);
		}
		workRepo.deleteById(id);
	}
	
}
