package br.com.formento.gerenciadorDeBlocos.service.iterator;

public interface Iterador<T> {

	void first();

	void next();

	T currentItem();

	boolean isDone();

	boolean isVazio();

}
