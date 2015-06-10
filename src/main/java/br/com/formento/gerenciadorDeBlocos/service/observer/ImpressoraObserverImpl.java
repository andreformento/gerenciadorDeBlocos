package br.com.formento.gerenciadorDeBlocos.service.observer;

public abstract class ImpressoraObserverImpl implements ImpressoraObserver {

	protected ImpressoraSubject impressoraSubject;

	public ImpressoraObserverImpl(ImpressoraSubject impressoraSubject) {
		this.impressoraSubject = impressoraSubject;
	}

	@Override
	public abstract void update();

}