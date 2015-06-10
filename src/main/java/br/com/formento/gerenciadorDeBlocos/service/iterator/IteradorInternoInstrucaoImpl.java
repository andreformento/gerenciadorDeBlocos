package br.com.formento.gerenciadorDeBlocos.service.iterator;

import java.util.List;

import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.InstrucaoInterpreter;

public class IteradorInternoInstrucaoImpl extends IteradorInternoImpl<InstrucaoInterpreter> implements IteradorInternoInstrucao {

	private final ContextoInterpreterStringResultadoInstrucao contextoInterpreter;

	public IteradorInternoInstrucaoImpl(ContextoInterpreterStringResultadoInstrucao contextoInterpreter, List<InstrucaoInterpreter> listaPercorrer) {
		super(listaPercorrer);
		this.contextoInterpreter = contextoInterpreter;
	}

	@Override
	protected void operacao(InstrucaoInterpreter item) {
		item.interpretar(contextoInterpreter);
	}

}
