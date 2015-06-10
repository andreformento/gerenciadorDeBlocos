package br.com.formento.gerenciadorDeBlocos.service.interpreter;

public interface ContextoInterpreter<INPUT, OUTPUT> {

	INPUT getInput();

	OUTPUT getOutput();

}
