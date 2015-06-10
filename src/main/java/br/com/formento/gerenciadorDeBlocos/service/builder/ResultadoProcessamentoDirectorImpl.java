package br.com.formento.gerenciadorDeBlocos.service.builder;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.model.ResultadoProcessamento;

public class ResultadoProcessamentoDirectorImpl implements ResultadoProcessamentoDirector {
	private ResultadoProcessamentoBuilder builder;
	private ParametroAplicacao parametroAplicacao;

	public ResultadoProcessamentoDirectorImpl(ResultadoProcessamentoBuilder builder, ParametroAplicacao parametroAplicacao) {
		this.builder = builder;
		this.parametroAplicacao = parametroAplicacao;
	}

	@Override
	public void construirInstancia() {
		builder.buildParametroAplicacao(parametroAplicacao);
		builder.buildResultado();
	}

	@Override
	public ResultadoProcessamento getProduct() {
		return builder.getProduct();
	}

}
