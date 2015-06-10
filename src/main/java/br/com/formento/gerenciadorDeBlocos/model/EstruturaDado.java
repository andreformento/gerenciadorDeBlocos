package br.com.formento.gerenciadorDeBlocos.model;

import java.util.Map;

public interface EstruturaDado {

	Map<IdentidadeBloco, Bloco> getMapaDeBlocos();

	void setMapaDeBlocos(Map<IdentidadeBloco, Bloco> mapaDeBlocos);

	Map<IdentidadePlataforma, Plataforma> getMapaDePlataformas();

	void setMapaDePlataformas(Map<IdentidadePlataforma, Plataforma> mapaDePlataformas);

}
