package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucaoComandoParametro;

public class FabricaPadraoInstrucaoComandoParametro extends FabricaPadraoInstrucaoImpl {

	public FabricaPadraoInstrucaoComandoParametro(String instrucaoEntrada) {
		super(instrucaoEntrada);
	}

	@Override
	public PadraoInstrucao criarInstancia() {
		return new PadraoInstrucaoComandoParametro(getInstrucaoEntrada());
	}

}
