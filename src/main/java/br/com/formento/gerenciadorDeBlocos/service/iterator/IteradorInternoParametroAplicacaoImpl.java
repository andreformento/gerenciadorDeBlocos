package br.com.formento.gerenciadorDeBlocos.service.iterator;

import java.util.List;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreter;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ParametroAplicacaoInterpreter;

public class IteradorInternoParametroAplicacaoImpl extends IteradorInternoImpl<ParametroAplicacaoInterpreter> implements
		IteradorInternoParametroAplicacao {

	private final ContextoInterpreter<String[], ParametroAplicacao> contextoInterpreter;

	public IteradorInternoParametroAplicacaoImpl(ContextoInterpreterStringParametroAplicacao contextoInterpreter,
			List<ParametroAplicacaoInterpreter> listaPercorrer) {
		super(listaPercorrer);
		this.contextoInterpreter = contextoInterpreter;
	}

	@Override
	protected void operacao(ParametroAplicacaoInterpreter item) {
		item.interpretar(contextoInterpreter);
	}

}
