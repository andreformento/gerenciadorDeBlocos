package br.com.formento.gerenciadorDeBlocos.business.instrucao;

import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public interface EstruturaInstrucao {

	Relatorio getRelatorio();

	boolean isMontadoComSucesso();

	CenarioProcessamento getCenarioProcessamento();

	String getInstrucaoEntrada();

}
