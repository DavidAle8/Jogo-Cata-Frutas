package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe responsável pela leitura de um arquivo de texto.
 */

public class LeituraEscritaArquivo{
	
	/**
	 * Caminho do arquivo
	 */
	private String arquivo;
//	private InterfaceWB InterfaceWB;
	
	/**
	 * Construtor que inicializa a classe com o caminho do arquivo.
	 * 
	 * @param arquivo O caminho do arquivo a ser lido.
	 */
	
	public LeituraEscritaArquivo (String arquivo) {
		
		this.arquivo = arquivo;
	//	this.InterfaceWB = InterfaceWB;
	}
		
	/**
	 * Lê o conteúdo do arquivo e imprime cada linha no console.
	 * Caso ocorra um erro durante a leitura, uma mensagem de erro será exibida.
	 */
	
	public void lerArquivo() {

		String caminhoArquivo = arquivo;
		BufferedReader leitor = null;
		
		try {
			
			FileReader localArq = new FileReader(caminhoArquivo);
			leitor = new BufferedReader(localArq);
			
			String linha = leitor.readLine();
			
			while(linha != null) {
				
				System.out.println(linha);
				linha = leitor.readLine();
				
			}	
			
		} catch(IOException erro){
			
			System.out.println("Erro ao ler o arquivo!! \n\n");
			System.out.println(erro.getMessage());
			
		}	
	}
	
/*	public void escreverArquivo() {
		
		String caminhoArquivo = arquivo;
		
		String nomeJogador1 = inputJogador1.getText();
		String nomeJogador2 = inputJogador2.getText();
		int capacidadeMochila = Integer.parseInt(inputMochila.getText());
		
		int tamanhoCenario = Integer.parseInt(inputTamanhoCenario.getText());
		int quantidadePedra = Integer.parseInt(inputQuantidadePedras.getText());
		
		int probabilidadeBichada = Integer.parseInt(inputBichada.getText());
		
		int qtdArvoreLaranja = Integer.parseInt(inputQtdArvoreLaranja.getText());
		int qtdLaranjaNoChao = Integer.parseInt(inputQtdLaranjaNoChao.getText());
		
		int qtdArvoreAbacate = Integer.parseInt(inputQtdArvoreAbacate.getText());
		int qtdAbacateNoChao = Integer.parseInt(inputQtdAbacateNoChao.getText());
		
		int qtdArvoreCoco = Integer.parseInt(inputQtdArvoreCoco.getText());
		int qtdCocoNoChao = Integer.parseInt(inputQtdCocoNoChao.getText());
		
		int qtdArvoreAcerola = Integer.parseInt(inputQtdArvoreAcerola.getText());
		int qtdAcerolaNoChao = Integer.parseInt(inputQtdAcerolaNoChao.getText());
		
		int qtdArvoreAmora = Integer.parseInt(inputQtdArvoreAmora.getText());
		int qtdAmoraNoChao = Integer.parseInt(inputQtdAmoraNoChao.getText());
		
		int qtdArvoreGoiaba = Integer.parseInt(inputQtdArvoreGoiaba.getText());
		int qtdGoiabaNoChao = Integer.parseInt(inputQtdGoiabaNoChao.getText());
		
		int qtdMaracujaEmArvore = Integer.parseInt(inputQtdMaracujaArvore.getText());
		int qtdMaracujaNoChao = Integer.parseInt(inputMaracujaNoChao.getText());
		
		try(BufferedWriter escritor = new BufferedWriter( new FileWriter(caminhoArquivo))) {
    		
    		escritor.write(String.format("Nome do jogador 1: %s \n", inputJogador1.getText()));
    		
    		escritor.write("\n");
    		
    		escritor.write(String.format("Nome do jogador 2: %s \n", nomeJogador2));
    		
    		escritor.write("\n");
    		
    		escritor.write(String.format("Capacidade da mochila: %d \n", capacidadeMochila));
    		
    		escritor.write(" \n");
    		
    		escritor.write(String.format("Tamanho do cenário: " + tamanhoCenario + "\n"));
    		
    		escritor.write("\n");
    		
    		escritor.write(String.format("Quantidade de pedra: \n" + quantidadePedra + "\n"));
    		
    		escritor.write("\n");
    		
    		escritor.write(String.format("Probabilidade de fruta bixada: %d \n", probabilidadeBichada));
    		
    		escritor.write(" \n");
    		
    		escritor.write(String.format("Quantidade de arvores de laranja: %d\n", qtdArvoreLaranja));
    		escritor.write(String.format("Quantidade de laranjas no chão: %d \n", qtdLaranjaNoChao));
    		
    		escritor.write("\n");
    		
    		escritor.write(String.format("Quantidade de arvores de abacate: %d \n", qtdArvoreAbacate));
    		escritor.write(String.format("Quantidade de abacates no chão:  %d \n",qtdAbacateNoChao));
    		
    		escritor.write("\n");
    		
    		escritor.write(String.format("Quantidade de arvores de coco: %d \n", qtdArvoreCoco));
    		escritor.write(String.format("Quantidade de cocos no chão:  %d \n", qtdCocoNoChao));
    		
    		escritor.write("\n");
    		
    		escritor.write(String.format("Quantidade de arvores de acerola: %d \n", qtdArvoreAcerola));
    		escritor.write(String.format("Quantidade de acerolas no chão: %d \n", qtdAcerolaNoChao));
    		
    		escritor.write("\n");
    		
    		escritor.write(String.format("Quantidade de arvores de amora: %d \n", qtdArvoreAmora));
    		escritor.write(String.format("Quantidade de amoras no chão:  %d \n", qtdAmoraNoChao));

    		escritor.write(" \n");
    		
    		escritor.write(String.format("Quantidade de arvores de goiaba: %d \n", qtdArvoreGoiaba));
    		escritor.write(String.format("Quantidade de goiabas no chão:  %d \n", qtdGoiabaNoChao));

    		escritor.write(" \n");

    		escritor.write(String.format("Quantidade de arvores de maracuja: %d \n", qtdMaracujaEmArvore));
    		escritor.write(String.format("Quantidade de maracujas no chão:  %d \n", qtdMaracujaNoChao));
    		
    	} catch(Exception erro) {
    		
    		System.out.println("Erro ao escrever no arquivo!! \n\n");
    		erro.printStackTrace();
    	}
	}*/
}
