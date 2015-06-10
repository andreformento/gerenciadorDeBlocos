package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;

public interface ContextoInterpreterStringParametroAplicacao extends ContextoInterpreter<String[], ParametroAplicacao> {

	@Override
	String[] getInput();

	@Override
	ParametroAplicacao getOutput();

}