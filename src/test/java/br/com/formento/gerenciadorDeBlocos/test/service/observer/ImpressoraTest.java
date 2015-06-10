package br.com.formento.gerenciadorDeBlocos.test.service.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraObserverNaoImprimeNada;
import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraSubject;
import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraSubjectImpl;
import br.com.formento.gerenciadorDeBlocos.view.RelatorioImpl;

public class ImpressoraTest {

	private ImpressoraSubject impressoraSubject;

	@Before
	public void inicializar() {
		impressoraSubject = new ImpressoraSubjectImpl();
		impressoraSubject.attach(new ImpressoraObserverNaoImprimeNada(impressoraSubject));
	}

	@Test
	public void impressaoTest() {
		impressoraSubject.setState(new RelatorioImpl("Conteudo 1"));
		assertEquals(0, impressoraSubject.getState().getConteudo().get(0).compareTo("Conteudo 1"));

		impressoraSubject.setState(new RelatorioImpl("Conteudo 2"));
		assertEquals(0, impressoraSubject.getState().getConteudo().get(0).compareTo("Conteudo 2"));

		impressoraSubject.setState(new RelatorioImpl("Conteudo 3"));
		assertNotEquals(0, impressoraSubject.getState().getConteudo().get(0).compareTo("Conteudo 2"));
	}

}
