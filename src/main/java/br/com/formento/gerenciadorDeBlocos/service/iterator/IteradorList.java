package br.com.formento.gerenciadorDeBlocos.service.iterator;

import java.util.List;

public interface IteradorList<T> extends Iterador<T> {

	void voltar();

	List<T> getListaPercorrer();

}