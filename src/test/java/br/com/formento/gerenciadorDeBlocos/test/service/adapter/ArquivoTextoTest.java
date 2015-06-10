package br.com.formento.gerenciadorDeBlocos.test.service.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.model.OperacaoCritica;
import br.com.formento.gerenciadorDeBlocos.service.adapter.RepositorioTextoAdapter;
import br.com.formento.gerenciadorDeBlocos.service.adapter.RepositorioTextoTxt;

public class ArquivoTextoTest {

	/**
	 * Testa duas maneiras diferentes de iterar
	 */
	@Test
	public void testarInstrucoesExistente() {
		RepositorioTextoAdapter repositorioTexto = new RepositorioTextoTxt("src/test/resources/inputFiles/6Plataformas_3instrucoes.txt");

		OperacaoCritica operacaoCriticaAbrir = repositorioTexto.abrir();
		try {
			assertTrue(operacaoCriticaAbrir.getRelatorio().toString(), operacaoCriticaAbrir.isExecutadoComSucesso());

			List<String> resultadoEsperado = new ArrayList<>();
			resultadoEsperado.add("6 plataformas");
			resultadoEsperado.add("mover P2 para P3");
			resultadoEsperado.add("mover P4 para P2");
			resultadoEsperado.add("mover B3 para P5");

			int indice = 0;
			for (; !repositorioTexto.isDone(); repositorioTexto.next()) {
				assertTrue(indice < resultadoEsperado.size());
				String resultadoValidar = resultadoEsperado.get(indice);

				String registro = repositorioTexto.currentItem();
				assertEquals(resultadoValidar, registro);
				indice++;
			}
			assertEquals(indice, resultadoEsperado.size());

			assertTrue(repositorioTexto.isDone());
		} finally {
			OperacaoCritica operacaoCriticaFechar = repositorioTexto.fechar();

			assertTrue(operacaoCriticaFechar.getRelatorio().toString(), operacaoCriticaFechar.isExecutadoComSucesso());
		}
	}

	/**
	 * segunda forma de iteracao
	 */
	@Test
	public void testarInstrucoesSegundaFormaDeIteracaoExistente() {
		RepositorioTextoAdapter repositorioTexto = new RepositorioTextoTxt("src/test/resources/inputFiles/6Plataformas_3instrucoes.txt");

		OperacaoCritica operacaoCriticaAbrir = repositorioTexto.abrir();
		try {
			assertTrue(operacaoCriticaAbrir.getRelatorio().toString(), operacaoCriticaAbrir.isExecutadoComSucesso());

			List<String> resultadoEsperado = new ArrayList<>();
			resultadoEsperado.add("6 plataformas");
			resultadoEsperado.add("mover P2 para P3");
			resultadoEsperado.add("mover P4 para P2");
			resultadoEsperado.add("mover B3 para P5");

			for (String resultadoValidar : resultadoEsperado) {
				assertFalse(repositorioTexto.isDone());

				String registro = repositorioTexto.currentItem();
				assertEquals(resultadoValidar, registro);

				repositorioTexto.next();
			}

			assertTrue(repositorioTexto.isDone());
		} finally {
			OperacaoCritica operacaoCriticaFechar = repositorioTexto.fechar();

			assertTrue(operacaoCriticaFechar.getRelatorio().toString(), operacaoCriticaFechar.isExecutadoComSucesso());
		}
	}

}
