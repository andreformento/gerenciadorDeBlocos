package br.com.formento.gerenciadorDeBlocos.service.iterator;

import java.util.List;

public abstract class IteradorInternoImpl<T> extends IteradorListImpl<T> implements IteradorInterno<T> {

	public IteradorInternoImpl(List<T> listaPercorrer) {
		super(listaPercorrer);
	}

	protected abstract void operacao(T item);

	@Override
	public void percorrerLista() {
		for (first(); !isDone(); next())
			operacao(currentItem());
	}

}
