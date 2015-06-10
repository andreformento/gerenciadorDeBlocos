package br.com.formento.gerenciadorDeBlocos.service.observer;

/**
 * Impressora utilizada nos testes
 * 
 * @author andre
 */
public class ImpressoraObserverNaoImprimeNada extends ImpressoraObserverImpl {

	public ImpressoraObserverNaoImprimeNada(ImpressoraSubject impressoraSubject) {
		super(impressoraSubject);
	}

	@Override
	public void update() {
	}

}
