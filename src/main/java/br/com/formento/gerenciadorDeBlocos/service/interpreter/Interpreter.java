package br.com.formento.gerenciadorDeBlocos.service.interpreter;

public interface Interpreter<INPUT, OUTPUT> {

	void interpretar(ContextoInterpreter<INPUT, OUTPUT> contextoInterpreter);

}