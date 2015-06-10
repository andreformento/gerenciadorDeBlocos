package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacao;

public interface FabricaContextoInterpreterStringParametroAplicacao extends FabricaContextoInterpreter<String[], ParametroAplicacao> {

	@Override
	public ContextoInterpreterStringParametroAplicacao criarInstancia();

}
