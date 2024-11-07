package controlador;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cenario.Arvore;
import cenario.Grama;
import cenario.ImagensCenario;
import cenario.Pedra;
import cenario.Solo;
import cenario.Terreno;
import frutas.Frutas;
import jogadores.Jogador;


/**
 * 
 * Classe responsável pela criação e o preenchimento do cenário com
 * os elementos do jogo, como grama, árvores, pedras e frutas.
 * 
 * A classe herda de {@link ImagensCenario} e utiliza a matriz do terreno para
 * distribuir os objetos no cenário do jogo.
 * 
 */

public class controlador extends ImagensCenario{

//	private Terreno cenario;
	/** Objeto da classe {@link Terreno} que representa o cenário do jogo. */
//	private Terreno cenario;
	
	/**
     * Construtor da classe controlador.
     * Inicializa o cenário com o tamanho especificado e a quantidade de pedras.
     * 
     * @param tamanhoCenario: tamanho do cenário que será uma matriz quadrada.
     * @param qtdPedra: quantidade de pedras que devem ser inseridas no cenário.
     */

	public controlador(int tamanhoCenario){

		super(tamanhoCenario);
	//	this.cenario = new Terreno(tamanhoCenario, qtdPedra);
	}
	
	/**
	 * Método responsável por preencher todo o terreno do cenário com objetos do tipo {@link Grama}.
	 * 
	 * O método cria uma nova matriz de objetos do tipo {@link Solo}, e para cada posição da matriz, 
	 * coloca um objeto de grama, que representa o solo base do cenário. Além disso, a matriz de 
	 * imagens associada ao cenário é atualizada com a imagem conforme a inserção correspondente de grama.
	 * 
	 * Após preencher a matriz, ela é configurada no objeto {@link Terreno}.
	 */

	public void preencherTerrenoDeGrama(Terreno cenario) {

		Grama grama;
	//	Solo[][] novaMatriz = cenario.getSolo();
		Solo[][] novaMatriz = new Solo[cenario.getDimensao()][cenario.getDimensao()];
		
		matrizImagens = new BufferedImage[cenario.getDimensao()][cenario.getDimensao()];
		
	//	BufferedImage[][] novaMatrizImagens = new BufferedImage[cenario.getDimensao()][cenario.getDimensao()];
		
		System.out.println("Dimensão do cenário no constroador: " + cenario.getDimensao());
		System.out.println("Quantidade de pedras no controlador: " + cenario.getQtdPedra());
		
		System.out.println("\n");
		
		for (int i = 0; i < cenario.getDimensao(); i++){
			for (int j = 0; j < cenario.getDimensao(); j++) {

				grama = new Grama();
				novaMatriz[i][j] = grama;
			//	cenario.getSolo()[i][j] = grama;
				matrizImagens[i][j] = imagemGrama;
			//	novaMatrizImagens[i][j] = imagemGrama;

				System.out.printf("Grama foi colocado na posição %d %d \n",i,j);

			} 
		}
		
		cenario.setSolo(novaMatriz);
		System.out.println("");
	}	
	
	/**
	 * Método responsável por preencher o terreno do cenário com objetos do tipo {@link Pedra}.
	 * 
	 * O método gera posições aleatórias e verifica se a célula já está preenchida com árvore. 
	 * Se a posição ter apenas grama, a pedra é colocada mudando o apontamento da célula. 
	 * Caso contrário, a iteração atual é repetida até encontrar uma posição válida.
	 * 
	 * A matriz de imagens do cenário é atualizada com a imagem correspondente à pedra.
	 * 
	 * Ao final, a matriz de solo atualizada é configurada no objeto {@link Terreno}.
	 */

	public void preencherTerrenoDePedra(Terreno cenario) {

		Random numAleatorio = new Random();	
		Grama grama = new Grama();
		Pedra pedra = new Pedra();
		
		Solo[][] novoSolo = cenario.getSolo();

		for (int i = 0; i < cenario.getQtdPedra(); i++){

			int posicaoXPedra = numAleatorio.nextInt(cenario.getDimensao());
			int posicaoYPedra = numAleatorio.nextInt(cenario.getDimensao());

			if(cenario.getSolo()[posicaoXPedra][posicaoYPedra] instanceof Grama && grama.getArvores() == null) {
				
					novoSolo[posicaoXPedra][posicaoYPedra] = pedra;
				//	cenario.getSolo()[posicaoXPedra][posicaoYPedra] = pedra;
					matrizImagens[posicaoXPedra][posicaoYPedra] = imagemPedra;

					System.out.printf("Pedra foi colocado na posição %d %d\n",posicaoXPedra,posicaoYPedra);
				} 

				else {
					i--;
					System.out.println("Não é possível colcoar esta pedra aí, pois já possui uma árvore!! \n");
				} 
			}
		
		cenario.setSolo(novoSolo); 
		System.out.println("");
	}
	
