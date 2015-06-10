package br.com.formento.gerenciadorDeBlocos.test.service.factoryMethod;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.EInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaPadraoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaPadraoInstrucaoComandoParametro;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaPadraoInstrucaoQuantidadeComando;

public class FabricaPadraoInstrucaoTest {

	@Test
	public void classeCriadaTest() {
		FabricaPadraoInstrucao fabrica;
		PadraoInstrucao padraoInstrucao;

		fabrica = new FabricaPadraoInstrucaoComandoParametro("mover P2 para P3");
		padraoInstrucao = fabrica.criarInstancia();
		assertEquals(EInstrucao.MOVER, padraoInstrucao.getEnumInstrucao());

		fabrica = new FabricaPadraoInstrucaoQuantidadeComando("6 plataformas");
		padraoInstrucao = fabrica.criarInstancia();
		assertEquals(EInstrucao.CRIAR_LISTA_PLATAFORMAS, padraoInstrucao.getEnumInstrucao());
	}

}
