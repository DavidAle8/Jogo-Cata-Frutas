package cenario;
import frutas.Frutas;
import jogadores.Jogador;

/**
 * Classe que representa o solo de grama no cenário do jogo.
 * A grama pode conter frutas, árvores e jogadores.
 */

public class Grama extends Solo{
	
	private Frutas frutas; // Referência para as frutas presentes na grama
	private Arvore arvores; // Referência para as árvores presentes na grama
	private Jogador jogador; // Referência para o jogador presente na grama
	

    /**
     * Construtor da classe Grama.
     * Inicializa as referências de frutas, árvores e jogador como null.
     */
	
	public Grama () {
		
		frutas = null;
		arvores = null;
		jogador = null;
	}

	 /**
     * Obtém as frutas presentes na grama.
     * 
     * @return As frutas presentes na grama.
     */
	
	public Frutas getFrutas() {
		return frutas;
	}
	
	 /**
     * Define as frutas presentes na grama.
     * 
     * @param frutas As frutas a serem definidas na grama.
     */

	public void setFrutas(Frutas frutas) {
		this.frutas = frutas;
	}
	
	 /**
     * Obtém as árvores presentes na grama.
     * 
     * @return As árvores presentes na grama.
     */

	public Arvore getArvores() {
		return arvores;
	}

	/**
     * Define as árvores presentes na grama.
     * 
     * @param arvores As árvores a serem definidas na grama.
     */
	
	public void setArvores(Arvore arvores) {
		this.arvores = arvores;
	}
	
	/**
     * Obtém o jogador presente na grama.
     * 
     * @return O jogador presente na grama.
     */

	public Jogador getJogador() {
		return jogador;
	}
	
	/**
     * Define o jogador presente na grama.
     * 
     * @param jogador O jogador a ser definido na grama.
     */

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
}
