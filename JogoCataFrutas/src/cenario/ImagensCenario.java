package cenario;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * A classe ImagensCenario é responsável por carregar e armazenar as imagens
 * que faça parte do cenário do jogo. Ela tem uma matriz de imagens que 
 * representa o estado visual do terreno, renderizando as imagens dos elementos do jogo
 */

public class ImagensCenario {
	/**
	 * Praticamente a matriz de imagens que conterá as imagens e cada imagem como atributo
	 * do tipo BufferedImage.
	 * 
	 */
	protected int tamanhoCenario;
	protected BufferedImage[][] matrizImagens;
	protected BufferedImage imagemGrama;
    protected BufferedImage imagemPedra;
    protected BufferedImage imagemArvore;
    protected BufferedImage imagemCoco;
    protected BufferedImage imagemLaranja;
    protected BufferedImage imagemBoneco;
    
    /**
     * Construtor da classe ImagensCenario.
     * Inicializa a matriz de imagens e carrega as imagens necessárias
     * para o cenário do jogo.
     *
     * @param tamanhoCenario O tamanho do cenário, que determina as dimensões da matriz de imagens.
     */
    
	public ImagensCenario(int tamanhoCenario){
		
		 /**
	     * Carrega as imagens dos elementos do cenário a partir de arquivos de imagem.
	     * Lança IOException para dizer o erro do carregamento das imagens carro ocorra.
	     */
		this.tamanhoCenario = tamanhoCenario;
		matrizImagens = new BufferedImage[tamanhoCenario][tamanhoCenario];
		
	//	this.cenario = new Terreno(tamanhoCenario,qtdPedra);
		
		try {
			
		    imagemGrama = ImageIO.read(getClass().getResource("/arte_terreno/Grama.png"));
		    imagemPedra = ImageIO.read(getClass().getResource("/arte_terreno/Pedra.png"));
		    imagemArvore = ImageIO.read(getClass().getResource("/arte_terreno/Arvore.png"));
		    imagemCoco = ImageIO.read(getClass().getResource("/arte_terreno/Coco.png"));
		    imagemLaranja = ImageIO.read(getClass().getResource("/arte_terreno/Laranja.png"));
		    imagemBoneco = ImageIO.read(getClass().getResource("/arte_terreno/Boneco.png"));
		    
		    System.out.println("Imagens carregadas com sucesso!! \n\n");
		    
		} catch (IOException e) {
			
			System.out.println("Erro ao carregar as imagens!! \n\n");
		    e.printStackTrace();
		}
	}
	
	
	public int getTamanhoCenario() {
		return tamanhoCenario;
	}

	public void setTamanhoCenario(int tamanhoCenario) {
		this.tamanhoCenario = tamanhoCenario;
	}
	
	/**
	 * Retorna a matriz de imagens do cenário.
	 * 
	 * @return A matriz de imagens.
	 */
	

	public BufferedImage[][] getMatrizImagens() {
		return matrizImagens;
	}
	

	/**
	 * Define a matriz de imagens do cenário.
	 * 
	 * @param matrizImagens A nova matriz de imagens a ser definida.
	 */

	public void setMatrizImagens(BufferedImage[][] matrizImagens) {
		this.matrizImagens = matrizImagens;
	}

	/**
	 * Retorna a imagem da grama.
	 * 
	 * @return A imagem da grama.
	 */
	
	public BufferedImage getImagemGrama() {
		return imagemGrama;
	}
	
	/**
	 * Define a imagem da grama.
	 * 
	 * @param imagemGrama A nova imagem da grama a ser definida.
	 */

	public void setImagemGrama(BufferedImage imagemGrama) {
		this.imagemGrama = imagemGrama;
	}
	
	/**
	 * Retorna a imagem da pedra.
	 * 
	 * @return A imagem da pedra.
	 */

	public BufferedImage getImagemPedra() {
		return imagemPedra;
	}

	/**
	 * Define a imagem da pedra.
	 * 
	 * @param imagemPedra A nova imagem da pedra a ser definida.
	 */
	
	public void setImagemPedra(BufferedImage imagemPedra) {
		this.imagemPedra = imagemPedra;
	}
	

	/**
	 * Retorna a imagem da árvore.
	 * 
	 * @return A imagem da árvore.
	 */

	public BufferedImage getImagemArvore() {
		return imagemArvore;
	}
	
	/**
	 * Define a imagem da árvore.
	 * 
	 * @param imagemArvore A nova imagem da árvore a ser definida.
	 */

	public void setImagemArvore(BufferedImage imagemArvore) {
		this.imagemArvore = imagemArvore;
	}
	

	/**
	 * Retorna a imagem do coco.
	 * 
	 * @return A imagem do coco.
	 */

	public BufferedImage getImagemCoco() {
		return imagemCoco;
	}

	/**
	 * Define a imagem do coco.
	 * 
	 * @param imagemCoco A nova imagem do coco a ser definida.
	 */

	public void setImagemCoco(BufferedImage imagemCoco) {
		this.imagemCoco = imagemCoco;
	}

	/**
	 * Retorna a imagem da laranja.
	 * 
	 * @return A imagem da laranja.
	 */
	
	public BufferedImage getImagemLaranja() {
		return imagemLaranja;
	}
	
	/**
	 * Define a imagem da laranja.
	 * 
	 * @param imagemLaranja A nova imagem da laranja a ser definida.
	 */

	public void setImagemLaranja(BufferedImage imagemLaranja) {
		this.imagemLaranja = imagemLaranja;
	}
	

	/**
	 * Retorna a imagem do boneco.
	 * 
	 * @return A imagem do boneco.
	 */

	public BufferedImage getImagemBoneco() {
		return imagemBoneco;
	}
	

	/**
	 * Define a imagem do boneco.
	 * 
	 * @param imagemBoneco A nova imagem do boneco a ser definida.
	 */

	public void setImagemBoneco(BufferedImage imagemBoneco) {
		this.imagemBoneco = imagemBoneco;
	}
}

