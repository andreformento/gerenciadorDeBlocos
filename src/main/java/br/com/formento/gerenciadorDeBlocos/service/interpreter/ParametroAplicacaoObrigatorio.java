package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.model.OperacaoCritica;
import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.adapter.RepositorioAdapter;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

/**
 * Essa classe valida se os parametros obrigatorios foram preenchidos. Por enquanto somente o Repositorio e obrigatorio para preenchimento, que e o
 * primeiro parametro, que tem que ter o nome do arquivo. Aqui so valida se o atributo foi preenchido - ele e preenchido na classe
 * ParametroAplicacaoArquivoTexto
 * 
 * @author andre
 */
public class ParametroAplicacaoObrigatorio extends ParametroAplicacaoInterpreterImpl {

	@Override
	protected void validar(ContextoInterpreter<String[], ParametroAplicacao> contextoInterpreter) {
		Relatorio relatorio = contextoInterpreter.getOutput().getRelatorio();
		boolean isParametroAplicacaoValido = false;

		if (contextoInterpreter.getOutput().getImpressora() == null) {
			relatorio.addConteudo("A impressora nao foi criada");
		} else {
			/**
			 * Valida se o repositorio esta disponivel para leitura. Esse e um parametro obrigatorio
			 */
			RepositorioAdapter<?> repositorioTexto = contextoInterpreter.getOutput().getRepositorioTexto();

			if (repositorioTexto == null) {
				relatorio.addConteudo("O repositorio nao foi identificado");
			} else {
				repositorioTexto.getParametro();
				OperacaoCritica operacaoCriticaAbrir = repositorioTexto.abrir();
				if (operacaoCriticaAbrir.isExecutadoComSucesso()) {
					if (repositorioTexto.isVazio()) {
						relatorio.addConteudo("O arquivo nao existe ou esta vazio");
						relatorio.addConteudo(repositorioTexto.getParametro());
					} else
						isParametroAplicacaoValido = true;
				} else {
					relatorio.addConteudo("nao foi possivel abrir o repositorio");
					relatorio.addConteudo(repositorioTexto.getParametro());
				}
			}
		}

		contextoInterpreter.getOutput().setParametroAplicacaoValido(isParametroAplicacaoValido);
	}
}
