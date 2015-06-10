package br.com.formento.gerenciadorDeBlocos.service.builder;

public interface Director<T> {

	void construirInstancia();

	T getProduct();

}