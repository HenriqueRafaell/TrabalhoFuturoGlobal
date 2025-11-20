package br.com.fiap.TrabalhoFuturo.exception;

public class ProfissionalNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProfissionalNotFoundException(String message) {
        super(message);
    }
}
