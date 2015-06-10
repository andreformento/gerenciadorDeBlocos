package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucao;

public interface ContextoInterpreterStringResultadoInstrucao extends ContextoInterpreter<String, ResultadoInstrucao> {

	@Override
	String getInput();

	@Override
	ResultadoInstrucao getOutput();

}
