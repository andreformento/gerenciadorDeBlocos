package br.com.formento.gerenciadorDeBlocos.service.adapter;

import br.com.formento.gerenciadorDeBlocos.model.OperacaoCritica;
import br.com.formento.gerenciadorDeBlocos.service.iterator.Iterador;

/**
 * É um adaptador de repositorios. Futuramente podem ser usados varios tipos de
 * respositorios utilizando inclusive componentes de terceiros. Todo repositorio
 * tem que ter a possibilidade de Iterar, por isso extende a interface Iterador
 * (Pattern Iterator)
 * 
 * @author andre
 * @param <T>
 *            tipo de repostorio
 */
public interface RepositorioAdapter<T> extends Iterador<T> {

	String getParametro();

	OperacaoCritica abrir();

	OperacaoCritica fechar();

}
