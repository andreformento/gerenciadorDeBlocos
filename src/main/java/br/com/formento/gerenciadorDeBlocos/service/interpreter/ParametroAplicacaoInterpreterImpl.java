package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;

/**
 * Quando o parametro de entrada for diferente de um arquivo (um arquivo xml, uma string de conexao de banco), basta criar um validador para cada uma
 * dessas entradas. Atualmente existe o validador ParametroAplicacaoArquivoTexto e quando nao for valido ira gerar o ParametroAplicacaoObrigatorio
 */
public abstract class ParametroAplicacaoInterpreterImpl implements ParametroAplicacaoInterpreter {

	@Override
	public void interpretar(ContextoInterpreter<String[], ParametroAplicacao> contextoInterpreter) {
		validar(contextoInterpreter);
	}

	/**
	 * Esse metodo deve ser sobreescrito para validar um parametro. Por exemplo, a classe ParametroAplicacaoArquivoTexto valida o primeiro parametro
	 * para ver se e um nome de arquivo valido. Poderia tambem validar algum outro parametro atraves de outras classes
	 * 
	 * @param contextoInterpreter
	 */
	protected abstract void validar(ContextoInterpreter<String[], ParametroAplicacao> contextoInterpreter);

}
