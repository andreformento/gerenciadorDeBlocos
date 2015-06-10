package br.com.formento.gerenciadorDeBlocos.test.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.model.Bloco;
import br.com.formento.gerenciadorDeBlocos.model.BlocoImpl;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamentoValido;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadeBlocoImpl;

public class BlocoTest {

	private CenarioProcessamento cenarioProcessamento;

	@Before
	public void instanciar() {
		cenarioProcessamento = new CenarioProcessamentoValido();
		cenarioProcessamento.configurarEstruturaDado(4, 1);
	}

	@Test
	public void moverBlocoTest() {
		Bloco bloco2 = new BlocoImpl(new IdentidadeBlocoImpl(2));

		assertTrue(cenarioProcessamento.isEstruturaConfigurada());

		Bloco blocoPesquisa = cenarioProcessamento.getEstruturaDado().getMapaDeBlocos().get(bloco2.getIdentidade());

		assertNotNull(blocoPesquisa);
	}
}
