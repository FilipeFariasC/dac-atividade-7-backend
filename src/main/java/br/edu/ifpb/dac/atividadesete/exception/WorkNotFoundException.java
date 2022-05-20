package br.edu.ifpb.dac.atividadesete.exception;

public class WorkNotFoundException extends Exception {

	private static final long serialVersionUID = -1617897063769800757L;
	
	public WorkNotFoundException(Long id) {
		super(String.format("A obra de id: %d não foi encontrada", id));
	}
	
}
