package br.com.formento.gerenciadorDeBlocos.test.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucaoQuantidadeComando;
import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucao;

public class InterpretacaoNumeroInstrucaoTest {

	@Test
	public void instrucoesValidasTest() {
		Map<String, String> instrucoesValidas = new HashMap<>();

		instrucoesValidas.put("6 p", "p");
		instrucoesValidas.put("6 plataformas", "plataformas");
		instrucoesValidas.put(" 6 plataformas de 3 blocos", "plataformas");
		instrucoesValidas.put("20 plataformas", "plataformas");
		instrucoesValidas.put(" 20 plataformas", "plataformas");
		instrucoesValidas.put("20 plataformas ", "plataformas");
		instrucoesValidas.put(" 20 plataformas ", "plataformas");
		instrucoesValidas.put("13 blocos", "blocos");
		instrucoesValidas.put("13 blocos cada   plataforma", "blocos");
		instrucoesValidas.put("13 blocos cada   	plataforma", "blocos");
		instrucoesValidas.put("20 Plataformas", "Plataformas");
		instrucoesValidas.put("20 _Plataformas", "_Plataformas");
		instrucoesValidas.put("20 P_lataformas", "P_lataformas");
		instrucoesValidas.put("20 P_lataformas", "P_lataformas");
		instrucoesValidas.put("20 $Plataformas", "$Plataformas");
		instrucoesValidas.put("20 P$lataformas$", "P$lataformas$");
		instrucoesValidas.put("20 P1", "P1");

		for (Entry<String, String> item : instrucoesValidas.entrySet()) {
			String instrucao = item.getKey();
			String nomeFabrica = item.getValue();

			PadraoInstrucao interpretacaoQuantidadeInstrucao = new PadraoInstrucaoQuantidadeComando(instrucao);
			assertTrue(instrucao, interpretacaoQuantidadeInstrucao.isEncontrouPadrao());

			assertEquals(nomeFabrica, interpretacaoQuantidadeInstrucao.getRepresentacaoFabrica());
		}
	}

	@Test
	public void instrucoesInvalidasTest() {
		List<String> instrucoesInvalidas = new ArrayList<>();
		instrucoesInvalidas.add("");
		instrucoesInvalidas.add(" ");
		instrucoesInvalidas.add("	");
		instrucoesInvalidas.add("20 6Plataformas");
		instrucoesInvalidas.add(" plataformas");
		instrucoesInvalidas.add("x20 plataformas");
		instrucoesInvalidas.add("20 ");
		instrucoesInvalidas.add("20   ");
		instrucoesInvalidas.add("20 2p");
		instrucoesInvalidas.add("mover P2 para P3");
		instrucoesInvalidas.add("mover P4 para P2");
		instrucoesInvalidas.add("mover B3 para P5");

		for (String instrucao : instrucoesInvalidas) {
			PadraoInstrucao interpretacaoQuantidadeInstrucao = new PadraoInstrucaoQuantidadeComando(instrucao);
			assertFalse(instrucao, interpretacaoQuantidadeInstrucao.isEncontrouPadrao());
		}
	}

}
