package arte_terreno;

import java.awt.Graphics;

import javax.swing.JPanel;

import cenario.Grama;
import cenario.ImagensCenario;
import cenario.Pedra;
import cenario.Terreno;

/**
 * A classe TerrenoGrafico é responsável por desenhar o cenário do jogo
 * utilizando imagens carregadas da classe ImagensCenario e a matriz de imagens.
 * 	Ela estende a classe ImagensCenario para ter acesso aos atributos e métodos necessários para 
 * o desenho do cenário.
 */

public class TerrenoGrafico extends ImagensCenario{	
	//	private Terreno cenario;
	/**
	 * Construtor de TerrenoGrafico iciniazando o construtor de sua mae ImagensCenario.
	 * @param tamanhoCenario: define o tamanho do cenario para a sua mãe ImagensCenario.
	 */
    public TerrenoGrafico(int tamanhoCenario) {
    	
    	super(tamanhoCenario); //FAZER ImagensCenario INICIALIZAR TBM O TERRENO, JA QUE ELE É MÃE DO controlador e terrenoGrafico, para passar o terreno para ambos.
    	// POIS COMO A MATRIZ DE IMAGEM É INICIALIZADA APENAS EM SUA CLASSE E ELES SÓ CHAMAM O SUPER, COMO terrenoGrafico consegue ter essa matriz certinha mas o terrenp não?
   // 	this.cenario = cenario;
    }
    
    /**
     * Desenha o cenário do jogo na tela, usando a matriz de imagens 
     * armazenadas na classe ImagensCenario. Este método itera por cada 
     * posição da matriz e desenha a imagem correspondente no componente 
     * JPanel fornecido.
     *
     * @param g: O objeto Graphics que é usado para desenhar as imagens 
     *          no painel.
     * @param telaJogo: O painel JPanel onde o cenário será desenhado.
     */
	
    public void pintarCenario(Graphics g, JPanel telaJogo) {
    
		int tamanho = 70;

		for (int i = 0; i < matrizImagens.length; i++) {
			for (int j = 0; j < matrizImagens.length; j++) {

				int x = i * tamanho;
				int y = j * tamanho;

				if (matrizImagens[i][j] == imagemGrama) {

					g.drawImage(matrizImagens[i][j], x, y, tamanho, tamanho, null);
					
					 if (matrizImagens[i][j] == imagemArvore) {
		                
		                    g.drawImage(matrizImagens[i][j], x, y, tamanho, tamanho, null);
		                }
					 
					 if (matrizImagens[i][j] == imagemLaranja) {
			                
		                    g.drawImage(matrizImagens[i][j], x, y, tamanho, tamanho, null);
		                }
					 
					 if(matrizImagens[i][j] == imagemBoneco) {
						 
						 g.drawImage(matrizImagens[i][j], x, y, tamanho, tamanho, null);
						 
					 }
					
				} else if (matrizImagens[i][j] == imagemPedra) {

					g.drawImage(matrizImagens[i][j], x, y, tamanho, tamanho, null);
					
				}
			}
		}

		telaJogo.revalidate();
		telaJogo.repaint();  
    }
    

	public void pintarCenario2(Graphics g, JPanel telaJogo, Terreno cenario) {

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
}
