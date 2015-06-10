package br.com.formento.gerenciadorDeBlocos.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.formento.gerenciadorDeBlocos.business.instrucao.EInstrucao;

public abstract class PadraoInstrucaoImpl implements PadraoInstrucao {

	protected final String instrucaoEntrada;

	private Boolean isInstrucaoValida;
	private String representacaoFabrica;
	private EInstrucao eInstrucao;

	public PadraoInstrucaoImpl(String instrucaoEntrada) {
		this.instrucaoEntrada = instrucaoEntrada;
	}

	protected abstract Pattern getPatternInstrucaoValida();

	protected abstract Pattern getPatternNomeFabrica();

	@Override
	public boolean isEncontrouPadrao() {
		if (isInstrucaoValida == null) {
			Matcher matcher = getPatternInstrucaoValida().matcher(instrucaoEntrada);
			isInstrucaoValida = matcher.find();
		}

		return isInstrucaoValida;
	}

	@Override
	public String getRepresentacaoFabrica() {
		if (representacaoFabrica == null) {
			String representacao;

			if (isEncontrouPadrao()) {
				Matcher matcher = getPatternNomeFabrica().matcher(instrucaoEntrada);

				if (matcher.find())
					representacao = matcher.group();
				else
					representacao = "";
			} else
				representacao = "";

			representacaoFabrica = representacao;
		}

		return representacaoFabrica;
	}

	/**
	 * Utiliza o enum EInstrucao para pegar a instrucao correspondente. Se fosse
	 * permitido utilizar bibliotecas externas, poderia ser utilizada a classe
	 * Relfetions da biblioteca org.reflections para pegar a classe
	 * correspondente de cada instrucao via annotation @InstrucaoAnnotation
	 */
	@Override
	public EInstrucao getEnumInstrucao() {
		if (eInstrucao == null)
			eInstrucao = EInstrucao.getByNomeInstrucao(getRepresentacaoFabrica());

		return eInstrucao;
	}

	@Override
	public String getInstrucaoEntrada() {
		return instrucaoEntrada;
	}

}
