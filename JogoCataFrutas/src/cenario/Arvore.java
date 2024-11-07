package cenario;

/**
 * Classe que representa uma árvore no cenário do jogo.
 */
public class Arvore {

	private int quantidadeArvore; // Armazena a quantidade de árvores
	
	/**
     * Obtém a quantidade de árvores.
     * 
     * @return A quantidade de árvores.
     */
	
	public Arvore(int quantidadeArvore){
		
		this.quantidadeArvore = quantidadeArvore;
	}
	
	public int getQuantidadeArvore() {
		
		return quantidadeArvore;
	}

	/**
     * Define a quantidade de árvores.
     * 
     * @param quantidadeArvore A quantidade de árvores a ser definida.
     */
	
	public void setQuantidadeArvore(int quantidadeArvore) {
		
		this.quantidadeArvore = quantidadeArvore;
		
	}

}


