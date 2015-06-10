package br.com.formento.gerenciadorDeBlocos.service.builder;

import br.com.formento.gerenciadorDeBlocos.model.EstruturaDado;

public class EstruturaDadoDirectorImpl implements EstruturaDadoDirector {
	private EstruturaDadoBuilder builder;

	private int quantidadePlataformas;
	private int quantidadeBlocosPorPlataforma;

	public EstruturaDadoDirectorImpl(EstruturaDadoBuilder builder, int quantidadePlataformas, int quantidadeBlocosPorPlataforma) {
		this.builder = builder;
		this.quantidadePlataformas = quantidadePlataformas;
		this.quantidadeBlocosPorPlataforma = quantidadeBlocosPorPlataforma;
	}

	@Override
	public void construirInstancia() {
		builder.buildMapaDePlataformas(quantidadePlataformas);
		builder.buildMapaDeBlocos(quantidadeBlocosPorPlataforma);
	}

	@Override
	public EstruturaDado getProduct() {
		return builder.getProduct();
	}

}
