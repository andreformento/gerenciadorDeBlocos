package br.com.formento.gerenciadorDeBlocos.business.instrucao;

public enum EInstrucao {
	MOVER("mover", Mover.class), CRIAR_LISTA_PLATAFORMAS("plataformas", CriarListaPlataformas.class);

	private final String nomeInstrucao;
	private final Class<? extends Instrucao> classeInstrucao;

	private EInstrucao(String nomeInstrucao, Class<? extends Instrucao> classeInstrucao) {
		this.nomeInstrucao = nomeInstrucao;
		this.classeInstrucao = classeInstrucao;
	}

	public String getNomeInstrucao() {
		return nomeInstrucao;
	}

	public Class<? extends Instrucao> getClasseInstrucao() {
		return classeInstrucao;
	}

	public static EInstrucao getByNomeInstrucao(String nomeInstrucaoPesquisa) {
		for (EInstrucao eInstrucao : values())
			if (eInstrucao.getNomeInstrucao().compareTo(nomeInstrucaoPesquisa) == 0)
				return eInstrucao;

		return null;
	}

}
