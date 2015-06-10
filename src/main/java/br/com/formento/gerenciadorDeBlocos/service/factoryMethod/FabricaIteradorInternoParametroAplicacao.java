package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.service.interpreter.ParametroAplicacaoInterpreter;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoParametroAplicacao;

public interface FabricaIteradorInternoParametroAplicacao extends FabricaIteradorInterno<ParametroAplicacaoInterpreter> {

	@Override
	public IteradorInternoParametroAplicacao criarInstancia();

}
