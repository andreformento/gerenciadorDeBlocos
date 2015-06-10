package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringResultadoInstrucao;

public interface FabricaContextoInterpreterStringResultadoInstrucao extends FabricaContextoInterpreter<String, ResultadoInstrucao> {

	@Override
	public ContextoInterpreterStringResultadoInstrucao criarInstancia();

}
