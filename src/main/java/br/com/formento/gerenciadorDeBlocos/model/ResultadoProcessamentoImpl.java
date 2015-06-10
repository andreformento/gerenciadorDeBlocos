package br.com.formento.gerenciadorDeBlocos.model;

import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class ResultadoProcessamentoImpl implements ResultadoProcessamento {

	private ParametroAplicacao parametroAplicacao;
	private int codigoResultado;
	private Relatorio relatorio;

	public ResultadoProcessamentoImpl() {
	}

	@Override
	public int getCodigoResultado() {
		return codigoResultado;
	}

	@Override
	public void setCodigoResultado(int codigoResultado) {
		this.codigoResultado = codigoResultado;
	}

	@Override
	public Relatorio getRelatorio() {
		return relatorio;
	}

	@Override
	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	@Override
	public ParametroAplicacao getParametroAplicacao() {
		return parametroAplicacao;
	}

	@Override
	public void setParametroAplicacao(ParametroAplicacao parametroAplicacao) {
		this.parametroAplicacao = parametroAplicacao;
	}

}
