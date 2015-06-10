package br.com.formento.gerenciadorDeBlocos.business.instrucao;

import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public interface ResultadoInstrucao {

	void setRelatorio(Relatorio relatorio);

	Relatorio getRelatorio();

	EStatusInstrucao getStatusInstrucao();

	void setStatusInstrucao(EStatusInstrucao statusInstrucao);

}
