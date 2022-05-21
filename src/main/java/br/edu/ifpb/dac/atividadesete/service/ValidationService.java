package br.edu.ifpb.dac.atividadesete.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.atividadesete.model.Work;

@Service
public class ValidationService {
	
	private Validator validator;
	public ValidationService() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	public boolean validPublicationDate(Work work) {
		Set<ConstraintViolation<Work>> violations = validator.validate(work);
		return !violations.stream()
			.anyMatch(
				violation->violation.getMessageTemplate()
					.toLowerCase()
					.contains("validworkpublication")
			);

	}
	
}
