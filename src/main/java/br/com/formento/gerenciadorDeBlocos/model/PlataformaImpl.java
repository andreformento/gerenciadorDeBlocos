package br.com.formento.gerenciadorDeBlocos.model;

import java.util.ArrayList;
import java.util.List;

public class PlataformaImpl implements Plataforma {

	private List<Bloco> blocos;
	private IdentidadePlataforma identidade;

	public PlataformaImpl(IdentidadePlataforma identidade) {
		this.identidade = identidade;
		this.blocos = new ArrayList<>();
	}

	@Override
	public boolean addBloco(Bloco bloco) {
		return blocos.add(bloco);
	}

	@Override
	public boolean removeBloco(Bloco blocoRemover) {
		return blocos.remove(blocoRemover);
	}

	@Override
	public IdentidadePlataforma getIdentidade() {
		return identidade;
	}

	@Override
	public String getImpressao() {
		StringBuilder montar = new StringBuilder();

		montar.append(getIdentidade().toString());
		montar.append(":");
		for (Bloco bloco : blocos) {
			montar.append(" ");
			montar.append(bloco.getIdentidade().toString());
		}

		return montar.toString();
	}

	@Override
	public int compareTo(Plataforma o) {
		return getIdentidade().compareTo(o.getIdentidade());
	}

	@Override
	public String toString() {
		return getImpressao();
	}

	/**
	 * Aqui eh onde de fato move os blocos para outra plataforma
	 */
	@Override
	public void mover(Plataforma destino) {
		while (!blocos.isEmpty())
			blocos.get(blocos.size() - 1).somenteMoverParaPlataformDestino(destino);
	}

	/**
	 * Encontrar os blocos que estao acima do bloco acimaDe
	 */
	@Override
	public List<Bloco> getBlocosAcimaDe(Bloco acimaDe) {
		List<Bloco> blocosAcimaDe = new ArrayList<>();

		boolean encontrou = false;
		for (Bloco bloco : blocos) {
			if (!encontrou)
				encontrou = bloco.equals(acimaDe);
			else
				blocosAcimaDe.add(bloco);
		}

		return blocosAcimaDe;
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
		PlataformaImpl other = (PlataformaImpl) obj;
		if (identidade == null) {
			if (other.identidade != null)
				return false;
		} else if (!identidade.equals(other.identidade))
			return false;
		return true;
	}

}
