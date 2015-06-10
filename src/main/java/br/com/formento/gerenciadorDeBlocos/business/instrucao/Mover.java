package br.com.formento.gerenciadorDeBlocos.business.instrucao;

@InstrucaoAnnotation(nomeInstrucao = "mover")
public class Mover extends InstrucaoImpl<EstruturaMover> {

	public Mover(EstruturaMover estruturaInstrucao) {
		super(estruturaInstrucao);
	}

	@Override
	public EStatusInstrucao executar() {
		getEstruturaInstrucao().getOrigem().mover(getEstruturaInstrucao().getDestino());

		return EStatusInstrucao.EXECUTADA_COM_SUCESSO;
	}
}
