package br.com.formento.gerenciadorDeBlocos.business;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.EInstrucao;

public interface PadraoInstrucao {

	String getInstrucaoEntrada();

	boolean isEncontrouPadrao();

	String getRepresentacaoFabrica();

	EInstrucao getEnumInstrucao();

}
