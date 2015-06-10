package br.com.formento.gerenciadorDeBlocos.service.observer;

public class ImpressoraObserverConsoleTempoReal extends ImpressoraObserverImpl {

	public ImpressoraObserverConsoleTempoReal(ImpressoraSubject impressoraSubject) {
		super(impressoraSubject);
	}

	@Override
	public void update() {
		for (String informacao : impressoraSubject.getState().getConteudo())
			System.out.println(informacao);
	}

}
