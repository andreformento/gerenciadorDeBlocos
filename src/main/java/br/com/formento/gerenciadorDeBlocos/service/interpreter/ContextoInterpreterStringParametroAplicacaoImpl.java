package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacaoImpl;

public class ContextoInterpreterStringParametroAplicacaoImpl extends ContextoInterpreterImpl<String[], ParametroAplicacao> implements
		ContextoInterpreterStringParametroAplicacao {

	public ContextoInterpreterStringParametroAplicacaoImpl(String[] parametros) {
		super(parametros, new ParametroAplicacaoImpl());
	}

}
