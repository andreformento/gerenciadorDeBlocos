package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucaoQuantidadeComando;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.CriarListaPlataformas;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.EStatusInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.EstruturaCriarListaPlataformasImpl;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class InstrucaoQuantidadeComandoInterpreter extends InstrucaoInterpreterImpl {

	public InstrucaoQuantidadeComandoInterpreter(CenarioProcessamento cenarioProcessamento, Relatorio relatorio) {
		super(cenarioProcessamento, relatorio);
	}

	@Override
	protected void validar(ContextoInterpreter<String, ResultadoInstrucao> contextoInterpreter) {
		/**
		 * Primeira tenta reconhecer o comando em algum padrao de instrucao
		 */
		PadraoInstrucao padraoInstrucao = new PadraoInstrucaoQuantidadeComando(contextoInterpreter.getInput());
		if (padraoInstrucao.isEncontrouPadrao()) {
			String instrucaoEntrada = padraoInstrucao.getInstrucaoEntrada();

			EstruturaCriarListaPlataformasImpl estrutura = new EstruturaCriarListaPlataformasImpl(instrucaoEntrada, getCenarioProcessamento(),
					getRelatorio());
			if (estrutura.isMontadoComSucesso()) {
				CriarListaPlataformas criarListaPlataformas = new CriarListaPlataformas(estrutura);
				criarListaPlataformas.executar();

				contextoInterpreter.getOutput().setStatusInstrucao(EStatusInstrucao.EXECUTADA_COM_SUCESSO);
			} else {
				contextoInterpreter.getOutput().setStatusInstrucao(EStatusInstrucao.INVALIDA);
				contextoInterpreter.getOutput().setRelatorio(estrutura.getRelatorio());
			}
		}
	}
}
