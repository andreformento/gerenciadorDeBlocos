package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraObserver;
import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraObserverConsoleTempoReal;
import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraSubject;
import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraSubjectImpl;

/**
 * @author andre
 */
public class FabricaImpressoraParametro extends FabricaImpressoraImpl {

	private final List<String> argumentos;

	public FabricaImpressoraParametro(String[] argumentos) {
		if (argumentos == null)
			this.argumentos = new ArrayList<String>();
		else
			this.argumentos = Arrays.asList(argumentos);
	}

	/**
	 * * Quando for necessario criar mais impressoras, sera necessario adicionar somente aqui. Poderao ser feitas analises dos parametros para
	 * descobrir quais impressoras devem ser criadas
	 */

	@Override
	public ImpressoraSubject criarInstancia() {
		ImpressoraSubjectImpl instancia = new ImpressoraSubjectImpl();

		if (!argumentos.contains("semImpressora")) {
			ImpressoraObserver impressoraObserver = new ImpressoraObserverConsoleTempoReal(instancia);
			instancia.attach(impressoraObserver);
		}

		return instancia;
	}

}
