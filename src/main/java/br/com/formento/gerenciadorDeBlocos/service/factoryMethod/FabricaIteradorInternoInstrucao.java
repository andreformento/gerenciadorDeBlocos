package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.service.interpreter.InstrucaoInterpreter;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoInstrucao;

public interface FabricaIteradorInternoInstrucao extends FabricaIteradorInterno<InstrucaoInterpreter> {

	@Override
	public IteradorInternoInstrucao criarInstancia();

}
