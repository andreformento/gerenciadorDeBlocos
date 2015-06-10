package br.com.formento.gerenciadorDeBlocos.model;

import br.com.formento.gerenciadorDeBlocos.service.adapter.RepositorioTextoAdapter;
import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraSubject;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public interface ParametroAplicacao {

	void setRepositorioTexto(RepositorioTextoAdapter repositorioTexto);

	RepositorioTextoAdapter getRepositorioTexto();

	void setParametroAplicacaoValido(boolean isParametroAplicacaoValido);

	boolean isParametroAplicacaoValido();

	Relatorio getRelatorio();

	void setImpressora(ImpressoraSubject impressora);

	ImpressoraSubject getImpressora();

}
