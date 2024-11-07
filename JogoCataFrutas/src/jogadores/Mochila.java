package jogadores;

import frutas.Frutas;

/**
 * Claase mochila que será responsável por receber as frutas que cada 
 * jogador guarda.
 */
public class Mochila {
	/**
	 * Array de frutas para guardar as frutas
	 * capacidade maxima que a mochila pode guaradr frutas
	 * quantidade atual de frutas
	 */
	private Frutas[] frutas;
	private int capacidadeMaxima;
	private int quantidadeAtual;
	
	/**
	 * Cria uma nova mochila com a capacidade máxima especificada.
	 * 
	 * @param capacidadeMaxima A capacidade máxima da mochila.
	 */
	
	public Mochila(int capacidadeMaxima){
		
		this.capacidadeMaxima = capacidadeMaxima;
		frutas = new Frutas[capacidadeMaxima];
		quantidadeAtual = 0;
	}
	
	/**
	 * Retorna as frutas armazenadas na mochila.
	 * 
	 * @return Um array de frutas armazenadas na mochila.
	 */
	
	public Frutas[] getFrutas() {
		return frutas;
	}
	
	/**
	 * Define as frutas armazenadas na mochila.
	 * 
	 * @param frutas O array de frutas a ser definido na mochila.
	 */
	
	public void setFrutas(Frutas[] frutas) {
		this.frutas = frutas;
	}
	
	/**
	 * Retorna a capacidade máxima da mochila.
	 * 
	 * @return A capacidade máxima da mochila.
	 */
	
	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}
	
	/**
	 * Define a capacidade máxima da mochila.
	 * 
	 * @param capacidadeMaxima A nova capacidade máxima da mochila.
	 */
	
	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
	/**
	 * Retorna a quantidade atual de frutas armazenadas na mochila.
	 * 
	 * @return A quantidade atual de frutas.
	 */
	
	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}
	
	/**
	 * Define a quantidade atual de frutas armazenadas na mochila.
	 * 
	 * @param quantidadeAtual A nova quantidade atual de frutas.
	 */
	
	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}
	
}
