package br.com.formento.gerenciadorDeBlocos.model;

import java.util.List;

public interface Plataforma extends EntidadeIdentificavel, EntidadeMovel, Comparable<Plataforma> {

	@Override
	public IdentidadePlataforma getIdentidade();

	boolean addBloco(Bloco bloco);

	boolean removeBloco(Bloco bloco);

	List<Bloco> getBlocosAcimaDe(Bloco acimaDe);

}
