package br.edu.ifpb.dac.atividadesete.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.atividadesete.model.Author;
import br.edu.ifpb.dac.atividadesete.model.Work;
import br.edu.ifpb.dac.atividadesete.model.dto.AuthorDto;
import br.edu.ifpb.dac.atividadesete.model.dto.AuthorPostDto;
import br.edu.ifpb.dac.atividadesete.model.dto.WorkDto;
import br.edu.ifpb.dac.atividadesete.model.dto.WorkPostDto;

@Service
public class MapperService {
	@Autowired
	private ModelMapper mapper;
	
	public MapperService(){
		PropertyMap<Work, WorkDto> workToDtoMap = new PropertyMap<Work, WorkDto>() {
			
			@Override
			protected void configure() {
				map().setAuthorId(source.getAuthor().getId());
			}
		};
		mapper.addMappings(workToDtoMap);
	}
	
	public Author mapDtoToAuthor(AuthorPostDto dto) {
		return mapper.map(dto, Author.class);
	}
	
	public AuthorDto mapAuthorToDto(Author author) {
		return mapper.map(author, AuthorDto.class);
	}
	
	public Work mapDtoToWork(WorkPostDto dto) {
		return mapper.map(dto, Work.class);
	}
	
	public WorkDto mapWorkToDto(Work work) {
		return mapper.map(work, WorkDto.class);
	}
}
