package br.com.formento.gerenciadorDeBlocos.service.factoryMethod;

import java.util.ArrayList;
import java.util.List;

import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ParametroAplicacaoArquivoTexto;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ParametroAplicacaoImpressora;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ParametroAplicacaoInterpreter;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ParametroAplicacaoObrigatorio;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoParametroAplicacaoImpl;

public class FabricaIteradorInternoParametroAplicacaoImpl implements FabricaIteradorInternoParametroAplicacao {

	private final ContextoInterpreterStringParametroAplicacao contextoInterpreter;

	public FabricaIteradorInternoParametroAplicacaoImpl(ContextoInterpreterStringParametroAplicacao contextoInterpreter) {
		this.contextoInterpreter = contextoInterpreter;
	}

	@Override
	public IteradorInternoParametroAplicacao criarInstancia() {
		List<ParametroAplicacaoInterpreter> listaPercorrer = new ArrayList<>();

		/**
		 * A ordem na lista faz diferenca. Verifique o que cada uma das classes
		 * realiza de tarefa de validacao
		 */
		listaPercorrer.add(new ParametroAplicacaoArquivoTexto());
		listaPercorrer.add(new ParametroAplicacaoImpressora());
		listaPercorrer.add(new ParametroAplicacaoObrigatorio());

		IteradorInternoParametroAplicacao instancia = new IteradorInternoParametroAplicacaoImpl(contextoInterpreter, listaPercorrer);

		return instancia;
	}

}
