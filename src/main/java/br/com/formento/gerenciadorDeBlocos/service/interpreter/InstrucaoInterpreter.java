package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucao;

public interface InstrucaoInterpreter extends Interpreter<String, ResultadoInstrucao> {

	@Override
	void interpretar(ContextoInterpreter<String, ResultadoInstrucao> contextoInterpreter);

}
