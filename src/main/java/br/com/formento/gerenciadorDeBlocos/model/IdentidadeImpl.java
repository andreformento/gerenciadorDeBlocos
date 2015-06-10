package br.com.formento.gerenciadorDeBlocos.model;

public abstract class IdentidadeImpl implements Identidade, Comparable<Identidade> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Integer codigo;
	private final String descricao;
	private String identificacao;

	public IdentidadeImpl(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		if (identificacao == null) {
			StringBuilder gerarString = new StringBuilder();
			gerarString.append(descricao);
			gerarString.append(codigo);

			identificacao = gerarString.toString();
		}

		return identificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		IdentidadeImpl other = (IdentidadeImpl) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Identidade o) {
		return this.getCodigo().compareTo(o.getCodigo());
	}

}
