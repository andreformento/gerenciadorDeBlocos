package br.com.formento.gerenciadorDeBlocos.model;

import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public interface OperacaoCritica {

	boolean isExecutadoComSucesso();

	Relatorio getRelatorio();

}
