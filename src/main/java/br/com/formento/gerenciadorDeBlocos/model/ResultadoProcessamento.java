package br.com.formento.gerenciadorDeBlocos.model;

import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public interface ResultadoProcessamento {

	void setParametroAplicacao(ParametroAplicacao parametroAplicacao);

	ParametroAplicacao getParametroAplicacao();

	void setCodigoResultado(int codigoResultado);

	int getCodigoResultado();

	void setRelatorio(Relatorio relatorio);

	Relatorio getRelatorio();

}
