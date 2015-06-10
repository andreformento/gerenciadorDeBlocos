package br.com.formento.gerenciadorDeBlocos.service.builder;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.model.ResultadoProcessamento;

public interface ResultadoProcessamentoBuilder extends Builder<ResultadoProcessamento> {

	void buildParametroAplicacao(ParametroAplicacao parametroAplicacao);

	void buildResultado();

}
