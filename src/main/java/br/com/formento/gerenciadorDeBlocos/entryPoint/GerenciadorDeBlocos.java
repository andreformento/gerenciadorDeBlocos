package br.com.formento.gerenciadorDeBlocos.entryPoint;

import br.com.formento.gerenciadorDeBlocos.controller.ProcessamentoController;
import br.com.formento.gerenciadorDeBlocos.model.ResultadoProcessamento;

/**
 * Classe que deve ser chamada ao iniciar aplicacao
 * 
 * @author andre
 */
public class GerenciadorDeBlocos {

	public static void main(String[] args) {
		ProcessamentoController processamentoController = new ProcessamentoController(args);

		ResultadoProcessamento resultadoProcessamento = processamentoController.processar();
		System.exit(resultadoProcessamento.getCodigoResultado());
	}

}
