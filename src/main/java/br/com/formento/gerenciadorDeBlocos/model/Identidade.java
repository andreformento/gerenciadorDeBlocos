package br.com.formento.gerenciadorDeBlocos.model;

import java.io.Serializable;

public interface Identidade extends Serializable {

	Integer getCodigo();

	String getDescricao();
	
	int compareTo(Identidade o);

}
