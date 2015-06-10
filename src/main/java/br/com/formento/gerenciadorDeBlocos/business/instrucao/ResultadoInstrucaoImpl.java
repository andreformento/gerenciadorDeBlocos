package br.com.formento.gerenciadorDeBlocos.business.instrucao;

import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class ResultadoInstrucaoImpl implements ResultadoInstrucao {

	private Relatorio relatorio;
	private EStatusInstrucao statusInstrucao;

	public ResultadoInstrucaoImpl(Relatorio relatorio, EStatusInstrucao statusInstrucao) {
		this.relatorio = relatorio;
		this.statusInstrucao = statusInstrucao;
	}

	@Override
	public Relatorio getRelatorio() {
		return relatorio;
	}

	@Override
	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	@Override
	public EStatusInstrucao getStatusInstrucao() {
		return statusInstrucao;
	}

	@Override
	public void setStatusInstrucao(EStatusInstrucao statusInstrucao) {
		this.statusInstrucao = statusInstrucao;
	}

}
