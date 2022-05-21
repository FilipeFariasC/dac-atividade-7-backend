package br.edu.ifpb.dac.atividadesete.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.edu.ifpb.dac.atividadesete.model.Work;


public class ValidWorkPublicationValidator implements ConstraintValidator<ValidWorkPublication, Work>{

	@Override
	public boolean isValid(Work value, ConstraintValidatorContext context) {
		
		LocalDate authorBirthDate = value.getAuthor().getBirthDate();
		LocalDate publicationDate = value.getPublicationDate();
		
		return authorBirthDate.isBefore(publicationDate);
	}
	
}
