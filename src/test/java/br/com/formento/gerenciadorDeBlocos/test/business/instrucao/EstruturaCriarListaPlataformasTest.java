package br.com.formento.gerenciadorDeBlocos.test.business.instrucao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.EstruturaCriarListaPlataformasImpl;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamentoValido;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;
import br.com.formento.gerenciadorDeBlocos.view.RelatorioImpl;

public class EstruturaCriarListaPlataformasTest {

	private Relatorio relatorio;
	private CenarioProcessamento cenarioProcessamento;

	@Before
	public void instanciar() {
		relatorio = new RelatorioImpl();

		cenarioProcessamento = new CenarioProcessamentoValido();
		cenarioProcessamento.configurarEstruturaDado(6, 1);
	}

	@Test
	public void criarListaPlataformasComSucessoTest() {
		EstruturaCriarListaPlataformasImpl estruturaCriarListaPlataformasImpl;

		estruturaCriarListaPlataformasImpl = new EstruturaCriarListaPlataformasImpl("10 plataformas", cenarioProcessamento, relatorio);
		assertTrue(relatorio.toString(), estruturaCriarListaPlataformasImpl.isMontadoComSucesso());
		assertEquals(relatorio.toString(), 10, estruturaCriarListaPlataformasImpl.getQuantidadePlatafomas());

		estruturaCriarListaPlataformasImpl = new EstruturaCriarListaPlataformasImpl("3 plataformas", cenarioProcessamento, relatorio);
		assertTrue(relatorio.toString(), estruturaCriarListaPlataformasImpl.isMontadoComSucesso());
		assertEquals(relatorio.toString(), 3, estruturaCriarListaPlataformasImpl.getQuantidadePlatafomas());

		estruturaCriarListaPlataformasImpl = new EstruturaCriarListaPlataformasImpl(" 	7 plataformas", cenarioProcessamento, relatorio);
		assertTrue(relatorio.toString(), estruturaCriarListaPlataformasImpl.isMontadoComSucesso());
		assertEquals(relatorio.toString(), 7, estruturaCriarListaPlataformasImpl.getQuantidadePlatafomas());
	}

	@Test
	public void criarListaPlataformasSemSucessoTest() {
		EstruturaCriarListaPlataformasImpl estruturaCriarListaPlataformasImpl;

		estruturaCriarListaPlataformasImpl = new EstruturaCriarListaPlataformasImpl("x plataformas", cenarioProcessamento, relatorio);
		assertFalse(relatorio.toString(), estruturaCriarListaPlataformasImpl.isMontadoComSucesso());
	}

}
