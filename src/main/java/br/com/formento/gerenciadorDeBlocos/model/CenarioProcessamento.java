package br.com.formento.gerenciadorDeBlocos.model;

public interface CenarioProcessamento {

	EstruturaDado getEstruturaDado();

	boolean configurarEstruturaDado(int quantidadePlataformas, int quantidadeBlocosPorPlataforma);

	boolean isEstruturaConfigurada();

}
