package br.com.formento.gerenciadorDeBlocos.model;

import java.util.List;

public class BlocoImpl implements Bloco {

	private IdentidadeBloco identidade;

	private Plataforma plataformaAtual;
	private Plataforma plataformaOriginal;

	public BlocoImpl(IdentidadeBloco identidade) {
		this.identidade = identidade;
	}

	@Override
	public IdentidadeBloco getIdentidade() {
		return identidade;
	}

	@Override
	public String getImpressao() {
		return identidade.toString();
	}

	@Override
	public int compareTo(Bloco o) {
		return getIdentidade().compareTo(o.getIdentidade());
	}

	@Override
	public String toString() {
		return getImpressao();
	}

	@Override
	public Plataforma getPlataformaAtual() {
		return plataformaAtual;
	}

	@Override
	public Plataforma getPlataformaOriginal() {
		return plataformaOriginal;
	}

	@Override
	public void setPlataformaOriginal(Plataforma plataformaOriginal) {
		this.plataformaOriginal = plataformaOriginal;
		this.plataformaAtual = plataformaOriginal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identidade == null) ? 0 : identidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlocoImpl other = (BlocoImpl) obj;
		if (identidade == null) {
			if (other.identidade != null)
				return false;
		} else if (!identidade.equals(other.identidade))
			return false;
		return true;
	}

	/**
	 * Aqui move o bloco para a plataforma de destino. Primeiro deve mover o
	 * bloco para a plataforma destino, depois deve mover os outros blocos da
	 * plataforma de origem para as suas plataformas originais
	 */
	@Override
	public void mover(Plataforma destino) {
		List<Bloco> blocosAcimaDe = plataformaAtual.getBlocosAcimaDe(this);

		for (Bloco bloco : blocosAcimaDe)
			bloco.moverParaPlataformaOriginal();

		somenteMoverParaPlataformDestino(destino);
	}

	/**
	 * Move o bloco para outra plataforma
	 */
	@Override
	public void somenteMoverParaPlataformDestino(Plataforma destino) {
		plataformaAtual.removeBloco(this);
		destino.addBloco(this);
		plataformaAtual = destino;
	}

	/**
	 * Move o bloco para sua plataforma original
	 */
	@Override
	public void moverParaPlataformaOriginal() {
		somenteMoverParaPlataformDestino(plataformaOriginal);
	}

}
