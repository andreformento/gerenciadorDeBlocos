package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucaoQuantidadeComando;

public class FabricaPadraoInstrucaoQuantidadeComando extends FabricaPadraoInstrucaoImpl {

	public FabricaPadraoInstrucaoQuantidadeComando(String instrucaoEntrada) {
		super(instrucaoEntrada);
	}

	@Override
	public PadraoInstrucao criarInstancia() {
		return new PadraoInstrucaoQuantidadeComando(getInstrucaoEntrada());
	}

}
