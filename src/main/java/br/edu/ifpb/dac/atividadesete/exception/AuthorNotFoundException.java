package br.edu.ifpb.dac.atividadesete.exception;

public class AuthorNotFoundException extends Exception {
	
	private static final long serialVersionUID = -530743135676829381L;

	public AuthorNotFoundException(Long id) {
		super(String.format("usuário de id: %d não encontrado", id));
	}
}
