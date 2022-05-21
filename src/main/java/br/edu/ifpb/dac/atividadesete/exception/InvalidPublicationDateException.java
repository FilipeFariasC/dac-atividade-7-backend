package br.edu.ifpb.dac.atividadesete.exception;

public class InvalidPublicationDateException extends Exception {

	private static final long serialVersionUID = 2819799051182555392L;
	
	public InvalidPublicationDateException(String publication, String birth) {
		super(String.format("A data de publicação %s vem antes da data de nascimento %s", publication, birth));
	}
	
}
