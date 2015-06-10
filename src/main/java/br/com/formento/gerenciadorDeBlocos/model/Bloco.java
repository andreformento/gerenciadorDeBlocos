package br.com.formento.gerenciadorDeBlocos.model;

public interface Bloco extends EntidadeIdentificavel, EntidadeMovel, Comparable<Bloco> {

	@Override
	IdentidadeBloco getIdentidade();

	Plataforma getPlataformaAtual();

	void setPlataformaOriginal(Plataforma plataformaOriginal);

	Plataforma getPlataformaOriginal();

	void moverParaPlataformaOriginal();

	void somenteMoverParaPlataformDestino(Plataforma destino);

}
