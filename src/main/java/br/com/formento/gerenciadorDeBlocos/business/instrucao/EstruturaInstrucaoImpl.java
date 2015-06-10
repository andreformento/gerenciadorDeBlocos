package br.com.formento.gerenciadorDeBlocos.business.instrucao;

import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public abstract class EstruturaInstrucaoImpl implements EstruturaInstrucao {

	private String instrucaoEntrada;
	private CenarioProcessamento cenarioProcessamento;
	private Relatorio relatorio;
	private boolean isMontadoComSucesso;

	public EstruturaInstrucaoImpl(String instrucaoEntrada, CenarioProcessamento cenarioProcessamento, Relatorio relatorio) {
		this.instrucaoEntrada = instrucaoEntrada;
		this.cenarioProcessamento = cenarioProcessamento;
		this.relatorio = relatorio;

		this.isMontadoComSucesso = montar();
	}

	protected abstract boolean montar();

	@Override
	public String getInstrucaoEntrada() {
		return instrucaoEntrada;
	}

	@Override
	public CenarioProcessamento getCenarioProcessamento() {
		return cenarioProcessamento;
	}

	@Override
	public Relatorio getRelatorio() {
		return relatorio;
	}

	@Override
	public boolean isMontadoComSucesso() {
		return isMontadoComSucesso;
	}

}
