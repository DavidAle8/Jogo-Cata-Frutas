package cenario;

/**
 * Classe que representa o terreno do cenário do jogo.
 * O terreno é composto por uma matriz de células do tipo Solo e contém informações sobre sua dimensão e quantidade de pedras.
 */

public class Terreno {
	
	private Solo[][] celulas; // Matriz que representa as células do terreno
	private int dimensao; // Dimensão do terreno (número de células em cada direção)
	private int qtdPedra; // Quantidade de pedras no terreno
	
	 /**
     * Construtor da classe Terreno.
     * Inicializa o terreno com a dimensão especificada e a quantidade de pedras.
     * 
     * @param dimensao A dimensão do terreno (número de células em cada direção).
     * @param qtdPedra A quantidade de pedras a serem colocadas no terreno.
     */
	
	public Terreno(int dimensao,int qtdPedra) {

		this.qtdPedra = qtdPedra;
		this.dimensao = dimensao;
		celulas = new Solo[dimensao][dimensao];

	}
	
	 /**
     * Obtém a matriz de células do terreno.
     * 
     * @return A matriz de células do tipo Solo que compõem o terreno.
     */
	
	public Solo[][] getSolo() {
		return celulas;
	}
	
	 /**
     * Define a matriz de células do terreno.
     * 
     * @param celula A matriz de células a ser definida no terreno.
     */
	
	public void setSolo(Solo[][] celula) {
		this.celulas = celula;
	}
	
	/**
     * Obtém a dimensão do terreno.
     * 
     * @return A dimensão do terreno (número de células em cada direção).
     */
	
	public int getDimensao() {
		return dimensao;
	}
	
	  /**
     * Define a dimensão do terreno.
     * 
     * @param dimensao A nova dimensão do terreno (número de células em cada direção).
     */
	
	public void setDimensao(int dimensao) {
		this.dimensao = dimensao;
	}

	/**
     * Obtém a quantidade de pedras no terreno.
     * 
     * @return A quantidade de pedras presentes no terreno.
     */
	
	public int getQtdPedra() {
		return qtdPedra;
	}
	
	 /**
     * Define a quantidade de pedras no terreno.
     * 
     * @param qtdPedra A nova quantidade de pedras a ser definida no terreno.
     */

	public void setQtdPedra(int qtdPedra) {
		this.qtdPedra = qtdPedra;
	}
	
	public void novaDimensao(int novaDimensao) {
		
		this.dimensao = novaDimensao;
		this.celulas = new Solo[novaDimensao][novaDimensao];
	}
	
	public void novaQtdPedras(int novaQtdPedra) {
		
		this.qtdPedra = novaQtdPedra;
	}
	
}
