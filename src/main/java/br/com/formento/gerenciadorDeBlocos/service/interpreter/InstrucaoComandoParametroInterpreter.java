package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.PadraoInstrucaoComandoParametro;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.EStatusInstrucao;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.EstruturaMover;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.Mover;
import br.com.formento.gerenciadorDeBlocos.business.instrucao.ResultadoInstrucao;
import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class InstrucaoComandoParametroInterpreter extends InstrucaoInterpreterImpl {

	public InstrucaoComandoParametroInterpreter(CenarioProcessamento cenarioProcessamento, Relatorio relatorio) {
		super(cenarioProcessamento, relatorio);
	}

	@Override
	protected void validar(ContextoInterpreter<String, ResultadoInstrucao> contextoInterpreter) {
		/**
		 * Primeira tenta reconhecer o comando em algum padrao de instrucao
		 */
		PadraoInstrucao padraoInstrucao = new PadraoInstrucaoComandoParametro(contextoInterpreter.getInput());
		if (padraoInstrucao.isEncontrouPadrao()) {
			String instrucaoEntrada = padraoInstrucao.getInstrucaoEntrada();

			EstruturaMover estrutura = new EstruturaMover(instrucaoEntrada, getCenarioProcessamento(), getRelatorio());

			if (estrutura.isMontadoComSucesso()) {
				Mover mover = new Mover(estrutura);
				mover.executar();

				contextoInterpreter.getOutput().setStatusInstrucao(EStatusInstrucao.EXECUTADA_COM_SUCESSO);
			} else {
				contextoInterpreter.getOutput().setStatusInstrucao(EStatusInstrucao.INVALIDA);
				contextoInterpreter.getOutput().setRelatorio(estrutura.getRelatorio());
			}
		}
	}
}
