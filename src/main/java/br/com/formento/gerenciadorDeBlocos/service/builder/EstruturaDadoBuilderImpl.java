package br.com.formento.gerenciadorDeBlocos.service.builder;

import br.com.formento.gerenciadorDeBlocos.model.EstruturaDado;
import br.com.formento.gerenciadorDeBlocos.model.EstruturaDadoImpl;

public abstract class EstruturaDadoBuilderImpl implements EstruturaDadoBuilder {
	private EstruturaDado product;

	@Override
	public EstruturaDado getProduct() {
		if (product == null)
			product = new EstruturaDadoImpl();

		return product;
	}

}
