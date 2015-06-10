package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.EStatusInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucaoImpl;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class ContextoInterpreterStringResultadoInstrucaoImpl extends ContextoInterpreterImpl<String, ResultadoInstrucao> implements
		ContextoInterpreterStringResultadoInstrucao {

	public ContextoInterpreterStringResultadoInstrucaoImpl(String instrucaoStr, Relatorio relatorio) {
		super(instrucaoStr, new ResultadoInstrucaoImpl(relatorio, EStatusInstrucao.NAO_ENCONTRADA));
	}

}
