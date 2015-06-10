package br.com.formento.gerenciadorDeBlocos.business.instrucao;

@InstrucaoAnnotation(nomeInstrucao = "plataformas")
public class CriarListaPlataformas extends InstrucaoImpl<EstruturaCriarListaPlataformasImpl> {

	public CriarListaPlataformas(EstruturaCriarListaPlataformasImpl estruturaInstrucao) {
		super(estruturaInstrucao);
	}

	@Override
	public EStatusInstrucao executar() {
		int quantidadePlatafomas = getEstruturaInstrucao().getQuantidadePlatafomas();

		boolean isConfigurado = getEstruturaInstrucao().getCenarioProcessamento().configurarEstruturaDado(quantidadePlatafomas, 1);

		if (isConfigurado)
			return EStatusInstrucao.EXECUTADA_COM_SUCESSO;
		else
			return EStatusInstrucao.ERRO_AO_EXECUTAR;
	}

	public int getQuantidadePlatafomas() {
		return getEstruturaInstrucao().getQuantidadePlatafomas();
	}

}