	/**
	 * Método responsável por alocar árvores aleatoriamente no terreno.
	 * 
	 * O método gera posições aleatórias dentro da matriz do cenário e verifica se a célula
	 * contém apenas grama e se a célula não está ocupada por uma árvore ou frutas.
	 * Se a posição for válida, uma árvore é alocada na célula e a matriz de imagens é 
	 * atualizada com a imagem da árvore. Se não, a iteração atual é repetida até 
	 * encontrar uma posição válida.
	 * 
	 * @param qtdArvore número de árvores a serem alocadas no cenário
	 */


	public void alocaArvoreFrutifera (int qtdArvore, Terreno cenario) {
		
		Random numAleatorio = new Random();
	//	Arvore arvore = new Arvore(qtdArvore);
		
		for (int i=0; i < qtdArvore; i++){
			
			int posXArvore = numAleatorio.nextInt(cenario.getDimensao());
			int posYArvore = numAleatorio.nextInt(cenario.getDimensao());
		
			if(cenario.getSolo()[posXArvore][posYArvore] instanceof Grama) {
				
				Grama gramaAtual = (Grama) cenario.getSolo()[posXArvore][posYArvore];
				
				if(gramaAtual.getArvores() == null && gramaAtual.getFrutas() == null) {
					
					Arvore arvore = new Arvore(qtdArvore);
					gramaAtual.setArvores(arvore);
					matrizImagens[posXArvore][posYArvore] = imagemArvore;
					System.out.printf("Arvore foi colocado na posição %d %d\n",posXArvore,posYArvore);
				//	break;		
				}
			}
				
			else{
				i--;
				System.out.printf("Não é possivel colocar arvore nesta grama %d %d, pois ja existe uma arvore ou pedra nela!! \n",posXArvore,posYArvore);
			}
		}
		
		System.out.println("");
	}


	/**
	 * Método responsável por alocar frutas aleatoriamente no chão do cenário.
	 * 
	 * O método gera posições aleatórias dentro da matriz do cenário e verifica se a célula
	 * contém apenas grama e se a célula não está ocupada por uma árvore ou outra fruta.
	 * Se a posição for válida, uma fruta é alocada na célula e a matriz de imagens é 
	 * atualizada com a imagem da fruta. Caso contrário, a iteração atual é repetida até 
	 * encontrar uma posição válida.
	 * 
	 * @param qtdFrutas número de frutas a serem alocadas no cenário
	 */

	public void alocaFrutaNoChao(int qtdFrutas, Terreno cenario){

		Random numAleatorio = new Random();
		Frutas fruta;
		
		for (int i = 0; i < qtdFrutas; i++){

			int posXFruta = numAleatorio.nextInt(cenario.getDimensao());
			int posYFruta = numAleatorio.nextInt(cenario.getDimensao());

			if(cenario.getSolo()[posXFruta][posYFruta] instanceof Grama){

				Grama gramaAtual = (Grama) cenario.getSolo()[posXFruta][posYFruta];

				if(gramaAtual.getArvores() == null && gramaAtual.getFrutas() == null){
					
					fruta = new Frutas();
					gramaAtual.setFrutas(fruta);
					matrizImagens[posXFruta][posYFruta] = imagemLaranja;
					System.out.printf("Fruta foi colocado na posição %d %d\n",posXFruta,posYFruta);

				}

				else {
					i--;
					System.out.printf("Não é possivel colocar fruta nesta grama %d %d, pois ja existe uma pedra, arvore ou outra fruta!! \n\n",posXFruta,posYFruta);
				}
			}
		}
		
		System.out.println("");
	}

	/**
	 * Método responsável por posicionar um jogador aleatoriamente no cenário.
	 * 
	 * O método tenta posicionar dois jogadores em células que contenham apenas grama.
	 * Ele gera coordenadas aleatórias dentro da matriz do cenário e verifica se a célula 
	 * está livre de árvores, frutas ou pedras. Se a posição for válida, um novo jogador 
	 * é criado e alocado na célula correspondente, além de atualizar a matriz de imagens 
	 * com a representação do jogador. Se não, o método tentará uma nova posição 
	 * até encontrar um local livre.
	 * 
	 * @param nome      o nome do jogador a ser posicionado
	 * @param capacidade a capacidade do jogador, que pode ser usada para limitar o número de frutas que ele pode carregar
	 */
	
