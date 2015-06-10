package br.com.formento.gerenciadorDeBlocos.view;

import java.util.ArrayList;
import java.util.List;

public class RelatorioImpl implements Relatorio {
	private final List<String> conteudo;

	public RelatorioImpl() {
		conteudo = new ArrayList<String>();
	}

	public RelatorioImpl(StringBuilder informacao) {
		this();
		addConteudo(informacao);
	}

	public RelatorioImpl(String informacao) {
		this();
		addConteudo(informacao);
	}

	public RelatorioImpl(List<String> listInformacao) {
		this();
		addConteudo(listInformacao);
	}

	@Override
	public List<String> getConteudo() {
		return conteudo;
	}

	@Override
	public boolean addConteudo(String informacao) {
		return conteudo.add(informacao);
	}

	@Override
	public boolean addConteudo(StringBuilder informacao) {
		return conteudo.add(informacao.toString());
	}

	@Override
	public boolean addConteudo(List<String> listInformacao) {
		return conteudo.addAll(listInformacao);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (String informacao : conteudo) {
			stringBuilder.append(informacao);
			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
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
		RelatorioImpl other = (RelatorioImpl) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		return true;
	}

}
