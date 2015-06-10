package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreter;

public interface FabricaContextoInterpreter<INPUT, OUTPUT> extends FabricaFactoryMethod<ContextoInterpreter<INPUT, OUTPUT>> {

	@Override
	ContextoInterpreter<INPUT, OUTPUT> criarInstancia();

}
