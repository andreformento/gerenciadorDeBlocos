package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public abstract class InstrucaoInterpreterImpl implements InstrucaoInterpreter {

	private CenarioProcessamento cenarioProcessamento;
	private Relatorio relatorio;

	public InstrucaoInterpreterImpl(CenarioProcessamento cenarioProcessamento, Relatorio relatorio) {
		this.cenarioProcessamento = cenarioProcessamento;
		this.relatorio = relatorio;
	}

	@Override
	public void interpretar(ContextoInterpreter<String, ResultadoInstrucao> contextoInterpreter) {
		validar(contextoInterpreter);
	}

	protected abstract void validar(ContextoInterpreter<String, ResultadoInstrucao> contextoInterpreter);

	public CenarioProcessamento getCenarioProcessamento() {
		return cenarioProcessamento;
	}

	public Relatorio getRelatorio() {
		return relatorio;
	}

}
