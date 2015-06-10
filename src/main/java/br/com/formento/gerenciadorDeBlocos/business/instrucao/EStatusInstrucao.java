package br.com.formento.gerenciadorDeBlocos.business.instrucao;

public enum EStatusInstrucao {
	NAO_ENCONTRADA("nao encontrada", false), INVALIDA("invalida", false), ERRO_AO_EXECUTAR("erro ao executar", false), EXECUTADA_COM_SUCESSO(
			"executada com sucesso", true), EXECUTADA_COM_AVISO("executada com aviso", true);

	private final String descricao;
	private final boolean permiteProcesseguir;

	private EStatusInstrucao(String descricao, boolean permiteProcesseguir) {
		this.descricao = descricao;
		this.permiteProcesseguir = permiteProcesseguir;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isPermiteProcesseguir() {
		return permiteProcesseguir;
	}

}
