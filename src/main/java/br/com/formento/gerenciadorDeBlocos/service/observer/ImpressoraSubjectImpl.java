package br.com.formento.gerenciadorDeBlocos.service.observer;

import java.util.ArrayList;
import java.util.List;

import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class ImpressoraSubjectImpl implements ImpressoraSubject {

	protected List<ImpressoraObserver> observers;
	protected Relatorio relatorioSimples;

	public ImpressoraSubjectImpl() {
		observers = new ArrayList<ImpressoraObserver>();
	}

	@Override
	public void attach(ImpressoraObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(int indice) {
		observers.remove(indice);
	}

	@Override
	public void setState(Relatorio relatorioSimples) {
		this.relatorioSimples = relatorioSimples;
		notifyObservers();
	}

	private void notifyObservers() {
		for (ImpressoraObserver observer : observers)
			observer.update();
	}

	@Override
	public Relatorio getState() {
		return relatorioSimples;
	}

}
