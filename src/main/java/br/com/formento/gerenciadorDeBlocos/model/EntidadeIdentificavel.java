package br.com.formento.gerenciadorDeBlocos.model;

public interface EntidadeIdentificavel {

	/**
	 * @return retorna a identificacao da classe
	 */
	Identidade getIdentidade();

	/**
	 * @return retorna uma String e nao imprime direto para o caso de haver
	 *         multiplos locais para impressao
	 */
	String getImpressao();

}
