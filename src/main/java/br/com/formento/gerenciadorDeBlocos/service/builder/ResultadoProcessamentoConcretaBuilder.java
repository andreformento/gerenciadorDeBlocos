package br.com.formento.gerenciadorDeBlocos.service.builder;

import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamentoValido;
import br.com.formento.gerenciadorDeBlocos.model.EstruturaDado;
import br.com.formento.gerenciadorDeBlocos.model.OperacaoCritica;
import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.model.Plataforma;
import br.com.formento.gerenciadorDeBlocos.service.adapter.RepositorioTextoAdapter;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaIteradorInternoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaIteradorInternoInstrucaoImpl;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.service.interpreter.ContextoInterpreterStringResultadoInstrucaoImpl;
import br.com.formento.gerenciadorDeBlocos.service.iterator.IteradorInternoInstrucao;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;
import br.com.formento.gerenciadorDeBlocos.view.RelatorioImpl;

public class ResultadoProcessamentoConcretaBuilder extends ResultadoProcessamentoBuilderImpl {

	public ResultadoProcessamentoConcretaBuilder() {
	}

	@Override
	public void buildParametroAplicacao(ParametroAplicacao parametroAplicacao) {
		getProduct().setParametroAplicacao(parametroAplicacao);
	}

	@Override
	public void buildResultado() {
		int codigoResultado;
		Relatorio relatorio;

		if (getProduct().getParametroAplicacao().isParametroAplicacaoValido()) {
			// se os parametros estiverem validos, devem ser executadas as
			// instrucoes
			relatorio = new RelatorioImpl();

			RepositorioTextoAdapter repositorioTexto = getProduct().getParametroAplicacao().getRepositorioTexto();
			OperacaoCritica operacaoCriticaAbrir = repositorioTexto.abrir();
			if (operacaoCriticaAbrir.isExecutadoComSucesso()) {
				try {
					codigoResultado = -1;
					CenarioProcessamento cenarioProcessamento = new CenarioProcessamentoValido();
					for (; !repositorioTexto.isDone(); repositorioTexto.next()) {
						String instrucaoStr = repositorioTexto.currentItem();
						ContextoInterpreterStringResultadoInstrucao contextoInterpreterStringResultadoInstrucao = new ContextoInterpreterStringResultadoInstrucaoImpl(
								instrucaoStr, relatorio);

						FabricaIteradorInternoInstrucao fabricaIteradorInternoInstrucao;
						fabricaIteradorInternoInstrucao = new FabricaIteradorInternoInstrucaoImpl(cenarioProcessamento, relatorio,
								contextoInterpreterStringResultadoInstrucao);
						IteradorInternoInstrucao iteradorInternoInstrucao = fabricaIteradorInternoInstrucao.criarInstancia();

						/**
						 * Valida os parametros informados e configura no contexto gerando a saida (output)
						 */
						iteradorInternoInstrucao.percorrerLista();

						if (!contextoInterpreterStringResultadoInstrucao.getOutput().getStatusInstrucao().isPermiteProcesseguir()) {
							codigoResultado = 4;
							break;
						}
					}

					if (codigoResultado == -1) {
						EstruturaDado estruturaDado = cenarioProcessamento.getEstruturaDado();

						for (Plataforma plataforma : estruturaDado.getMapaDePlataformas().values())
							relatorio.addConteudo(plataforma.getImpressao());

						codigoResultado = 0;
					}
				} finally {
					OperacaoCritica operacaoCriticaFechar = repositorioTexto.fechar();
					if (!operacaoCriticaFechar.isExecutadoComSucesso()) {
						relatorio.addConteudo(operacaoCriticaFechar.getRelatorio().getConteudo());
						codigoResultado = 3;
					}
				}
			} else {
				relatorio.addConteudo(operacaoCriticaAbrir.getRelatorio().getConteudo());
				codigoResultado = 2;
			}

			if (getProduct().getParametroAplicacao().getImpressora() != null)
				getProduct().getParametroAplicacao().getImpressora().setState(relatorio);
		} else {
			relatorio = getProduct().getParametroAplicacao().getRelatorio();
			codigoResultado = 1;
		}

		getProduct().setRelatorio(relatorio);
		getProduct().setCodigoResultado(codigoResultado);
	}
}
