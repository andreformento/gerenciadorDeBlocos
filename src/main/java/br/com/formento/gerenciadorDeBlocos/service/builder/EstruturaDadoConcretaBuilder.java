package br.com.formento.gerenciadorDeBlocos.service.builder;

import java.util.Map;
import java.util.TreeMap;

import br.com.formento.gerenciadorDeBlocos.model.Bloco;
import br.com.formento.gerenciadorDeBlocos.model.BlocoImpl;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadeBloco;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadeBlocoImpl;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadePlataforma;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadePlataformaImpl;
import br.com.formento.gerenciadorDeBlocos.model.Plataforma;
import br.com.formento.gerenciadorDeBlocos.model.PlataformaImpl;

public class EstruturaDadoConcretaBuilder extends EstruturaDadoBuilderImpl {

	public EstruturaDadoConcretaBuilder() {
	}

	@Override
	public void buildMapaDePlataformas(int quantidadePlataformas) {
		Map<IdentidadePlataforma, Plataforma> mapaDePlataformas = new TreeMap<>();

		for (int i = 0; i < quantidadePlataformas; i++) {
			Plataforma plataforma = new PlataformaImpl(new IdentidadePlataformaImpl(mapaDePlataformas.size() + 1));
			mapaDePlataformas.put(plataforma.getIdentidade(), plataforma);
		}

		getProduct().setMapaDePlataformas(mapaDePlataformas);
	}

	@Override
	public void buildMapaDeBlocos(int quantidadeBlocosPorPlataforma) {
		Map<IdentidadeBloco, Bloco> mapaDeBlocos = new TreeMap<>();

		for (Plataforma plataforma : getProduct().getMapaDePlataformas().values()) {
			for (int i = 0; i < quantidadeBlocosPorPlataforma; i++) {
				Bloco bloco = new BlocoImpl(new IdentidadeBlocoImpl(mapaDeBlocos.size() + 1));
				plataforma.addBloco(bloco);
				bloco.setPlataformaOriginal(plataforma);

				mapaDeBlocos.put(bloco.getIdentidade(), bloco);
			}
		}

		getProduct().setMapaDeBlocos(mapaDeBlocos);
	}

}
