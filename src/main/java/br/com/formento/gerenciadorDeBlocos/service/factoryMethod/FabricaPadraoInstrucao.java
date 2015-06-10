package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucao;

public interface FabricaPadraoInstrucao extends FabricaFactoryMethod<PadraoInstrucao> {

	@Override
	PadraoInstrucao criarInstancia();

}
