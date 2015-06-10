package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraSubject;

public interface FabricaImpressora extends FabricaFactoryMethod<ImpressoraSubject> {

	@Override
	ImpressoraSubject criarInstancia();

}
