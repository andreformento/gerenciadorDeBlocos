package br.com.formento.gerenciadorDeBlocos.service.observer;

import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public interface ImpressoraSubject {

	/**
	 * Adiciona impressora
	 * 
	 * @param observer
	 */
	void attach(ImpressoraObserver observer);

	/**
	 * Remove impressora
	 * 
	 * @param indice
	 */
	void detach(int indice);

	/**
	 * Gera impressao
	 * 
	 * @param relatorio
	 */
	void setState(Relatorio relatorio);

	/**
	 * Retorna estado atual
	 * 
	 * @return
	 */
	Relatorio getState();

}
