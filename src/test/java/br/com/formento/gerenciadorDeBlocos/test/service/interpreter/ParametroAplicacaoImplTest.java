package br.com.formento.gerenciadorDeBlocos.test.service.interpreter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaIteradorInternoParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaIteradorInternoParametroAplicacaoImpl;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacaoImpl;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ParametroAplicacaoInterpreter;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInterno;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoParametroAplicacao;

public class ParametroAplicacaoImplTest {

	@Test
	public void arquivoValidoTest() {
		String[] parametros = { "src/test/resources/inputFiles/6Plataformas_3instrucoes.txt", "semImpressora" };
		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		FabricaIteradorInternoParametroAplicacao fabrica = new FabricaIteradorInternoParametroAplicacaoImpl(contextoInterpreter);

		IteradorInternoParametroAplicacao iteradorInterno = fabrica.criarInstancia();
		iteradorInterno.percorrerLista();

		ParametroAplicacao parametroAplicacao = contextoInterpreter.getOutput();
		assertNotNull(parametroAplicacao);
		assertNotNull(parametroAplicacao.getRelatorio());
		assertTrue(parametroAplicacao.getRelatorio().toString(), parametroAplicacao.isParametroAplicacaoValido());
		assertNotNull(parametroAplicacao.getRepositorioTexto());
		assertFalse(parametroAplicacao.getRepositorioTexto().isVazio());
	}

	@Test
	public void parametroDeArquivoInvalidoTest() {
		String[] parametros = { "src/test/resources/inputFiles/arquivoInvalido.txt" };

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		FabricaIteradorInternoParametroAplicacao fabrica = new FabricaIteradorInternoParametroAplicacaoImpl(contextoInterpreter);
		IteradorInterno<ParametroAplicacaoInterpreter> iteradorInterno = fabrica.criarInstancia();
		iteradorInterno.percorrerLista();

		ParametroAplicacao parametroAplicacao = contextoInterpreter.getOutput();
		assertNotNull(parametroAplicacao);
		assertNotNull(parametroAplicacao.getRelatorio());
		assertTrue(parametroAplicacao.getRelatorio().toString(), parametroAplicacao.isParametroAplicacaoValido());
		assertNotNull(parametroAplicacao.getRepositorioTexto());
		assertFalse(parametroAplicacao.getRepositorioTexto().isVazio());
	}

	@Test
	public void parametroDeArquivoVazioTest() {
		String[] parametros = { "src/test/resources/inputFiles/arquivoVazio.txt" };

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		FabricaIteradorInternoParametroAplicacao fabrica = new FabricaIteradorInternoParametroAplicacaoImpl(contextoInterpreter);
		IteradorInterno<ParametroAplicacaoInterpreter> iteradorInterno = fabrica.criarInstancia();
		iteradorInterno.percorrerLista();

		ParametroAplicacao parametroAplicacao = contextoInterpreter.getOutput();
		assertNotNull(parametroAplicacao);
		assertNotNull(parametroAplicacao.getRelatorio());
		assertFalse(parametroAplicacao.getRelatorio().toString(), parametroAplicacao.isParametroAplicacaoValido());
		assertNotNull(parametroAplicacao.getRepositorioTexto());
		assertTrue(parametroAplicacao.getRepositorioTexto().isVazio());
	}

	@Test
	public void arquivoInexistenteTest() {
		String[] parametros = { "ARQUIVO_INEXISTENTE___.txt" };

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		FabricaIteradorInternoParametroAplicacao fabrica = new FabricaIteradorInternoParametroAplicacaoImpl(contextoInterpreter);
		IteradorInterno<ParametroAplicacaoInterpreter> iteradorInterno = fabrica.criarInstancia();
		iteradorInterno.percorrerLista();

		ParametroAplicacao parametroAplicacao = contextoInterpreter.getOutput();
		assertNotNull(parametroAplicacao);
		assertNotNull(parametroAplicacao.getRelatorio());
		assertFalse(parametroAplicacao.getRelatorio().toString(), parametroAplicacao.isParametroAplicacaoValido());
		assertNotNull(parametroAplicacao.getRepositorioTexto());
		assertTrue(parametroAplicacao.getRepositorioTexto().isVazio());
	}

	@Test
	public void parametroVazioTest() {
		String[] parametros = { "" };

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		FabricaIteradorInternoParametroAplicacao fabrica = new FabricaIteradorInternoParametroAplicacaoImpl(contextoInterpreter);
		IteradorInterno<ParametroAplicacaoInterpreter> iteradorInterno = fabrica.criarInstancia();
		iteradorInterno.percorrerLista();

		ParametroAplicacao parametroAplicacao = contextoInterpreter.getOutput();
		assertNotNull(parametroAplicacao);
		assertNotNull(parametroAplicacao.getRelatorio());
		assertFalse(parametroAplicacao.getRelatorio().toString(), parametroAplicacao.isParametroAplicacaoValido());
		assertNull(parametroAplicacao.getRepositorioTexto());
	}

	@Test
	public void semParametroDeArquivoTest() {
		String[] parametros = {};

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		FabricaIteradorInternoParametroAplicacao fabrica = new FabricaIteradorInternoParametroAplicacaoImpl(contextoInterpreter);
		IteradorInterno<ParametroAplicacaoInterpreter> iteradorInterno = fabrica.criarInstancia();
		iteradorInterno.percorrerLista();

		ParametroAplicacao parametroAplicacao = contextoInterpreter.getOutput();
		assertNotNull(parametroAplicacao);
		assertNotNull(parametroAplicacao.getRelatorio());
		assertFalse(parametroAplicacao.getRelatorio().toString(), parametroAplicacao.isParametroAplicacaoValido());
		assertNull(parametroAplicacao.getRepositorioTexto());
	}

	@Test
	public void inputNullTest() {
		String[] parametros = null;

		ContextoInterpreterStringParametroAplicacao contextoInterpreter = new ContextoInterpreterStringParametroAplicacaoImpl(parametros);

		FabricaIteradorInternoParametroAplicacao fabrica = new FabricaIteradorInternoParametroAplicacaoImpl(contextoInterpreter);
		IteradorInterno<ParametroAplicacaoInterpreter> iteradorInterno = fabrica.criarInstancia();
		iteradorInterno.percorrerLista();

		ParametroAplicacao parametroAplicacao = contextoInterpreter.getOutput();
		assertNotNull(parametroAplicacao);
		assertNotNull(parametroAplicacao.getRelatorio());
		assertFalse(parametroAplicacao.getRelatorio().toString(), parametroAplicacao.isParametroAplicacaoValido());
		assertNull(parametroAplicacao.getRepositorioTexto());
	}

}
