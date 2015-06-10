package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

public abstract class FabricaPadraoInstrucaoImpl implements FabricaPadraoInstrucao {

	private String instrucaoEntrada;

	public FabricaPadraoInstrucaoImpl(String instrucaoEntrada) {
		this.instrucaoEntrada = instrucaoEntrada;
	}

	public String getInstrucaoEntrada() {
		return instrucaoEntrada;
	}

}