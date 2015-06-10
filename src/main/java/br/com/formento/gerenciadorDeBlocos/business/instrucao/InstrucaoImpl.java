package br.com.formento.gerenciadorDeBlocos.business.instrucao;


public abstract class InstrucaoImpl<T extends EstruturaInstrucao> implements Instrucao {

	private final T estruturaInstrucao;  

	public InstrucaoImpl(T estruturaInstrucao) {
		this.estruturaInstrucao = estruturaInstrucao;
	}
	
	@Override
	public T getEstruturaInstrucao() {
		return estruturaInstrucao;
	}

//	@Override
//	public String getInstrucaoEntrada() {
//		return instrucaoEntrada;
//	}
//
//	@Override
//	public void setInstrucaoEntrada(String instrucaoEntrada) {
//		this.instrucaoEntrada = instrucaoEntrada;
//	}
//
//	protected abstract boolean montarEstruturaInterno();
//
//	@Override
//	public final boolean montarEstrutura() {
//		if (isEstruturaValida == null)
//			isEstruturaValida = montarEstruturaInterno();
//
//		return isEstruturaValida;
//	}
//
//	@Override
//	public Relatorio getRelatorio() {
//		return relatorio;
//	}
//
//	public CenarioProcessamento getCenarioProcessamento() {
//		return cenarioProcessamento;
//	}
//
//	public void setCenarioProcessamento(CenarioProcessamento cenarioProcessamento) {
//		this.cenarioProcessamento = cenarioProcessamento;
//	}
//	
//	protected abstract boolean montar(); 
	
	

}
