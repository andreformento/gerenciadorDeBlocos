package br.com.formento.gerenciadorDeBlocos.service.iterator;

import java.util.List;

public abstract class IteradorListImpl<T> implements IteradorList<T> {

	private List<T> listaPercorrer;
	private int contador;

	public IteradorListImpl(List<T> listaPercorrer) {
		this.listaPercorrer = listaPercorrer;
		this.contador = 0;
	}

	@Override
	public void first() {
		contador = 0;
	}

	@Override
	public void next() {
		contador++;
	}

	@Override
	public void voltar() {
		contador--;
	}

	@Override
	public boolean isDone() {
		return contador == listaPercorrer.size();
	}

	@Override
	public T currentItem() {
		if (isDone()) {
			contador = listaPercorrer.size() - 1;
		} else if (contador < 0) {
			contador = 0;
		}

		return listaPercorrer.get(contador);
	}

	@Override
	public List<T> getListaPercorrer() {
		return listaPercorrer;
	}

	@Override
	public boolean isVazio() {
		return listaPercorrer.isEmpty();
	}

}
