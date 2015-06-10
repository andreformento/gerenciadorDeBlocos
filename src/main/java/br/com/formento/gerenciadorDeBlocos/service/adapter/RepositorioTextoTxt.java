package br.com.formento.gerenciadorDeBlocos.service.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import br.com.formento.gerenciadorDeBlocos.model.OperacaoCritica;
import br.com.formento.gerenciadorDeBlocos.model.OperacaoCriticaImpl;
import br.com.formento.gerenciadorDeBlocos.view.Relatorio;
import br.com.formento.gerenciadorDeBlocos.view.RelatorioImpl;

/**
 * Essa eh InterpretacaoNumeroInstrucaoTest classe que le o arquivo no Java 7. No Java 8 pode criar uma outra classe para ler diferente. Foi utilizado
 * o Design Pattern Adapter para trabalhar com File. Pode haver um RepositorioTextoXml
 * 
 * @author andre
 */
public class RepositorioTextoTxt extends RepositorioTextoAdapterImpl {

	private File file;
	private BufferedReader bufferedReader;

	private String current;

	public RepositorioTextoTxt(String nomeArquivo) {
		super(nomeArquivo);
	}

	@Override
	public OperacaoCritica abrir() {
		RelatorioImpl relatorio = new RelatorioImpl();

		file = new File(getParametro());

		boolean isFileExists = file.isFile();

		StringBuilder mensagemArquivoExiste = new StringBuilder();
		mensagemArquivoExiste.append("O arquivo \"");
		mensagemArquivoExiste.append(getParametro());
		mensagemArquivoExiste.append("\" ");

		if (!isFileExists)
			mensagemArquivoExiste.append("nao");

		mensagemArquivoExiste.append("existe");
		relatorio.addConteudo(mensagemArquivoExiste);

		boolean isArquivoLidoCorretamente = false;
		// abrir arquivo
		if (isFileExists) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
				bufferedReader = new BufferedReader(inputStreamReader);

				isArquivoLidoCorretamente = true;

				/**
				 * inicializa a primeira linha
				 */
				current = "";
				next();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				relatorio.addConteudo("Erro ao abrir o arquivo");
				relatorio.addConteudo(e.getMessage());
			}
		}

		boolean isExecutadoComSucesso = isFileExists && isArquivoLidoCorretamente;

		OperacaoCritica operacaoCritica = new OperacaoCriticaImpl(relatorio, isExecutadoComSucesso);

		return operacaoCritica;
	}

	/**
	 * Esse metodo sempre vai pegar InterpretacaoNumeroInstrucaoTest proxima linha valida. A linha eh valida quando nao esta vazia. Se
	 * InterpretacaoNumeroInstrucaoTest linha tiver apenas espacos ela sera desconsideradas. Se chegar ao fim do arquivo vai retornar null
	 */
	@Override
	public void next() {
		if (!isDone()) {
			try {
				current = bufferedReader.readLine();
			} catch (IOException e) {
				current = e.getMessage();
			}

			/**
			 * Pega InterpretacaoNumeroInstrucaoTest proxima linha nao vazia de forma recursiva
			 */
			if (current != null && current.isEmpty())
				next();
		}
	}

	@Override
	public boolean isDone() {
		return current == null;
	}

	@Override
	public OperacaoCritica fechar() {
		String mensagem;
		boolean isExecutadoComSucesso;

		if (bufferedReader == null) {
			mensagem = "O leitor do arquivo nao havia sido inicializado";

			isExecutadoComSucesso = false;
		} else {
			isExecutadoComSucesso = false;
			try {
				bufferedReader.close();

				mensagem = "RepositorioTextoTxt fechado com sucesso";
				isExecutadoComSucesso = true;
			} catch (IOException e) {
				StringBuilder mensagemErro = new StringBuilder();
				mensagemErro.append("Erro ao fechar arquivo: ");
				mensagemErro.append(e.getMessage());

				mensagem = mensagemErro.toString();
			}
		}

		Relatorio relatorio = new RelatorioImpl();
		relatorio.addConteudo(mensagem);

		return new OperacaoCriticaImpl(relatorio, isExecutadoComSucesso);
	}

	@Override
	public String currentItem() {
		return this.current;
	}

	@Override
	public void first() {
		try {
			bufferedReader.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Se o arquivo existir e nao for vazio retornara true
	 */
	@Override
	public boolean isVazio() {
		// The length, in bytes, of the file denoted by this abstract pathname,
		// or 0L if the file does not exist
		return file.length() == 0;
	}

}
