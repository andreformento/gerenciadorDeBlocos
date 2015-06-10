package br.com.formento.gerenciadorDeBlocos.service.adapter;

public abstract class RepositorioTextoAdapterImpl implements RepositorioTextoAdapter {

	private String parametro;

	public RepositorioTextoAdapterImpl(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String getParametro() {
		return parametro;
	}

}
