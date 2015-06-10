package br.com.formento.gerenciadorDeBlocos.service.builder;

import br.com.formento.gerenciadorDeBlocos.model.ResultadoProcessamento;
import br.com.formento.gerenciadorDeBlocos.model.ResultadoProcessamentoImpl;

public abstract class ResultadoProcessamentoBuilderImpl implements ResultadoProcessamentoBuilder {

	private ResultadoProcessamento product;

	public ResultadoProcessamentoBuilderImpl() {
	}

	@Override
	public ResultadoProcessamento getProduct() {
		if (product == null)
			product = new ResultadoProcessamentoImpl();

		return product;
	}

}