	public void posicionarJogador(Jogador jogador, Terreno cenario) {
		
		Random numAleatorio = new Random();
	//	Solo[][] novaMatriz = cenario.getSolo();
		
		System.out.println("Nome do jogador: " + jogador.getNome());
		System.out.println("Capacide de sua mochila: " + jogador.getMochila().getCapacidadeMaxima());
		
		System.out.println("\n");
		
		for(int i=0; i < 1; i++){
			
			int posXJogador= numAleatorio.nextInt(cenario.getDimensao());
			int posYJogador = numAleatorio.nextInt(cenario.getDimensao());
		
			if(cenario.getSolo()[posXJogador][posYJogador] instanceof Grama){
				
				Grama gramaAtual = (Grama) cenario.getSolo()[posXJogador][posYJogador];
				
				if(gramaAtual.getArvores() == null && gramaAtual.getFrutas() == null){
					
				//	Jogador jogador = new Jogador(nome, capacidade);
					
					matrizImagens[posXJogador][posYJogador] = imagemBoneco;
					gramaAtual.setJogador(jogador);
					jogador.setPosX(posXJogador);
					jogador.setPosY(posYJogador);
					
					System.out.printf("Jogador posicionado na posição %d %d\n", posXJogador, posYJogador);
					System.out.printf("Sua posição X: %d \n", jogador.getPosX());
					System.out.printf("Sua posição Y: %d \n", jogador.getPosY());
		            break;
				}
			}
			
			else {
				
				i--;
				 System.out.printf("Não foi possível posicionar o Jogador na posição %d %d, \n", posXJogador, posYJogador);
				 System.out.print("Pois ele não pode nascer em um lugar onde tenha pedra, arvore ou fruta \n");
			}
		}
		
		System.out.println("");
	}
	
	/**
	 * Método responsável por desenhar o cenário do jogo na tela.
	 * 
	 * O método percorre a matriz do cenário e desenha as imagens correspondentes 
	 * aos elementos que estão presentes em cada célula, que no caso é grama, pedras, árvores, 
	 * frutas e jogadores. A posição de cada imagem é desenhada de acordo com as  
	 * coordenadas na matriz, e a escala é definida por um tamanho fixo por x e y. Após 
	 * desenhar todos os elementos, a tela é atualizada para refletir as alterações.
	 * 
	 * @param g         o objeto Graphics utilizado para desenhar na tela
	 * @param telaJogo  o painel onde o cenário do jogo será desenhado
	 */
	
	public void desenharCenario(Graphics g, JPanel telaJogo, Terreno cenario) {

		int tamanho = 70;

		for (int i = 0; i < cenario.getDimensao(); i++) {
			for (int j = 0; j < cenario.getDimensao(); j++) {

				int x = i * tamanho;
				int y = j * tamanho;

				if (cenario.getSolo()[i][j] instanceof Grama) {
					
					 Grama gramaAtual = (Grama) cenario.getSolo()[i][j];

					 g.drawImage(imagemGrama, x, y, tamanho, tamanho, null);
					
					 if (gramaAtual.getArvores() != null) {
		                
		                    g.drawImage(imagemArvore, x, y, tamanho, tamanho, null);
		                }
					 
					 if (gramaAtual.getFrutas() != null) {
			                
		                    g.drawImage(imagemLaranja, x, y, tamanho, tamanho, null);
		                }
					 
					 if(gramaAtual.getJogador() != null) {
						 
						 g.drawImage(imagemBoneco, x, y, tamanho, tamanho, null);
						 
					 }
					
				} else if (cenario.getSolo()[i][j] instanceof Pedra) {

					g.drawImage(imagemPedra, x, y, tamanho, tamanho, null);
					
				}
			}
		}

		telaJogo.revalidate();
		telaJogo.repaint();
	}
	
	public boolean tratamentoErroElementos(int tamanhoCenario, int elementos, String tipoElemento) {
		
		
		if(elementos > Math.pow(tamanhoCenario, 2) || elementos < 0) {
			
	        JOptionPane.showMessageDialog(null, 
	                "A quantidade de " + tipoElemento + " é maior do que o tamanho do cenário ou valor inválido", 
	                "Erro", 
	                JOptionPane.ERROR_MESSAGE); //A quantidade desse elemento é maior que o cenário
	        
	        return true;
		}
		
		return false;
	}
	
	
	public boolean tratamentoErroCenario(int tamanhoCenario) {
		
		if(tamanhoCenario < 3) {
			
	        JOptionPane.showMessageDialog(null, 
	                "Tamanho de cenário inválido! Digite um tamanho que seja de 3 ou mais", 
	                "Erro", 
	                JOptionPane.ERROR_MESSAGE); //A quantidade desse elemento é maior que o cenário
	        
	        return true;
		}
		
		return false;
	}
	
}
