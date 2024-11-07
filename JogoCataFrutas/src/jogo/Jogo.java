package jogo;

import java.util.Random;

import javax.swing.JOptionPane;

import cenario.Terreno;
import jogadores.Jogador;
import view.InterfaceWB;

public class Jogo extends InterfaceWB{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int dado;
	private Terreno cenario;
	private Jogador jogador1;
	private Jogador jogador2;
	private boolean jogoRodando;
	private int rodada;
	
	
	public Jogo(Jogador jogador1, Jogador jogador2){
		
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		jogoRodando = true;
		dado = 0;
		rodada = 1;
	}
	
	public int rolarDado(){
		
		Random valorDado = new Random();
		
		dado = valorDado.nextInt(12)+1;
		return dado;		
	}
	
	public void fazerJogada(Jogador jogador) {
		
		  int resposta = JOptionPane.showOptionDialog(  
            null, 
            "Clique em 'Rolar' para rolar o dado.", 
            "Vez de: " + jogador.getNome(), 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            new Object[] {"Rolar"}, //Botão que criamos chamado 'Girar' 
            "Rolar"
	        );

            if (resposta == 0) {

                dado = rolarDado();
                JOptionPane.showMessageDialog(null, jogador.getNome() + " tirou: " + dado);
            }
            
	}
	
	
	public void iniciar() {
		
		do{
			if(rodada%2 != 0) {
				
				//Vez do jogador 1.
				fazerJogada(jogador1);
				jogador1.moverPersonagem(null, dado);
				
			}
			
			else {
				
				//Vez do jogador 2.
				jogador2.moverPersonagem(null,dado);
			}

			rodada++;
			
		}while(jogoRodando);	
	}

	
	
	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}
	
}
