
package jogadores;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import cenario.ImagensCenario;
import cenario.Terreno;
import view.InterfaceWB;

/**
 * Classe que representa um jogador no jogo.
 * Um jogador possui um nome e uma mochila para armazenar itens.
 * A mochila tem uma capacidade específica, definida na criação do jogador.
 */

public class Jogador {
	
	/**
	 * Nome e mochila de cada jogdor
	 */
	private String nome;
	private Mochila mochila;
	private int posX;
	private int posY;
	private ImagensCenario imagens;
	private JPanel painelJogo;
//	private InterfaceWB interfaces;
	
	 /**
     * Construtor da classe Jogador.
     * 
     * @param nome: O nome do jogador.
     * @param capacidade: A capacidade da mochila do jogador.
     */
	
	public Jogador(String nome, int capacidade, ImagensCenario imagens){
		
		mochila = new Mochila(capacidade);
		this.nome = nome;
		this.imagens = imagens;
		posX = 0;
		posY = 0;
	}
	
    public void configurarPainelJogador(JPanel telaJogo) {
    	
        this.painelJogo = telaJogo;
        configurarMovimentos();
    }
    
    private void configurarMovimentos() {
    	
        painelJogo.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "moverParaCima");
        
        painelJogo.getActionMap().put("moverParaCima", new AbstractAction() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                moverParaCima();
            }
            
            
        });
        
        painelJogo.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "moverParaBaixo");
        
        painelJogo.getActionMap().put("moverParaBaixo", new AbstractAction() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                moverParaBaixo();
            }
        });
        
        painelJogo.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "moverParaEsquerda");
        
        painelJogo.getActionMap().put("moverParaEsquerda", new AbstractAction() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                moverParaEsquerda();
            }
        });
        
        painelJogo.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "moverParaDireita");
        
        painelJogo.getActionMap().put("moverParaDireita", new AbstractAction() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                moverParaDireita();
            }
        });
    
   
    }

    
    private void moverParaCima() {
    	
        if (posY > 0) {
        	
            posY -= 70;
            painelJogo.repaint();
        }
    }

    private void moverParaBaixo() {
    	
        if (posY < painelJogo.getHeight() - 70) {
        	
            posY += 70;
            painelJogo.repaint();
        }
    }

    private void moverParaEsquerda() {
    	
        if (posX > 0) {
        	
            posX -= 70;
            painelJogo.repaint();
        }
    }

    private void moverParaDireita() {
    	
        if (posX < painelJogo.getWidth() - 70) {
        	
            posX += 70;
            painelJogo.repaint();
        }
    }
    
    public void desenharJogador(Graphics g) {
    	
        BufferedImage imagemBoneco = imagens.getImagemBoneco();
        g.drawImage(imagemBoneco, posX, posY, painelJogo);
    }
    
    public void moverPersonagem(KeyEvent e, int valorDado) {

    	
    	while(valorDado > 0){

	        switch (e.getKeyCode()) {
	        
	            case KeyEvent.VK_LEFT:
	            	
	                posX = Math.max(0, posX - 10);
	                valorDado--;
	                break;
	                
	            case KeyEvent.VK_RIGHT:
	            	
	                posX = Math.min(painelJogo.getWidth() - 70, posX + 10);
	                valorDado--;
	                break;
	                
	            case KeyEvent.VK_UP:
	            		
	                posY = Math.max(0, posY - 10);
	                valorDado--;
	                break;
	                
	            case KeyEvent.VK_DOWN:
	            	
	                posY = Math.min(painelJogo.getHeight() - 70, posY + 10);
	                valorDado--;
	                break;
	        }  
	        
	       if(valorDado == 0) {
	    	   return;
	       }
		}
	    	

        painelJogo.repaint();
    }
	/**
	 * get do nome
	 * @return nome do jogador
	 */
	
	public String getNome() {
		return nome;
	}
	
	/**
     * Define o nome do jogador.
     * 
     * @param nome O novo nome do jogador.
     */
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	 /**
     * Retorna a mochila do jogador.
     * 
     * @return A mochila do jogador.
     */
	
	public Mochila getMochila() {
		return mochila;
	}
	
	  /**
     * Define a mochila do jogador.
     * 
     * @param mochila A nova mochila do jogador.
     */
	
	public void setMochila(Mochila mochila) {
		this.mochila = mochila;
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}
	
}