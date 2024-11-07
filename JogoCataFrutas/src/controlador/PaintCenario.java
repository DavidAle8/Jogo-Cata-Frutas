package controlador;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import cenario.Terreno;
import jogadores.Jogador;

/**
 * Classe responsável por gerenciar a renderização do cenário do jogo em um painel.
 * Esta classe estende {@link JPanel} e implementa o método {@link #paintComponent(Graphics)}
 * para desenhar o cenário utilizando o controlador.
 * 
 * O painel é usado para exibir a representação gráfica do jogo, permitindo que os
 * elementos do cenário sejam desenhados com base nas informações fornecidas pelo controlador.
 */

public class PaintCenario extends JPanel{
	
	private static final long serialVersionUID = 1L;

    /** 
     * O controlador que cuida da lógica do jogo e fornece os dados necessários 
     * para desenhar o cenário.
     */
	private controlador controlador;
	private Terreno cenario;
	private List<Jogador> jogadores;
	 
    /**
     * Construtor da classe PaintCenario.
     * 
     * @param controlador: O controlador que será utilizado para acessar os métodos de desenho do cenário.
     * @param cenario: O cenário a ser desenhado.
     * @param jogadores: Lista de jogadores a serem desenhados no cenário.
     */
    public PaintCenario(controlador controlador, Terreno cenario, List<Jogador> jogadores) {
    	
        this.controlador = controlador;
        this.cenario = cenario;
        this.jogadores = jogadores;
        
        for (Jogador jogador : jogadores) {
        	
            jogador.configurarPainelJogador(this);
        }
    }

	 
	 /**
	  * Método responsável por realizar o desenho do cenário no painel.
	  * Este método é chamado automaticamente pelo sistema sempre que
	  * o painel precisa ser redesenhado, como quando é exibido pela primeira
	  * vez ou quando é atualizado. Ele chama o método {@link controlador#desenharCenario(Graphics, JPanel)}
	  * do controlador para desenhar o cenário utilizando o objeto Graphics 
	  * fornecido.
	  *
	  * @param g O objeto Graphics que será utilizado para desenhar no painel.
	  */
	 
	 @Override
	 
	 protected void paintComponent(Graphics g) {
		 
	     super.paintComponent(g);
	     controlador.desenharCenario(g, this, cenario);
	     // Passa o próprio painel como referência
	        for (Jogador jogador : jogadores) {
	        	
	            jogador.desenharJogador(g);
	        }
	 }
 
}




