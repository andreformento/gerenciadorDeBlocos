package br.com.formento.gerenciadorDeBlocos.test.business.instrucao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.EstruturaMover;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamentoValido;
import br.com.formento.gerenciadorDeBlocos.model.EntidadeMovel;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadePlataformaImpl;
import br.com.formento.gerenciadorDeBlocos.model.Plataforma;
import br.com.formento.gerenciadorDeBlocos.model.PlataformaImpl;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;
import br.com.formento.gerenciadorDeBlocos.view.RelatorioImpl;

public class EstruturaMoverTest {

	private Relatorio relatorio;
	private CenarioProcessamento cenarioProcessamento;

	@Before
	public void instanciar() {
		cenarioProcessamento = new CenarioProcessamentoValido();
		cenarioProcessamento.configurarEstruturaDado(6, 1);

		relatorio = new RelatorioImpl();
	}

	@Test
	public void moverComSucessoTest() {
		EstruturaMover estruturaMover;

		estruturaMover = new EstruturaMover("mover P3 para P4", cenarioProcessamento, relatorio);
		assertTrue(relatorio.toString(), estruturaMover.isMontadoComSucesso());

		EntidadeMovel entidadeMovel = new PlataformaImpl(new IdentidadePlataformaImpl(3));
		assertEquals(relatorio.toString(), entidadeMovel, estruturaMover.getOrigem());

		Plataforma plataforma = new PlataformaImpl(new IdentidadePlataformaImpl(4));
		assertEquals(relatorio.toString(), plataforma, estruturaMover.getDestino());
	}

	@Test
	public void moverSemSucessoTest() {
		EstruturaMover estruturaMover;

		estruturaMover = new EstruturaMover("mover P3 para P4 u", cenarioProcessamento, relatorio);
		assertFalse(relatorio.toString(), estruturaMover.isMontadoComSucesso());
	}

}
