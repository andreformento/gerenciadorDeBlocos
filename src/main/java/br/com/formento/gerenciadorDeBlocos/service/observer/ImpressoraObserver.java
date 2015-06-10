package br.com.formento.gerenciadorDeBlocos.service.observer;

/**
 * Permite gerar varias impressoras. Podem haver impressoras que gravam em arquivo, gravam em banco de dados, imprimem somente no final (cache), criam
 * emails e enviam no final, etc
 * 
 * @author andre
 */
public interface ImpressoraObserver {

	void update();

}