package br.com.formento.gerenciadorDeBlocos.service.builder;

import br.com.formento.gerenciadorDeBlocos.model.EstruturaDado;

public interface EstruturaDadoBuilder extends Builder<EstruturaDado> {

	void buildMapaDePlataformas(int quantidadePlataformas);

	void buildMapaDeBlocos(int quantidadeBlocosPorPlataforma);

}
