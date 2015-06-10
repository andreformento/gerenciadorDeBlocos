package br.com.formento.gerenciadorDeBlocos.business.instrucao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class EstruturaCriarListaPlataformasImpl extends EstruturaInstrucaoImpl {
	private static final Pattern PATTERN_QUANTIDADE = Pattern.compile("[\\d]+");

	private int quantidadePlatafomas;

	public EstruturaCriarListaPlataformasImpl(String instrucaoEntrada, CenarioProcessamento cenarioProcessamento, Relatorio relatorio) {
		super(instrucaoEntrada, cenarioProcessamento, relatorio);
	}

	@Override
	protected boolean montar() {
		Matcher matcher = PATTERN_QUANTIDADE.matcher(getInstrucaoEntrada());

		if (matcher.find()) {
			quantidadePlatafomas = Integer.valueOf(matcher.group());
			return true;
		} else {
			getRelatorio()
					.addConteudo(
							"O parametro de quantidade nao foi identificado para criacao das plataformas. Tente algo como \"6 plataformas\". Erro no seguinte comando:");
			getRelatorio().addConteudo(getInstrucaoEntrada());
			return false;
		}
	}

	public int getQuantidadePlatafomas() {
		return quantidadePlatafomas;
	}

}
