package br.com.formento.gerenciadorDeBlocos.model;

import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class OperacaoCriticaImpl implements OperacaoCritica {

	private final Relatorio relatorio;
	private final boolean isExecutadoComSucesso;

	public OperacaoCriticaImpl(Relatorio relatorio, boolean isExecutadoComSucesso) {
		this.relatorio = relatorio;
		this.isExecutadoComSucesso = isExecutadoComSucesso;
	}

	@Override
	public boolean isExecutadoComSucesso() {
		return this.isExecutadoComSucesso;
	}

	@Override
	public Relatorio getRelatorio() {
		return relatorio;
	}

}
