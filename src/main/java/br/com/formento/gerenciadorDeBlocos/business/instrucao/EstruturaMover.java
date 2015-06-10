package br.com.formento.gerenciadorDeBlocos.business.instrucao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.formento.gerenciadorDeBlocos.model.CenarioProcessamento;
import br.com.formento.gerenciadorDeBlocos.model.EntidadeMovel;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadeBloco;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadeBlocoImpl;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadePlataforma;
import br.com.formento.gerenciadorDeBlocos.model.IdentidadePlataformaImpl;
import br.com.formento.gerenciadorDeBlocos.model.Plataforma;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;

public class EstruturaMover extends EstruturaInstrucaoImpl {

	private static final Pattern PATTERN_ORIGEM = Pattern.compile("^mover [P|B][\\d]+ para", Pattern.MULTILINE);
	private static final Pattern PATTERN_PLATAFORMA_OU_BLOCO = Pattern.compile("[P|B][\\d]+");

	private static final Pattern PATTERN_DESTINO = Pattern.compile("para [P][\\d]+[\t ]*$", Pattern.MULTILINE);
	private static final Pattern PATTERN_PLATAFORMA = Pattern.compile("[P][\\d]+");

	private EntidadeMovel origem;
	private Plataforma destino;

	public EstruturaMover(String instrucaoEntrada, CenarioProcessamento cenarioProcessamento, Relatorio relatorio) {
		super(instrucaoEntrada, cenarioProcessamento, relatorio);
	}

	@Override
	protected boolean montar() {
		boolean isMontagemConcluida = isCenarioPermiteMontarEstrutura();
		if (isMontagemConcluida) {
			isMontagemConcluida = configurarOrigem();
			if (isMontagemConcluida)
				isMontagemConcluida = configurarDestino();
		}

		return isMontagemConcluida;
	}

	private boolean isCenarioPermiteMontarEstrutura() {
		if (getCenarioProcessamento().isEstruturaConfigurada())
			return true;
		else {
			StringBuilder mensagem = new StringBuilder();
			mensagem.append("A instrucao de mover so pode ser executada apos a configuracao das plataformas. Tente colocar \"6 plataformas\" antes da instrucao de mover: ");
			mensagem.append(getInstrucaoEntrada());

			getRelatorio().addConteudo(mensagem);

			return false;
		}
	}

	private boolean configurarOrigem() {
		Matcher matcherOrigem = PATTERN_ORIGEM.matcher(getInstrucaoEntrada());

		if (!matcherOrigem.find()) {
			StringBuilder mensagem = new StringBuilder();
			mensagem.append("O parametro de origem nao foi identificado na instrucao de mover: ");
			mensagem.append(getInstrucaoEntrada());

			getRelatorio().addConteudo(mensagem);
			return false;
		}

		String moverEntidadeMovelPara = matcherOrigem.group();
		Matcher matcherPlataformaOuBloco = PATTERN_PLATAFORMA_OU_BLOCO.matcher(moverEntidadeMovelPara);
		matcherPlataformaOuBloco.find();
		String identidadeStr = matcherPlataformaOuBloco.group();

		EntidadeMovel entidadeMovel;
		/**
		 * Tenta encontrar na lista de plataformas ou blocos
		 */
		if (identidadeStr.startsWith("P")) {
			Integer codigoPlataforma = Integer.valueOf(identidadeStr.substring(1, identidadeStr.length()));
			IdentidadePlataforma identidadePlataforma = new IdentidadePlataformaImpl(codigoPlataforma);
			entidadeMovel = getCenarioProcessamento().getEstruturaDado().getMapaDePlataformas().get(identidadePlataforma);
		} else if (identidadeStr.startsWith("B")) {
			Integer codigoBloco = Integer.valueOf(identidadeStr.substring(1, identidadeStr.length()));
			IdentidadeBloco identidadeBloco = new IdentidadeBlocoImpl(codigoBloco);
			entidadeMovel = getCenarioProcessamento().getEstruturaDado().getMapaDeBlocos().get(identidadeBloco);
		} else {
			StringBuilder mensagem = new StringBuilder();
			mensagem.append("Variavel nao identificada: ");
			mensagem.append(identidadeStr);
			mensagem.append(" - instrucao: ");
			mensagem.append(getInstrucaoEntrada());

			getRelatorio().addConteudo(mensagem);

			return false;
		}

		if (entidadeMovel == null) {
			StringBuilder mensagem = new StringBuilder();
			mensagem.append("O item ");
			mensagem.append(identidadeStr);
			mensagem.append(" de origem nao foi encontrado na lista de plataformas e blocos: ");
			mensagem.append(getInstrucaoEntrada());

			getRelatorio().addConteudo(mensagem);

			return false;
		}
		origem = entidadeMovel;

		return true;
	}

	private boolean configurarDestino() {
		Matcher matcherDestino = PATTERN_DESTINO.matcher(getInstrucaoEntrada());

		if (!matcherDestino.find()) {
			StringBuilder mensagem = new StringBuilder();
			mensagem.append("O parametro de destino nao foi identificado na instrucao de mover: ");
			mensagem.append(getInstrucaoEntrada());

			getRelatorio().addConteudo(mensagem);
			return false;
		}

		String moverEntidadeMovelPara = matcherDestino.group();
		Matcher matcherPlataforma = PATTERN_PLATAFORMA.matcher(moverEntidadeMovelPara);
		matcherPlataforma.find();
		String identidadeStr = matcherPlataforma.group();

		int codigo;
		if (identidadeStr.startsWith("P")) {
			codigo = Integer.valueOf(identidadeStr.substring(1, identidadeStr.length()));

			/**
			 * Tenta encontrar na lista de plataformas
			 */
			IdentidadePlataforma identidadePlataforma = new IdentidadePlataformaImpl(codigo);
			Plataforma plataforma = getCenarioProcessamento().getEstruturaDado().getMapaDePlataformas().get(identidadePlataforma);
			if (plataforma == null) {
				StringBuilder mensagem = new StringBuilder();
				mensagem.append("O item ");
				mensagem.append(identidadeStr);
				mensagem.append(" de destino nao foi encontrado na lista de plataformas: ");
				mensagem.append(getInstrucaoEntrada());

				getRelatorio().addConteudo(mensagem);

				return false;
			} else {
				destino = plataforma;
				return true;
			}
		} else {
			StringBuilder mensagem = new StringBuilder();
			mensagem.append("Instrucao invalida. O destino de um movimento e sempre uma plataforma, nunca um bloco. Item encontrado: ");
			mensagem.append(identidadeStr);
			mensagem.append(" - instrucao: ");
			mensagem.append(getInstrucaoEntrada());

			getRelatorio().addConteudo(mensagem);

			return false;
		}
	}

	public EntidadeMovel getOrigem() {
		return origem;
	}

	public Plataforma getDestino() {
		return destino;
	}

}
