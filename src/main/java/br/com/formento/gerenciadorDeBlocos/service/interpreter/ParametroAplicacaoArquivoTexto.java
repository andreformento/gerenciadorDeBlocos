package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.adapter.RepositorioTextoAdapter;
import br.com.formento.gerenciadorDeBlocos.service.adapter.RepositorioTextoTxt;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

/**
 * Valida se o primeiro parametro existe e se tem alguma coisa nele. Com isso, cria o repositorio de arquivo texto com o parametro. O dia que for
 * necessario criar um repositorio para outro tipo de arquivo, essa classe tera que validar tambem a extensao (.txt)
 * 
 * @author andre
 */
public class ParametroAplicacaoArquivoTexto extends ParametroAplicacaoInterpreterImpl {

	@Override
	protected void validar(ContextoInterpreter<String[], ParametroAplicacao> contextoInterpreter) {
		String[] input = contextoInterpreter.getInput();

		Relatorio relatorio = contextoInterpreter.getOutput().getRelatorio();
		if (input == null) {
			relatorio.addConteudo("O parametro de entrada esta nulo");
		} else if (input.length == 0) {
			relatorio.addConteudo("Nenhum parametro foi identificado. Tente colocar algo como 'java -jar gerenciadorDeBlocos.jar input.txt'");
		} else {
			String parameroNomeArquivo = input[0];

			if (parameroNomeArquivo.isEmpty()) {
				relatorio.addConteudo("O primeiro parametro que e a localizacao do repositorio esta vazio");
				relatorio.addConteudo("Tente colocar algo como 'java -jar gerenciadorDeBlocos.jar input.txt'");
			} else {
				RepositorioTextoAdapter repositorioTexto = new RepositorioTextoTxt(parameroNomeArquivo);
				contextoInterpreter.getOutput().setRepositorioTexto(repositorioTexto);
			}
		}

	}
}
