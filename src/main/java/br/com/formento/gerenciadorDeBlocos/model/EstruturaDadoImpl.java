package br.com.formento.gerenciadorDeBlocos.model;

import java.util.Map;

public class EstruturaDadoImpl implements EstruturaDado {

	private Map<IdentidadeBloco, Bloco> mapaDeBlocos;
	private Map<IdentidadePlataforma, Plataforma> mapaDePlataformas;

	@Override
	public Map<IdentidadeBloco, Bloco> getMapaDeBlocos() {
		return mapaDeBlocos;
	}

	@Override
	public Map<IdentidadePlataforma, Plataforma> getMapaDePlataformas() {
		return mapaDePlataformas;
	}

	@Override
	public void setMapaDeBlocos(Map<IdentidadeBloco, Bloco> mapaDeBlocos) {
		this.mapaDeBlocos = mapaDeBlocos;
	}

	@Override
	public void setMapaDePlataformas(Map<IdentidadePlataforma, Plataforma> mapaDePlataformas) {
		this.mapaDePlataformas = mapaDePlataformas;
	}

}
