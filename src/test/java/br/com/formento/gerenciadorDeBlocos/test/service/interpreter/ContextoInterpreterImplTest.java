package br.com.formento.gerenciadorDeBlocos.test.service.interpreter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacaoImpl;

public class ContextoInterpreterImplTest {

	@Test
	public void arquivoValidoTest() {
		String[] parametros = { "src/test/resources/inputFiles/6Plataformas_3instrucoes.txt" };
		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		assertNotNull(contextoInterpreter.getInput());
		assertNotNull(contextoInterpreter.getOutput());
	}

	@Test
	public void parametroDeArquivoInvalidoTest() {
		String[] parametros = { "src/test/resources/inputFiles/arquivoInvalido.txt" };

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		assertNotNull(contextoInterpreter.getInput());
		assertNotNull(contextoInterpreter.getOutput());
	}

	@Test
	public void parametroDeArquivoVazioTest() {
		String[] parametros = { "src/test/resources/inputFiles/arquivoVazio.txt" };

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		assertNotNull(contextoInterpreter.getInput());
		assertNotNull(contextoInterpreter.getOutput());
	}

	@Test
	public void arquivoInexistenteTest() {
		String[] parametros = { "ARQUIVO_INEXISTENTE___.txt" };

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		assertNotNull(contextoInterpreter.getInput());
		assertNotNull(contextoInterpreter.getOutput());
	}

	@Test
	public void parametroVazioTest() {
		String[] parametros = { "" };

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		assertNotNull(contextoInterpreter.getInput());
		assertNotNull(contextoInterpreter.getOutput());
		assertNull(contextoInterpreter.getOutput().getRepositorioTexto());
	}

	@Test
	public void semParametroDeArquivoTest() {
		String[] parametros = {};

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		assertNotNull(contextoInterpreter.getInput());
		assertNotNull(contextoInterpreter.getOutput());
		assertNull(contextoInterpreter.getOutput().getRepositorioTexto());
	}

	@Test
	public void inputNullTest() {
		String[] parametros = null;

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		assertNull(contextoInterpreter.getInput());
		assertNotNull(contextoInterpreter.getOutput());
		assertNull(contextoInterpreter.getOutput().getRepositorioTexto());
	}

}
