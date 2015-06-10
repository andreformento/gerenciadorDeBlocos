package br.com.formento.gerenciadorDeBlocos.model;

import br.com.formento.gerenciadorDeBlocos.service.adapter.RepositorioTextoAdapter;
import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraSubject;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;
import br.com.formento.gerenciadorDeBlocos.view.RelatorioImpl;

public class ParametroAplicacaoImpl implements ParametroAplicacao {

	private final Relatorio relatorio;

	private RepositorioTextoAdapter repositorioTexto;
	private boolean isParametroAplicacaoValido;
	private ImpressoraSubject impressora;

	public ParametroAplicacaoImpl() {
		this.relatorio = new RelatorioImpl();
	}

	@Override
	public RepositorioTextoAdapter getRepositorioTexto() {
		return repositorioTexto;
	}

	@Override
	public void setRepositorioTexto(RepositorioTextoAdapter repositorioTexto) {
		this.repositorioTexto = repositorioTexto;
	}

	@Override
	public boolean isParametroAplicacaoValido() {
		return isParametroAplicacaoValido;
	}

	@Override
	public void setParametroAplicacaoValido(boolean isParametroAplicacaoValido) {
		this.isParametroAplicacaoValido = isParametroAplicacaoValido;
	}

	@Override
	public Relatorio getRelatorio() {
		return relatorio;
	}

	@Override
	public ImpressoraSubject getImpressora() {
		return impressora;
	}

	@Override
	public void setImpressora(ImpressoraSubject impressora) {
		this.impressora = impressora;
	}

}
