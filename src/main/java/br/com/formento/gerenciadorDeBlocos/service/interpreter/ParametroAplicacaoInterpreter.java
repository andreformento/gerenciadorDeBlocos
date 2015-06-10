package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;

public interface ParametroAplicacaoInterpreter extends Interpreter<String[], ParametroAplicacao> {

	@Override
	void interpretar(ContextoInterpreter<String[], ParametroAplicacao> contextoInterpreter);

}
