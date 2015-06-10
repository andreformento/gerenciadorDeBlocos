package br.com.formento.gerenciadorDeBlocos.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.controller.ProcessamentoController;
import br.com.formento.gerenciadorDeBlocos.model.ResultadoProcessamento;
import br.com.formento.gerenciadorDeBlocos.view.RelatorioImpl;

public class ProcessamentoControllerTest {

	@Test
	public void arquivoVazioTest() {
		String arquivo = "src/test/resources/inputFiles/arquivoVazio.txt";
		String semImpressora = "semImpressora";
		String[] parametros = { arquivo, semImpressora };

		ProcessamentoController processamentoController = new ProcessamentoController(parametros);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();

		assertNotNull(resultadoProcessamento);
		assertNotNull(resultadoProcessamento.getRelatorio());

		RelatorioImpl relatorioFinalAssert = new RelatorioImpl();
		relatorioFinalAssert.addConteudo("O arquivo nao existe ou esta vazio");
		relatorioFinalAssert.addConteudo(arquivo);

		assertEquals(relatorioFinalAssert, resultadoProcessamento.getRelatorio());
	}

	@Test
	public void arquivo6Plataformas_7instrucoesTest() {
		String[] parametros = { "src/test/resources/inputFiles/6Plataformas_7instrucoes.txt", "semImpressora" };

		ProcessamentoController processamentoController = new ProcessamentoController(parametros);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();

		assertNotNull(resultadoProcessamento);
		assertNotNull(resultadoProcessamento.getRelatorio());

		RelatorioImpl relatorioFinalAssert = new RelatorioImpl();
		relatorioFinalAssert.addConteudo("P1: B1");
		relatorioFinalAssert.addConteudo("P2:");
		relatorioFinalAssert.addConteudo("P3: B3 B2");
		relatorioFinalAssert.addConteudo("P4:");
		relatorioFinalAssert.addConteudo("P5:");
		relatorioFinalAssert.addConteudo("P6: B6 B4 B5");

		assertEquals(relatorioFinalAssert, resultadoProcessamento.getRelatorio());
	}

	@Test
	public void arquivo10Plataformas_semInstrucoesTest() {
		String[] parametros = { "src/test/resources/inputFiles/10Plataformas_semInstrucoes.txt", "semImpressora" };

		ProcessamentoController processamentoController = new ProcessamentoController(parametros);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();

		assertNotNull(resultadoProcessamento);
		assertNotNull(resultadoProcessamento.getRelatorio());

		RelatorioImpl relatorioFinalAssert = new RelatorioImpl();

		relatorioFinalAssert.addConteudo("P1: B1");
		relatorioFinalAssert.addConteudo("P2: B2");
		relatorioFinalAssert.addConteudo("P3: B3");
		relatorioFinalAssert.addConteudo("P4: B4");
		relatorioFinalAssert.addConteudo("P5: B5");
		relatorioFinalAssert.addConteudo("P6: B6");
		relatorioFinalAssert.addConteudo("P7: B7");
		relatorioFinalAssert.addConteudo("P8: B8");
		relatorioFinalAssert.addConteudo("P9: B9");
		relatorioFinalAssert.addConteudo("P10: B10");

		assertEquals(relatorioFinalAssert, resultadoProcessamento.getRelatorio());
	}

	@Test
	public void arquivo5Plataformas_4instrucoesTest() {
		String[] parametros = { "src/test/resources/inputFiles/5Plataformas_4instrucoes.txt", "semImpressora" };

		ProcessamentoController processamentoController = new ProcessamentoController(parametros);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();

		assertNotNull(resultadoProcessamento);
		assertNotNull(resultadoProcessamento.getRelatorio());

		RelatorioImpl relatorioFinalAssert = new RelatorioImpl();

		relatorioFinalAssert.addConteudo("P1:");
		relatorioFinalAssert.addConteudo("P2:");
		relatorioFinalAssert.addConteudo("P3:");
		relatorioFinalAssert.addConteudo("P4:");
		relatorioFinalAssert.addConteudo("P5: B5 B3 B1 B2 B4");

		assertEquals(relatorioFinalAssert, resultadoProcessamento.getRelatorio());
	}

	@Test
	public void arquivo5Plataformas_4instrucoes_IITest() {
		String[] parametros = { "src/test/resources/inputFiles/5Plataformas_4instrucoes_II.txt", "semImpressora" };

		ProcessamentoController processamentoController = new ProcessamentoController(parametros);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();

		assertNotNull(resultadoProcessamento);
		assertNotNull(resultadoProcessamento.getRelatorio());

		RelatorioImpl relatorioFinalAssert = new RelatorioImpl();

		relatorioFinalAssert.addConteudo("P1: B1");
		relatorioFinalAssert.addConteudo("P2: B2");
		relatorioFinalAssert.addConteudo("P3: B3");
		relatorioFinalAssert.addConteudo("P4:");
		relatorioFinalAssert.addConteudo("P5: B5 B4");

		assertEquals(relatorioFinalAssert, resultadoProcessamento.getRelatorio());
	}

	@Test
	public void arquivo5Plataformas_instrucao_invalidaTest() {
		String[] parametros = { "src/test/resources/inputFiles/5Plataformas_instrucao_invalida.txt", "semImpressora" };

		ProcessamentoController processamentoController = new ProcessamentoController(parametros);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();

		assertNotNull(resultadoProcessamento);
		assertNotEquals(0, resultadoProcessamento.getCodigoResultado());
		assertNotNull(resultadoProcessamento.getRelatorio());

		RelatorioImpl relatorioFinalAssert = new RelatorioImpl();

		relatorioFinalAssert.addConteudo("O parametro de destino nao foi identificado na instrucao de mover: mover B2 para B3");

		assertEquals(relatorioFinalAssert, resultadoProcessamento.getRelatorio());
	}

	@Test
	public void ordemDeInsercaoDePlataformasTest() {
		String[] parametros = { "src/test/resources/inputFiles/ordemDeInsercaoDePlataformas.txt", "semImpressora" };

		ProcessamentoController processamentoController = new ProcessamentoController(parametros);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();

		assertNotNull(resultadoProcessamento);
		assertNotNull(resultadoProcessamento.getRelatorio());

		RelatorioImpl relatorioFinalAssert = new RelatorioImpl();

		relatorioFinalAssert.addConteudo("P1:");
		relatorioFinalAssert.addConteudo("P2: B2 B1 B3");
		relatorioFinalAssert.addConteudo("P3:");

		assertEquals(relatorioFinalAssert, resultadoProcessamento.getRelatorio());
	}

	@Test
	public void ordemDeInsercaoDeBlocosTest() {
		String[] parametros = { "src/test/resources/inputFiles/ordemDeInsercaoDeBlocos.txt", "semImpressora" };

		ProcessamentoController processamentoController = new ProcessamentoController(parametros);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();

		assertNotNull(resultadoProcessamento);
		assertNotNull(resultadoProcessamento.getRelatorio());

		RelatorioImpl relatorioFinalAssert = new RelatorioImpl();

		relatorioFinalAssert.addConteudo("P1:");
		relatorioFinalAssert.addConteudo("P2: B2");
		relatorioFinalAssert.addConteudo("P3: B3");
		relatorioFinalAssert.addConteudo("P4: B4 B1");
		relatorioFinalAssert.addConteudo("P5: B5");

		assertEquals(relatorioFinalAssert, resultadoProcessamento.getRelatorio());
	}

}
