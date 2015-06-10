package br.com.formento.gerenciadorDeBlocos.view;

import java.util.List;

public interface Relatorio {

	boolean addConteudo(String informacao);

	boolean addConteudo(StringBuilder informacao);

	boolean addConteudo(List<String> listInformacao);

	List<String> getConteudo();

}
