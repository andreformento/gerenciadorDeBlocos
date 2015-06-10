package br.com.formento.gerenciadorDeBlocos.business.instrucao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface InstrucaoAnnotation {

	String nomeInstrucao();

}
