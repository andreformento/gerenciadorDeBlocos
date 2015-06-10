package br.com.formento.gerenciadorDeBlocos.controller;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.model.ResultadoProcessamento;
import br.com.formento.gerenciadorDeBlocos.service.builder.ResultadoProcessamentoBuilder;
import br.com.formento.gerenciadorDeBlocos.service.builder.ResultadoProcessamentoConcretaBuilder;
import br.com.formento.gerenciadorDeBlocos.service.builder.ResultadoProcessamentoDirector;
import br.com.formento.gerenciadorDeBlocos.service.builder.ResultadoProcessamentoDirectorImpl;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaContextoInterpreterStringParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaContextoInterpreterStringParametroAplicacaoImpl;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaIteradorInternoParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaIteradorInternoParametroAplicacaoImpl;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoParametroAplicacao;

public class ProcessamentoController {

	private final String[] parametros;

	public ProcessamentoController(String[] parametros) {
		this.parametros = parametros;
	}

	public ResultadoProcessamento processar() {
		/**
		 * Cria instancia com os parametros passados
		 */
		FabricaContextoInterpreterStringParametroAplicacao fabricaContextoInterpreter;
		fabricaContextoInterpreter = new FabricaContextoInterpreterStringParametroAplicacaoImpl(parametros);
		ContextoInterpreterStringParametroAplicacao contextoInterpreter = fabricaContextoInterpreter.criarInstancia();

		/**
		 * Cria a instancia para depois poder iterar e validar os parametros
		 */
		FabricaIteradorInternoParametroAplicacao fabricaIteradorInternoParametroAplicacao;
		fabricaIteradorInternoParametroAplicacao = new FabricaIteradorInternoParametroAplicacaoImpl(contextoInterpreter);
		IteradorInternoParametroAplicacao iteradorInternoParametroAplicacao = fabricaIteradorInternoParametroAplicacao.criarInstancia();

		/**
		 * Valida os parametros informados e configura no contexto gerando a saida (output)
		 */
		iteradorInternoParametroAplicacao.percorrerLista();

		ParametroAplicacao parametroAplicacao = contextoInterpreter.getOutput();

		/**
		 * Caso houve algum problema na geracao dos parametros iniciais, vai imprimir aqui
		 */
		parametroAplicacao.getImpressora().setState(parametroAplicacao.getRelatorio());

		/**
		 * Processa todas as instrucoes
		 */
		ResultadoProcessamentoBuilder resultadoProcessamentoBuilder = new ResultadoProcessamentoConcretaBuilder();
		ResultadoProcessamentoDirector resultadoProcessamentoDirector;
		resultadoProcessamentoDirector = new ResultadoProcessamentoDirectorImpl(resultadoProcessamentoBuilder, parametroAplicacao);

		resultadoProcessamentoDirector.construirInstancia();
		ResultadoProcessamento resultadoProcessamento = resultadoProcessamentoDirector.getProduct();

		/**
		 * Devolve o resultado para o metodo principal
		 */
		return resultadoProcessamento;
	}

}
