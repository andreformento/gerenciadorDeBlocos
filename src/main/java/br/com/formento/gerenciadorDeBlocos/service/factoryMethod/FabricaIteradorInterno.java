package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInterno;

public interface FabricaIteradorInterno<T> extends FabricaFactoryMethod<IteradorInterno<T>> {

	@Override
	IteradorInterno<T> criarInstancia();

}
