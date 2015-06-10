package br.com.formento.gerenciadorDeBlocos.business.instrucao;

public interface Instrucao {

	EstruturaInstrucao getEstruturaInstrucao();

	EStatusInstrucao executar();

}
