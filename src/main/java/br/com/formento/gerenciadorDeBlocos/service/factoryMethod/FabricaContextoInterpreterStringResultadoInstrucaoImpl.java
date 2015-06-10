package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringResultadoInstrucaoImpl;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

/**
 * @author andre
 */
public class FabricaContextoInterpreterStringResultadoInstrucaoImpl extends FabricaContextoInterpreterImpl<String, ResultadoInstrucao> implements
		FabricaContextoInterpreterStringResultadoInstrucao {

	private String instrucaoStr;
	private Relatorio relatorio;

	public FabricaContextoInterpreterStringResultadoInstrucaoImpl(String instrucaoStr, Relatorio relatorio) {
		this.instrucaoStr = instrucaoStr;
		this.relatorio = relatorio;
	}

	@Override
	public ContextoInterpreterStringResultadoInstrucao criarInstancia() {
		ContextoInterpreterStringResultadoInstrucao contextoInterpreter;
		contextoInterpreter = new ContextoInterpreterStringResultadoInstrucaoImpl(instrucaoStr, relatorio);

		return contextoInterpreter;
	}

}
