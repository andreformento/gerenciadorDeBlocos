package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import java.util.ArrayList;
import java.util.List;

import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.InstrucaoComandoParametroInterpreter;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.InstrucaoInterpreter;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.InstrucaoQuantidadeComandoInterpreter;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoInstrucaoImpl;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class FabricaIteradorInternoInstrucaoImpl implements FabricaIteradorInternoInstrucao {

	private CenarioProcessamento cenarioProcessamento;
	private Relatorio relatorio;
	private ContextoInterpreterStringResultadoInstrucao contextoInterpreter;

	public FabricaIteradorInternoInstrucaoImpl(CenarioProcessamento cenarioProcessamento, Relatorio relatorio,
			ContextoInterpreterStringResultadoInstrucao contextoInterpreter) {
		this.cenarioProcessamento = cenarioProcessamento;
		this.relatorio = relatorio;
		this.contextoInterpreter = contextoInterpreter;
	}

	@Override
	public IteradorInternoInstrucao criarInstancia() {
		List<InstrucaoInterpreter> listaPercorrer = new ArrayList<>();

		/**
		 * A ordem na lista faz diferenca. Verifique o que cada uma das classes realiza de tarefa de validacao. O ideal e colocar as instrucoes mais
		 * frequentes para serem verificadas antes
		 */
		listaPercorrer.add(new InstrucaoComandoParametroInterpreter(cenarioProcessamento, relatorio));
		listaPercorrer.add(new InstrucaoQuantidadeComandoInterpreter(cenarioProcessamento, relatorio));

		IteradorInternoInstrucao instancia = new IteradorInternoInstrucaoImpl(contextoInterpreter, listaPercorrer);

		return instancia;
	}

}
