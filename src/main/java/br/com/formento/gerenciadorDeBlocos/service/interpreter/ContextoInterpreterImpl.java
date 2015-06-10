package br.com.formento.gerenciadorDeBlocos.service.interpreter;

public class ContextoInterpreterImpl<INPUT, OUTPUT> implements ContextoInterpreter<INPUT, OUTPUT> {

	private final INPUT input;
	private OUTPUT output;

	public ContextoInterpreterImpl(INPUT input, OUTPUT output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public INPUT getInput() {
		return input;
	}

	@Override
	public OUTPUT getOutput() {
		return output;
	}

}
