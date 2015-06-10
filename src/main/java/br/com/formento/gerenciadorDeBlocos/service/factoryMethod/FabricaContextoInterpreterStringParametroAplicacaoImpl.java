package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacaoImpl;

/**
 * @author andre
 */
public class FabricaContextoInterpreterStringParametroAplicacaoImpl extends FabricaContextoInterpreterImpl<String[], ParametroAplicacao> implements
		FabricaContextoInterpreterStringParametroAplicacao {

	private String[] parametros;

	public FabricaContextoInterpreterStringParametroAplicacaoImpl(String[] parametros) {
		this.parametros = parametros;
	}

	@Override
	public ContextoInterpreterStringParametroAplicacao criarInstancia() {
		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		return contextoInterpreter;
	}

}
