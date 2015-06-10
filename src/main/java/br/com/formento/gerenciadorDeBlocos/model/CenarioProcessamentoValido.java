package br.com.formento.gerenciadorDeBlocos.model;

import br.com.formento.gerenciadorDeBlocos.service.builder.EstruturaDadoBuilder;
import br.com.formento.gerenciadorDeBlocos.service.builder.EstruturaDadoConcretaBuilder;
import br.com.formento.gerenciadorDeBlocos.service.builder.EstruturaDadoDirector;
import br.com.formento.gerenciadorDeBlocos.service.builder.EstruturaDadoDirectorImpl;

public class CenarioProcessamentoValido implements CenarioProcessamento {

	private EstruturaDado estruturaDado;

	public CenarioProcessamentoValido() {

	}

	@Override
	public EstruturaDado getEstruturaDado() {
		return estruturaDado;
	}

	@Override
	public boolean isEstruturaConfigurada() {
		return estruturaDado != null;
	}

	@Override
	public boolean configurarEstruturaDado(int quantidadePlataformas, int quantidadeBlocosPorPlataforma) {
		EstruturaDadoBuilder estruturaDadoBuilder = new EstruturaDadoConcretaBuilder();
		EstruturaDadoDirector estruturaDadoDirector = new EstruturaDadoDirectorImpl(estruturaDadoBuilder, quantidadePlataformas,
				quantidadeBlocosPorPlataforma);

		estruturaDadoDirector.construirInstancia();
		estruturaDado = estruturaDadoDirector.getProduct();
		return isEstruturaConfigurada();
	}

}
