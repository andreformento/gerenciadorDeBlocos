package br.com.formento.gerenciadorDeBlocos.service.interpreter;

import br.com.formento.gerenciadorDeBlocos.model.ParametroAplicacao;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaImpressora;
import br.com.formento.gerenciadorDeBlocos.service.factoryMethod.FabricaImpressoraParametro;
import br.com.formento.gerenciadorDeBlocos.service.observer.ImpressoraSubject;

/**
 * Valida se algum parametro depois do primeiro refere-se a quais impressoras devem ser utilizadas. Novas impressoras poderiam ser criadas e definida
 * qual seria criada aqui. Podem ser criadas empressoras de texto, XML, emails, etc
 * 
 * @author andre
 */
public class ParametroAplicacaoImpressora extends ParametroAplicacaoInterpreterImpl {

	@Override
	protected void validar(ContextoInterpreter<String[], ParametroAplicacao> contextoInterpreter) {
		// TODO criar aqui validacao por parametro para criacoes de outras impressoras

		FabricaImpressora fabricaImpressora = new FabricaImpressoraParametro(contextoInterpreter.getInput());
		ImpressoraSubject impressoraSubject = fabricaImpressora.criarInstancia();

		contextoInterpreter.getOutput().setImpressora(impressoraSubject);
	}

}
