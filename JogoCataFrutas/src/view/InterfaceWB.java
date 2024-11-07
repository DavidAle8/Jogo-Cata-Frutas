package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import cenario.Grama;
import cenario.ImagensCenario;
import cenario.Solo;
import cenario.Terreno;
import controlador.LeituraEscritaArquivo;
import controlador.PaintCenario;
import controlador.controlador;
import jogadores.Jogador;
import jogadores.Mochila;
import jogo.Jogo;

/**
 * Classe responsável por criar a interface gráfica do jogo Cata-Frutas.
 * Esta classe exibe os campos de entrada para configuração do cenário, como o tamanho do cenário,
 * a quantidade de pedras, árvores e frutas.
 * 
 * A interface exibe também os jogadores e as frutas.
 * 
 * Extende a classe {@link JFrame}.
 */

public class InterfaceWB extends JFrame {
	
	/**
	 * Atributos responsáveis por guardar os inputs dados do usuario para configuração
	 * e a propria tela JPanel
	 * 
	 */
	//COLOCAR OS ATRIBUTOS AQUI QUE FAZEM PARTE DAS CONFIGURAÇÕES PARA DAR SET NELAS E ATUALIZAR O CENÁRIO.
	
	
	//PRATICAMENTE, CADA BOTÃO APERTADO, PEGO O SET DAS COISAS E RECEBO O QUE FOI DIGITADO PO USUÁRIO
	//DEPOIS, NO CONFIRMAR, EU PEGO COM O CONTROLADOR APENAS PRA COLOCAR ESSES OBJETOS NO CENÁRIO, TANTO OBJETO COMO IMAGEM
	//É COMO SE AO MESMO TEMPO EU ESTEJA GUARDANDO NAS CLASSES DO JOGO AS COISAS DE CADA UM E O CONTROLADOR SÓ PRA POSICIONAR
	
	private static final long serialVersionUID = 1L;
	private Grama grama;
	private Terreno cenario;
	private ImagensCenario imagens;
	private Jogo jogo;
	private JPanel menu;
	
	private Jogador jogador1;
	private Jogador jogador2;
	private Mochila mochila1;
	private Mochila mochila2;
	
	private String caminhoArquivo;
	
	private JTextField inputJogador1;
	private JTextField inputJogador2;
	private JTextField inputMochila;
	private JTextField inputTamanhoCenario;
	private JTextField inputQuantidadePedras;
	private JTextField inputQtdArvoreLaranja;
	private JTextField inputQtdLaranjaNoChao;
	private JTextField inputQtdArvoreAbacate;
	private JTextField inputQtdAbacateNoChao;
	private JTextField inputQtdArvoreCoco;
	private JTextField inputQtdCocoNoChao;
	private JTextField inputQtdArvoreAcerola;
	private JTextField inputQtdAcerolaNoChao;
	private JTextField inputQtdArvoreAmora;
	private JTextField inputQtdAmoraNoChao;
	private JTextField inputQtdArvoreGoiaba;
	private JTextField inputQtdGoiabaNoChao;
	private JTextField inputQtdMaracujaArvore;
	private JTextField inputMaracujaNoChao;
	private JTextField inputBichada;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					InterfaceWB frame = new InterfaceWB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Classe responsável pela interface gráfica do jogo.
	 * Esta classe cria uma janela principal com um painel de menu que contém botões para jogar e configurar o jogo.
	 */
	public InterfaceWB(){
		
		/**
		 * Inicio - Tela do menu principal
		 */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120,10, 1258,833);
		menu = new JPanel();
		menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(menu);
		menu.setLayout(null);
		
		JButton botaoJogar = new JButton("Jogar");
		botaoJogar.setBounds(653, 572, 150, 35);
		botaoJogar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		menu.add(botaoJogar);
	
	

		JButton botaoConfigurar = new JButton("Configurar");
		botaoConfigurar.setBounds(653, 627, 150, 35);
		botaoConfigurar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botaoConfigurar.setVisible(true);
		menu.add(botaoConfigurar);
		
		/**
		 * Fim - Tela do menu principal
		 */
		
		
		/**
		 * Inicio - Painel de config. dos jogadores
		 */
		
		JPanel painelJogadores = new JPanel();
		painelJogadores.setBounds(456, 10, 555, 552);
		painelJogadores.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		painelJogadores.setBackground(new Color(0, 128, 192));
		painelJogadores.setLayout(null);
		painelJogadores.setVisible(false);
		menu.add(painelJogadores);
		
		
		
		JLabel headerConfigJogadores = new JLabel("Configurações dos Jogadores");
		headerConfigJogadores.setForeground(new Color(0, 0, 0));
		headerConfigJogadores.setHorizontalAlignment(SwingConstants.CENTER);
		headerConfigJogadores.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		headerConfigJogadores.setBounds(60, 0, 400, 76);
		painelJogadores.add(headerConfigJogadores);
		
		
		
		JSeparator separador1 = new JSeparator();
		separador1.setBounds(42, 54, 430, 43);
	    painelJogadores.add(separador1);
		
		
		
		JLabel nomeJogador1 = new JLabel("Nome do Jogador 1: ");
		nomeJogador1.setForeground(new Color(0, 0, 0));
		nomeJogador1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		nomeJogador1.setBounds(22, 108, 230, 30);
		painelJogadores.add(nomeJogador1);
		
		inputJogador1 = new JTextField();
		inputJogador1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputJogador1.setText("Jogador 1");
		inputJogador1.setBounds(22, 158, 400, 32);
		inputJogador1.setColumns(10);
		painelJogadores.add(inputJogador1);



		JLabel nomeJogador2 = new JLabel("Nome do Jogador 2: ");
		nomeJogador2.setForeground(new Color(0, 0, 0));
		nomeJogador2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		nomeJogador2.setBounds(20, 228, 232, 32);
		painelJogadores.add(nomeJogador2);
	
		inputJogador2 = new JTextField();
		inputJogador2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputJogador2.setText("Jogador 2");
		inputJogador2.setColumns(10);
		inputJogador2.setBounds(22, 278, 400, 32);
		painelJogadores.add(inputJogador2);
		
		
		
		JLabel capacidadeMochila = new JLabel("Capacidade da mochila: ");
		capacidadeMochila.setForeground(new Color(0, 0, 0));
		capacidadeMochila.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		capacidadeMochila.setBounds(22, 328, 232, 32);
		painelJogadores.add(capacidadeMochila);
		
		inputMochila = new JTextField();
		inputMochila.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputMochila.setText("10");
		inputMochila.setColumns(10);
		inputMochila.setBounds(22, 378, 77, 32);
		painelJogadores.add(inputMochila);
		
		
		JButton botaoContinuarConfigJogo = new JButton("Continuar");
		botaoContinuarConfigJogo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botaoContinuarConfigJogo.setBounds(204, 487, 150, 30);
		painelJogadores.add(botaoContinuarConfigJogo);
		
		JButton botaoVoltarCarregarCenario = new JButton("Voltar");
		botaoVoltarCarregarCenario.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botaoVoltarCarregarCenario.setBounds(20, 487, 150, 30);
		painelJogadores.add(botaoVoltarCarregarCenario);
		
		
		
		/**
		 * Fim - Painel de config. dos jogadores
		 */
		
		
		
		
		/**
		 * Inicio - Painel do config. do cenario
		 */
		
		JPanel painelCarregarCenario = new JPanel();
		painelCarregarCenario.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		painelCarregarCenario.setBackground(new Color(0, 128, 192));
		painelCarregarCenario.setBounds(515, 10, 448, 395);
		menu.add(painelCarregarCenario);
		painelCarregarCenario.setLayout(null);
		painelCarregarCenario.setVisible(false);
		
		
		JButton botaoNovoCenario = new JButton("Novo Cenário");
		botaoNovoCenario.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botaoNovoCenario.setBounds(125, 153, 180, 40);
		painelCarregarCenario.add(botaoNovoCenario);
		
	//	653, 572, 150, 35
		
		JButton botaoCarregarArquivo = new JButton("Carregar arquivo");
		botaoCarregarArquivo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botaoCarregarArquivo.setBounds(107, 217, 214, 40);
		painelCarregarCenario.add(botaoCarregarArquivo);
		
		
		JLabel headerConguracaoCenario = new JLabel("Configurações do Cenário");
		headerConguracaoCenario.setHorizontalAlignment(SwingConstants.CENTER);
		headerConguracaoCenario.setForeground(Color.BLACK);
		headerConguracaoCenario.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		headerConguracaoCenario.setBounds(21, 10, 400, 76);
		painelCarregarCenario.add(headerConguracaoCenario);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 67, 359, 62);
		painelCarregarCenario.add(separator);
		
		JButton botaoVoltarMenu = new JButton("Voltar");
		botaoVoltarMenu.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botaoVoltarMenu.setBounds(21, 340, 150, 30);
		painelCarregarCenario.add(botaoVoltarMenu);
		
		
		JPanel painelCenario = new JPanel();
		painelCenario.setBounds(456, 10, 555, 552);
		painelCenario.setBackground(new Color(0, 128, 255));
		painelCenario.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		painelCenario.setLayout(null);
		painelCenario.setVisible(false);
		menu.add(painelCenario);
		
		
		
		JLabel headerConfigCenario = new JLabel("Configurações do Cenário");
		headerConfigCenario.setHorizontalAlignment(SwingConstants.CENTER);
		headerConfigCenario.setForeground(Color.BLACK);
		headerConfigCenario.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		headerConfigCenario.setBounds(81, 10, 400, 42);
		painelCenario.add(headerConfigCenario);
		
		
		
		JButton botaoEtapa2 = new JButton("2° Etapa  >>");
		botaoEtapa2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		botaoEtapa2.setBounds(28, 104, 112, 21);
		painelCenario.add(botaoEtapa2);
		
		JButton botaoEtapa1 = new JButton("<< 1° Etapa");
		botaoEtapa1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		botaoEtapa1.setBounds(173, 104, 112, 21);
		botaoEtapa1.setVisible(false);
		painelCenario.add(botaoEtapa1);
		
		
		
		
		JLabel tamanhoCenario = new JLabel("Tamanho do Cenário:");
		tamanhoCenario.setForeground(Color.BLACK);
		tamanhoCenario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		tamanhoCenario.setBounds(28, 175, 230, 30);
		painelCenario.add(tamanhoCenario);
		
		inputTamanhoCenario = new JTextField();
		inputTamanhoCenario.setColumns(10);
		inputTamanhoCenario.setText("10");
		inputTamanhoCenario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputTamanhoCenario.setBounds(28, 215, 80, 30);
		painelCenario.add(inputTamanhoCenario);
		
		
		JLabel quantiadePedras = new JLabel("Quantidade de pedras no jogo:");
		quantiadePedras.setForeground(Color.BLACK);
		quantiadePedras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		quantiadePedras.setBounds(28, 272, 325, 30);
		painelCenario.add(quantiadePedras); 
		
		inputQuantidadePedras = new JTextField();
		inputQuantidadePedras.setText("4");
		inputQuantidadePedras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQuantidadePedras.setColumns(10);
		inputQuantidadePedras.setBounds(28, 312, 80, 30);
		painelCenario.add(inputQuantidadePedras);
		
		
		
		
		JLabel textoBichada = new JLabel("Probabilidade da fruta Bichada:");
		textoBichada.setForeground(Color.BLACK);
		textoBichada.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoBichada.setBounds(28, 375, 313, 30);
		textoBichada.setVisible(true);
		painelCenario.add(textoBichada);
		
		inputBichada = new JTextField();
		inputBichada.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputBichada.setText("5");
		inputBichada.setColumns(10);
		inputBichada.setBounds(28, 415, 80, 30);
		inputBichada.setVisible(true);
		painelCenario.add(inputBichada);
		
		
		
		
		
		JLabel textoArvores = new JLabel("Arvores das Frutas:");
		textoArvores.setForeground(Color.BLACK);
		textoArvores.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoArvores.setBounds(28, 135, 186, 30);
		textoArvores.setVisible(false);
		painelCenario.add(textoArvores);
		
		JLabel textoFrutasNoChao = new JLabel("Frutas no chão:");
		textoFrutasNoChao.setForeground(Color.BLACK);
		textoFrutasNoChao.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoFrutasNoChao.setBounds(256, 135, 148, 30);
		textoFrutasNoChao.setVisible(false);
		painelCenario.add(textoFrutasNoChao);

		
		
		
		
		JLabel textoLaranja = new JLabel("Laranja(s):");
		textoLaranja.setForeground(Color.BLACK);
		textoLaranja.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoLaranja.setBounds(28, 162, 112, 30);	
		textoLaranja.setVisible(false);
		painelCenario.add(textoLaranja);
		
		inputQtdArvoreLaranja = new JTextField();
		inputQtdArvoreLaranja.setText("3");
		inputQtdArvoreLaranja.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdArvoreLaranja.setColumns(10);
		inputQtdArvoreLaranja.setBounds(28, 202, 60, 30);
		inputQtdArvoreLaranja.setVisible(false);
		painelCenario.add(inputQtdArvoreLaranja);
		
		inputQtdLaranjaNoChao = new JTextField();
		inputQtdLaranjaNoChao.setText("3");
		inputQtdLaranjaNoChao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdLaranjaNoChao.setColumns(10);
		inputQtdLaranjaNoChao.setBounds(256, 202, 60, 30);
		inputQtdLaranjaNoChao.setVisible(false);
		painelCenario.add(inputQtdLaranjaNoChao);
		
		
		
		
		
		JLabel textoAbacate = new JLabel("Abacate(s):");
		textoAbacate.setForeground(Color.BLACK);
		textoAbacate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoAbacate.setBounds(28, 242, 117, 30);
		textoAbacate.setVisible(false);
		painelCenario.add(textoAbacate);
		
		inputQtdArvoreAbacate = new JTextField();
		inputQtdArvoreAbacate.setText("3");
		inputQtdArvoreAbacate.setToolTipText("");
		inputQtdArvoreAbacate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdArvoreAbacate.setColumns(10);
		inputQtdArvoreAbacate.setBounds(28, 284, 60, 30);
		inputQtdArvoreAbacate.setVisible(false);
		painelCenario.add(inputQtdArvoreAbacate);
		
		inputQtdAbacateNoChao = new JTextField();
		inputQtdAbacateNoChao.setText("3");
		inputQtdAbacateNoChao.setToolTipText("");
		inputQtdAbacateNoChao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdAbacateNoChao.setColumns(10);
		inputQtdAbacateNoChao.setBounds(256, 282, 60, 30);
		inputQtdAbacateNoChao.setVisible(false);
		painelCenario.add(inputQtdAbacateNoChao);
		
		
		
		
		
		JLabel textoCoco = new JLabel("Coco(s):");
		textoCoco.setForeground(Color.BLACK);
		textoCoco.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoCoco.setBounds(28, 322, 90, 30);
		textoCoco.setVisible(false);
		painelCenario.add(textoCoco);
		
		inputQtdArvoreCoco = new JTextField();
		inputQtdArvoreCoco.setText("2");
		inputQtdArvoreCoco.setToolTipText("");
		inputQtdArvoreCoco.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdArvoreCoco.setColumns(10);
		inputQtdArvoreCoco.setBounds(28, 362, 60, 30);
		inputQtdArvoreCoco.setVisible(false);
		painelCenario.add(inputQtdArvoreCoco);
		
		inputQtdCocoNoChao = new JTextField();
		inputQtdCocoNoChao.setText("1");
		inputQtdCocoNoChao.setToolTipText("");
		inputQtdCocoNoChao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdCocoNoChao.setColumns(10);
		inputQtdCocoNoChao.setBounds(256, 362, 60, 30);
		inputQtdCocoNoChao.setVisible(false);
		painelCenario.add(inputQtdCocoNoChao);
		
		
		
		
		
		JLabel textoAcerola = new JLabel("Acerola(s):");
		textoAcerola.setForeground(Color.BLACK);
		textoAcerola.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoAcerola.setBounds(28, 402, 112, 30);
		textoAcerola.setVisible(false);
		painelCenario.add(textoAcerola);
		
		inputQtdArvoreAcerola = new JTextField();
		inputQtdArvoreAcerola.setText("2");
		inputQtdArvoreAcerola.setToolTipText("");
		inputQtdArvoreAcerola.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdArvoreAcerola.setColumns(10);
		inputQtdArvoreAcerola.setBounds(28, 442, 60, 30);
		inputQtdArvoreAcerola.setVisible(false);
		painelCenario.add(inputQtdArvoreAcerola);
		
		inputQtdAcerolaNoChao = new JTextField();
		inputQtdAcerolaNoChao.setText("1");
		inputQtdAcerolaNoChao.setToolTipText("");
		inputQtdAcerolaNoChao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdAcerolaNoChao.setColumns(10);
		inputQtdAcerolaNoChao.setBounds(256, 442, 60, 30);
		inputQtdAcerolaNoChao.setVisible(false);
		painelCenario.add(inputQtdAcerolaNoChao);
		
		
		
		
		
		JLabel textoAmora = new JLabel("Amora(s):");
		textoAmora.setForeground(Color.BLACK);
		textoAmora.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoAmora.setBounds(28, 482, 103, 30);
		textoAmora.setVisible(false);
		painelCenario.add(textoAmora);
		
		inputQtdArvoreAmora = new JTextField();
		inputQtdArvoreAmora.setText("2");
		inputQtdArvoreAmora.setToolTipText("");
		inputQtdArvoreAmora.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdArvoreAmora.setColumns(10);
		inputQtdArvoreAmora.setBounds(28, 522, 60, 30);
		inputQtdArvoreAmora.setVisible(false);
		painelCenario.add(inputQtdArvoreAmora);
		
		inputQtdAmoraNoChao = new JTextField();
		inputQtdAmoraNoChao.setText("1");
		inputQtdAmoraNoChao.setToolTipText("");
		inputQtdAmoraNoChao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdAmoraNoChao.setColumns(10);
		inputQtdAmoraNoChao.setBounds(256, 522, 60, 30);
		inputQtdAmoraNoChao.setVisible(false);
		painelCenario.add(inputQtdAmoraNoChao);
		
		
		
		
		JLabel textoGoiaba = new JLabel("Goiaba(s):");
		textoGoiaba.setForeground(Color.BLACK);
		textoGoiaba.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoGoiaba.setBounds(28, 562, 112, 30);
		textoGoiaba.setVisible(false);
		painelCenario.add(textoGoiaba);
		
		inputQtdArvoreGoiaba = new JTextField();
		inputQtdArvoreGoiaba.setText("2");
		inputQtdArvoreGoiaba.setToolTipText("");
		inputQtdArvoreGoiaba.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdArvoreGoiaba.setColumns(10);
		inputQtdArvoreGoiaba.setBounds(28, 602, 60, 30);
		inputQtdArvoreGoiaba.setVisible(false);
		painelCenario.add(inputQtdArvoreGoiaba);
		
		inputQtdGoiabaNoChao = new JTextField();
		inputQtdGoiabaNoChao.setText("1");
		inputQtdGoiabaNoChao.setToolTipText("");
		inputQtdGoiabaNoChao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdGoiabaNoChao.setColumns(10);
		inputQtdGoiabaNoChao.setBounds(256, 602, 60, 30);
		inputQtdGoiabaNoChao.setVisible(false);
		painelCenario.add(inputQtdGoiabaNoChao);
		
		
		

		
		JLabel textoMaracuja = new JLabel("Maracuja em arvore(s):");
		textoMaracuja.setForeground(Color.BLACK);
		textoMaracuja.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 19));
		textoMaracuja.setBounds(28, 642, 239, 30);
		textoMaracuja.setVisible(false);
		painelCenario.add(textoMaracuja);
		
		inputQtdMaracujaArvore = new JTextField();
		inputQtdMaracujaArvore.setText("2");
		inputQtdMaracujaArvore.setToolTipText("");
		inputQtdMaracujaArvore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputQtdMaracujaArvore.setColumns(10);
		inputQtdMaracujaArvore.setBounds(28, 682, 60, 30);
		inputQtdMaracujaArvore.setVisible(false);
		painelCenario.add(inputQtdMaracujaArvore);
		
		inputMaracujaNoChao = new JTextField();
		inputMaracujaNoChao.setText("1");
		inputMaracujaNoChao.setToolTipText("");
		inputMaracujaNoChao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		inputMaracujaNoChao.setColumns(10);
		inputMaracujaNoChao.setBounds(256, 682, 60, 30);
		inputMaracujaNoChao.setVisible(false);
		painelCenario.add(inputMaracujaNoChao);
		
		
		
				
		JButton botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setBounds(234, 742, 150, 30);
		botaoConfirmar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botaoConfirmar.setVisible(false);
		painelCenario.add(botaoConfirmar);
		
		
		JButton botaoVoltarConfigCenario = new JButton("Voltar");
		botaoVoltarConfigCenario.setBounds(28, 488, 150, 30);
		botaoVoltarConfigCenario.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		painelCenario.add(botaoVoltarConfigCenario);
		
		JSeparator separador2 = new JSeparator();
		separador2.setBounds(67, 43, 430, 43);
		botaoVoltarConfigCenario.setVisible(true);
		painelCenario.add(separador2);
		
		
		cenario = new Terreno( Integer.parseInt(inputTamanhoCenario.getText()), Integer.parseInt(inputQuantidadePedras.getText()));
		imagens = new ImagensCenario(Integer.parseInt(inputTamanhoCenario.getText()));
		
		mochila1 = new Mochila(Integer.parseInt(inputMochila.getText()));
		mochila2 = new Mochila(Integer.parseInt(inputMochila.getText()));
		
		jogador1 = new Jogador(inputJogador1.getText(),Integer.parseInt(inputMochila.getText()), imagens);
		jogador2 = new Jogador(inputJogador2.getText(),Integer.parseInt(inputMochila.getText()), imagens);
		
		grama = new Grama();
		
		caminhoArquivo = "Configuração.txt";
		
		LeituraEscritaArquivo leituriaEscrita = new LeituraEscritaArquivo(caminhoArquivo);
		
		controlador controlador = new controlador(Integer.parseInt(inputTamanhoCenario.getText()));
	
		PaintCenario telaJogo = new PaintCenario(controlador, cenario, Arrays.asList(jogador1, jogador2));
		telaJogo.setBounds(10, 21, 1302, 900);
		telaJogo.setVisible(false);
	//	telaJogo.setBackground(Color.BLUE);	
		menu.add(telaJogo);
		telaJogo.setLayout(null);
		
		/**
		 * Ação do botão jogar
		 */
		botaoJogar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				/**
				 * Cria a instancia do terreno grafico para usar o método de mostrar o cnario
				 * e da visibilidade do cenario tanto do jogo quanto do menu.
				 */

				botaoJogar.setVisible(false);
		        botaoConfigurar.setVisible(false);
		        telaJogo.setVisible(true);
		    //  terrenoGrafico.pintarCenario(getGraphics(), telaJogo);
		    //  terrenoGrafico.pintarCenario2(getGraphics(), telaJogo);
		    //  controlador.desenharCenario(getGraphics(),telaJogo);
		        
		        Jogo jogo = new Jogo(jogador1, jogador2);
		        jogo.iniciar();
		        
		        
		        
			}
		});	
		
		
		/**
		 * Ação do botão confirmar
		 */
		
		botaoConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * Variáveis que guardam os inputs dados pelo usuário.
				 */
				
				String nomeJogador1 = inputJogador1.getText();
				String nomeJogador2 = inputJogador2.getText();
				int capacidadeMochila = Integer.parseInt(inputMochila.getText());
				
				int tamanhoCenario = Integer.parseInt(inputTamanhoCenario.getText());
				int quantidadePedra = Integer.parseInt(inputQuantidadePedras.getText());
				
				int probabilidadeBichada = Integer.parseInt(inputBichada.getText());
				
				int qtdArvoreLaranja = Integer.parseInt(inputQtdArvoreLaranja.getText());
				int qtdLaranjaNoChao = Integer.parseInt(inputQtdLaranjaNoChao.getText());
				
				int qtdArvoreAbacate = Integer.parseInt(inputQtdArvoreAbacate.getText());
				int qtdAbacateNoChao = Integer.parseInt(inputQtdAbacateNoChao.getText());
				
				int qtdArvoreCoco = Integer.parseInt(inputQtdArvoreCoco.getText());
				int qtdCocoNoChao = Integer.parseInt(inputQtdCocoNoChao.getText());
				
				int qtdArvoreAcerola = Integer.parseInt(inputQtdArvoreAcerola.getText());
				int qtdAcerolaNoChao = Integer.parseInt(inputQtdAcerolaNoChao.getText());
				
				int qtdArvoreAmora = Integer.parseInt(inputQtdArvoreAmora.getText());
				int qtdAmoraNoChao = Integer.parseInt(inputQtdAmoraNoChao.getText());
				
				int qtdArvoreGoiaba = Integer.parseInt(inputQtdArvoreGoiaba.getText());
				int qtdGoiabaNoChao = Integer.parseInt(inputQtdGoiabaNoChao.getText());
				
				int qtdMaracujaEmArvore = Integer.parseInt(inputQtdMaracujaArvore.getText());
				int qtdMaracujaNoChao = Integer.parseInt(inputMaracujaNoChao.getText());
				
				//Preenchimento das coias do jogo. Nome dos jogadores, cenario, arvores, pedras...
				
				//Nome dos jogadores e capacidade da mochila
							
		//		Mochila mochila1 = new Mochila(capacidadeMochila);
		//		Mochila mochila2 = new Mochila(capacidadeMochila);
				
		//		Jogador jogador1 = new Jogador(nomeJogador1,capacidadeMochila);
		//		Jogador jogador2 = new Jogador(nomeJogador2,capacidadeMochila);
				
				
				/**
				 * Chamada dos métodos de controlador para preencher o cenário
				 */
				controlador.preencherTerrenoDeGrama(cenario);
				controlador.preencherTerrenoDePedra(cenario);
				controlador.posicionarJogador(jogador1,cenario);
				controlador.posicionarJogador(jogador2,cenario);
				
		//		controlador.desenharCenario(getGraphics(),telaJogo); //metodo que o controlador tem que mostra as imagens
				
				//Arvores de cada fruta

				controlador.alocaArvoreFrutifera(qtdArvoreLaranja,cenario);
				controlador.alocaArvoreFrutifera(qtdArvoreAbacate,cenario);
				controlador.alocaArvoreFrutifera(qtdArvoreCoco,cenario);
				controlador.alocaArvoreFrutifera(qtdArvoreAcerola,cenario);
				controlador.alocaArvoreFrutifera(qtdArvoreAmora,cenario);
				controlador.alocaArvoreFrutifera(qtdArvoreGoiaba,cenario);
				
				boolean qtdArvoreLaranjaInvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdArvoreLaranja, "arovre de laranja");
				boolean qtdArvoreAbacateInvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdArvoreAbacate, "arovre de abacate");
				boolean qtdArvoreCocoInvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdArvoreCoco, "arovre de Coco");
				boolean qtdArvoreAcerolanvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdArvoreAcerola, "arovre de Acerola");
				boolean qtdArvoreAmoranvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdArvoreAmora, "arovre de Amora");
				boolean qtdArvoreGoiabaInvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdArvoreGoiaba, "arovre de Goiaba");
				
				if(qtdArvoreLaranjaInvalido || qtdArvoreAbacateInvalido || qtdArvoreCocoInvalido 
					|| qtdArvoreAcerolanvalido || qtdArvoreAmoranvalido || qtdArvoreGoiabaInvalido) {
					
					return;
				}
				
				//Frutas no chao
				
				controlador.alocaFrutaNoChao(qtdLaranjaNoChao,cenario);
				controlador.alocaFrutaNoChao(qtdAbacateNoChao,cenario);
				controlador.alocaFrutaNoChao(qtdCocoNoChao,cenario);
				controlador.alocaFrutaNoChao(qtdAcerolaNoChao,cenario);
				controlador.alocaFrutaNoChao(qtdAmoraNoChao,cenario);
				controlador.alocaFrutaNoChao(qtdGoiabaNoChao,cenario);
				
				boolean qtdFrutaLaranjaInvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdLaranjaNoChao, "fruta de laranja");
				boolean qtdFrutaAbacateInvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdAbacateNoChao, "fruta de abacate");
				boolean qtdFrutaCocoInvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdCocoNoChao, "fruta de Coco");
				boolean qtdFrutaAcerolanvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdAcerolaNoChao, "fruta de Acerola");
				boolean qtdFrutaAmoranvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdAmoraNoChao, "fruta de Amora");
				boolean qtdFrutaGoiabaInvalido = controlador.tratamentoErroElementos(tamanhoCenario, qtdGoiabaNoChao, "fruta de Goiaba");
				
				if(qtdFrutaLaranjaInvalido || qtdFrutaAbacateInvalido || qtdFrutaCocoInvalido 
					|| qtdFrutaAcerolanvalido || qtdFrutaAmoranvalido || qtdFrutaGoiabaInvalido) {
					
					return;
				}
	
				
				/**
				 * Escrita do arquivo, pegando cada input e escrevendo no arquivo.
				 * 
				 */
				
				/**
				 * Guarda em uma variável o caminho do arquivo
				 */
				
				/**
				 * Passa pro try o escritor que guarda o arquivo com a intancia de new FileWriter(caminhoArquivo)) 
				 * passsando o caminho do arquivo
				 */
				
				
				try(BufferedWriter escritor = new BufferedWriter( new FileWriter(caminhoArquivo))) {
		    		
		    		escritor.write(String.format("Nome do jogador 1: %s \n", nomeJogador1));
		    		
		    		escritor.write("\n");
		    		
		    		escritor.write(String.format("Nome do jogador 2: %s \n", nomeJogador2));
		    		
		    		escritor.write("\n");
		    		
		    		escritor.write(String.format("Capacidade da mochila: %d \n", capacidadeMochila));
		    		
		    		escritor.write(" \n");
		    		
		    		escritor.write(String.format("Tamanho do cenário: " + tamanhoCenario + "\n"));
		    		
		    		escritor.write("\n");
		    		
		    		escritor.write(String.format("Quantidade de pedra: \n" + quantidadePedra + "\n"));
		    		
		    		escritor.write("\n");
		    		
		    		escritor.write(String.format("Probabilidade de fruta bixada: %d \n", probabilidadeBichada));
		    		
		    		escritor.write(" \n");
		    		
		    		escritor.write(String.format("Quantidade de arvores de laranja: %d\n", qtdArvoreLaranja));
		    		escritor.write(String.format("Quantidade de laranjas no chão: %d \n", qtdLaranjaNoChao));
		    		
		    		escritor.write("\n");
		    		
		    		escritor.write(String.format("Quantidade de arvores de abacate: %d \n", qtdArvoreAbacate));
		    		escritor.write(String.format("Quantidade de abacates no chão:  %d \n",qtdAbacateNoChao));
		    		
		    		escritor.write("\n");
		    		
		    		escritor.write(String.format("Quantidade de arvores de coco: %d \n", qtdArvoreCoco));
		    		escritor.write(String.format("Quantidade de cocos no chão:  %d \n", qtdCocoNoChao));
		    		
		    		escritor.write("\n");
		    		
		    		escritor.write(String.format("Quantidade de arvores de acerola: %d \n", qtdArvoreAcerola));
		    		escritor.write(String.format("Quantidade de acerolas no chão: %d \n", qtdAcerolaNoChao));
		    		
		    		escritor.write("\n");
		    		
		    		escritor.write(String.format("Quantidade de arvores de amora: %d \n", qtdArvoreAmora));
		    		escritor.write(String.format("Quantidade de amoras no chão:  %d \n", qtdAmoraNoChao));

		    		escritor.write(" \n");
		    		
		    		escritor.write(String.format("Quantidade de arvores de goiaba: %d \n", qtdArvoreGoiaba));
		    		escritor.write(String.format("Quantidade de goiabas no chão:  %d \n", qtdGoiabaNoChao));
	
		    		escritor.write(" \n");

		    		escritor.write(String.format("Quantidade de arvores de maracuja: %d \n", qtdMaracujaEmArvore));
		    		escritor.write(String.format("Quantidade de maracujas no chão:  %d \n", qtdMaracujaNoChao));
		    		
		    	} catch(Exception erro) {
		    		
		    		System.out.println("Erro ao escrever no arquivo!! \n\n");
		    		erro.printStackTrace();
		    	}
				
				leituriaEscrita.lerArquivo();
					
				/**
				 * Adminsitra a visibilidade das telas.	
				 */

				painelCenario.setVisible(false);
				painelJogadores.setVisible(false);
				botaoConfigurar.setVisible(true);
				botaoJogar.setVisible(true);
				
				JOptionPane.showMessageDialog(null, "Configuração realizada com sucesso!");

			}	
		});
		
		
		/**
		 * Botão que cuidam também da visibilidade dos paineis de acordo com os
		 * paineis que ele devem mostrar e esconder.
		 */
		botaoConfigurar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				botaoConfigurar.setVisible(false);
				botaoJogar.setVisible(false);
				painelCarregarCenario.setVisible(true);
			//	painelJogadores.setVisible(true);
					
			}
			
		});
		
		botaoCarregarArquivo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
		        JFileChooser fileChooser = new JFileChooser();		  
		        fileChooser.setDialogTitle("Selecione um arquivo de configuração");

		        int resposta = fileChooser.showOpenDialog(null);

		        if (resposta == JFileChooser.APPROVE_OPTION) {
		        	
		            File arquivoSelecionado = fileChooser.getSelectedFile();
		            
		            System.out.println("Arquivo selecionado: " + arquivoSelecionado.getAbsolutePath() + "\n");


		            caminhoArquivo = arquivoSelecionado.getAbsolutePath(); 
		            
		        //  LeituraEscritaArquivo readerArq = new LeituraEscritaArquivo(caminhoArquivo); 
		            leituriaEscrita.lerArquivo();
		            
		            JOptionPane.showMessageDialog(null, "Arquivo carregado com sucesso!! ");
		            
		        }
		        
		        painelCarregarCenario.setVisible(false);
		        botaoConfigurar.setVisible(true);
				botaoJogar.setVisible(true);	
			}
		});
		
		
		
		botaoNovoCenario.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				painelCarregarCenario.setVisible(false);
				painelJogadores.setVisible(true);
			}
		});
		
		
		
		botaoContinuarConfigJogo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String nomeJogador1 = inputJogador1.getText();
				String nomeJogador2 = inputJogador2.getText();
				int capacidadeMochila = Integer.parseInt(inputMochila.getText());
				
				jogador1.setNome(nomeJogador1);
				jogador2.setNome(nomeJogador2);
				
				mochila1.setCapacidadeMaxima(capacidadeMochila);
				mochila2.setCapacidadeMaxima(capacidadeMochila);
				
				jogador1.setMochila(mochila1);
				jogador1.setMochila(mochila2);
				
				painelJogadores.setVisible(false);
				painelCenario.setVisible(true);
				
			}
			
		});
		
		
		botaoVoltarCarregarCenario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				painelCarregarCenario.setVisible(true);
				painelJogadores.setVisible(false);
		//		botaoConfigurar.setVisible(true);
			//	botaoJogar.setVisible(true);
			}
			
		});
			
		botaoVoltarMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				painelCarregarCenario.setVisible(false);
				botaoConfigurar.setVisible(true);
				botaoJogar.setVisible(true);
			}
			
		});
		
		
		botaoVoltarConfigCenario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				painelJogadores.setVisible(true);
				painelCenario.setVisible(false);
			}
			
		});
		
		
		
		
		botaoEtapa2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dimensaoCenario = Integer.parseInt(inputTamanhoCenario.getText());
				int quantidadePedra = Integer.parseInt(inputQuantidadePedras.getText());
				
				boolean cenarioPequeno = controlador.tratamentoErroCenario(dimensaoCenario);
				boolean elementosExcedente = controlador.tratamentoErroElementos(dimensaoCenario, quantidadePedra, "pedras");
				
				if(cenarioPequeno || elementosExcedente) {
					
					return;
				}
				
				cenario.novaDimensao(dimensaoCenario);
				cenario.novaQtdPedras(quantidadePedra);
				
				imagens.setTamanhoCenario(dimensaoCenario);
				
				BufferedImage[][] novaMatrizImagens = new BufferedImage[cenario.getDimensao()][cenario.getDimensao()];
				Solo[][] novaMatriz = new Solo[cenario.getDimensao()][cenario.getDimensao()];
				
				cenario.setSolo(novaMatriz);
				imagens.setMatrizImagens(novaMatrizImagens);
				
				
				System.out.println("Dimensão do cenário: " + cenario.getDimensao());
				System.out.println("Quantidade de pedras: " + cenario.getQtdPedra());
				
				System.out.println("\n");
				
				painelCenario.setBounds(456, 10, 555, 954);
				
				tamanhoCenario.setVisible(false);
				inputTamanhoCenario.setVisible(false);
				quantiadePedras.setVisible(false);
				inputQuantidadePedras.setVisible(false);
				
				textoBichada.setVisible(false);
				inputBichada.setVisible(false);
				
				botaoConfirmar.setVisible(false);
				botaoEtapa1.setVisible(false);

				
				botaoEtapa1.setVisible(true);
				
				textoArvores.setVisible(true);
				textoFrutasNoChao.setVisible(true);
				
				textoLaranja.setVisible(true);
				inputQtdArvoreLaranja.setVisible(true);
				inputQtdLaranjaNoChao.setVisible(true);
				
				textoAbacate.setVisible(true);
				inputQtdArvoreAbacate.setVisible(true);
				inputQtdAbacateNoChao.setVisible(true);
				
				textoCoco.setVisible(true);
				inputQtdArvoreCoco.setVisible(true);
				inputQtdCocoNoChao.setVisible(true);
				
				textoAcerola.setVisible(true);
				inputQtdArvoreAcerola.setVisible(true);
				inputQtdAcerolaNoChao.setVisible(true);
				
				textoAmora.setVisible(true);
				inputQtdArvoreAmora.setVisible(true);
				inputQtdAmoraNoChao.setVisible(true);
				
				textoGoiaba.setVisible(true);
				inputQtdArvoreGoiaba.setVisible(true);
				inputQtdGoiabaNoChao.setVisible(true);
				
				textoMaracuja.setVisible(true);
				inputQtdMaracujaArvore.setVisible(true);
				inputMaracujaNoChao.setVisible(true);
				
				
				botaoVoltarConfigCenario.setBounds(59, 880, 150, 30);
				botaoConfirmar.setVisible(true);
				botaoVoltarConfigCenario.setBounds(28, 742, 150, 30);	
			
			}
		});
		
		
		botaoEtapa1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				tamanhoCenario.setVisible(true);
				inputTamanhoCenario.setVisible(true);
				
				quantiadePedras.setVisible(true);
				inputQuantidadePedras.setVisible(true);
				
				textoBichada.setVisible(true);
				inputBichada.setVisible(true);
				
				botaoConfirmar.setVisible(false);
				botaoEtapa1.setVisible(true);
				
				
				botaoEtapa1.setVisible(false);
				
				textoArvores.setVisible(false);
				textoFrutasNoChao.setVisible(false);
				
				textoLaranja.setVisible(false);
				inputQtdArvoreLaranja.setVisible(false);
				inputQtdLaranjaNoChao.setVisible(false);
				
				textoAbacate.setVisible(false);
				inputQtdArvoreAbacate.setVisible(false);
				inputQtdAbacateNoChao.setVisible(false);
				
				textoCoco.setVisible(false);
				inputQtdArvoreCoco.setVisible(false);
				inputQtdCocoNoChao.setVisible(false);
				
				textoAcerola.setVisible(false);
				inputQtdArvoreAcerola.setVisible(false);
				inputQtdAcerolaNoChao.setVisible(false);
				
				textoAmora.setVisible(false);
				inputQtdArvoreAmora.setVisible(false);
				inputQtdAmoraNoChao.setVisible(false);
				
				textoGoiaba.setVisible(false);
				inputQtdArvoreGoiaba.setVisible(false);
				inputQtdGoiabaNoChao.setVisible(false);
				
				textoMaracuja.setVisible(false);
				inputQtdMaracujaArvore.setVisible(false);
				inputMaracujaNoChao.setVisible(false);
				
				painelCenario.setBounds(456, 10, 555, 552);
				botaoVoltarConfigCenario.setBounds(28, 488, 150, 30);
				
			}
		});
	
	}

	public JTextField getInputJogador1() {
		return inputJogador1;
	}

	public void setInputJogador1(JTextField inputJogador1) {
		this.inputJogador1 = inputJogador1;
	}

	public JTextField getInputJogador2() {
		return inputJogador2;
	}

	public void setInputJogador2(JTextField inputJogador2) {
		this.inputJogador2 = inputJogador2;
	}

	public JTextField getInputMochila() {
		return inputMochila;
	}

	public void setInputMochila(JTextField inputMochila) {
		this.inputMochila = inputMochila;
	}

	public JTextField getInputTamanhoCenario() {
		return inputTamanhoCenario;
	}

	public void setInputTamanhoCenario(JTextField inputTamanhoCenario) {
		this.inputTamanhoCenario = inputTamanhoCenario;
	}

	public JTextField getInputQuantidadePedras() {
		return inputQuantidadePedras;
	}

	public void setInputQuantidadePedras(JTextField inputQuantidadePedras) {
		this.inputQuantidadePedras = inputQuantidadePedras;
	}

	public JTextField getInputQtdArvoreLaranja() {
		return inputQtdArvoreLaranja;
	}

	public void setInputQtdArvoreLaranja(JTextField inputQtdArvoreLaranja) {
		this.inputQtdArvoreLaranja = inputQtdArvoreLaranja;
	}

	public JTextField getInputQtdLaranjaNoChao() {
		return inputQtdLaranjaNoChao;
	}

	public void setInputQtdLaranjaNoChao(JTextField inputQtdLaranjaNoChao) {
		this.inputQtdLaranjaNoChao = inputQtdLaranjaNoChao;
	}

	public JTextField getInputQtdArvoreAbacate() {
		return inputQtdArvoreAbacate;
	}

	public void setInputQtdArvoreAbacate(JTextField inputQtdArvoreAbacate) {
		this.inputQtdArvoreAbacate = inputQtdArvoreAbacate;
	}

	public JTextField getInputQtdAbacateNoChao() {
		return inputQtdAbacateNoChao;
	}

	public void setInputQtdAbacateNoChao(JTextField inputQtdAbacateNoChao) {
		this.inputQtdAbacateNoChao = inputQtdAbacateNoChao;
	}

	public JTextField getInputQtdArvoreCoco() {
		return inputQtdArvoreCoco;
	}

	public void setInputQtdArvoreCoco(JTextField inputQtdArvoreCoco) {
		this.inputQtdArvoreCoco = inputQtdArvoreCoco;
	}

	public JTextField getInputQtdCocoNoChao() {
		return inputQtdCocoNoChao;
	}

	public void setInputQtdCocoNoChao(JTextField inputQtdCocoNoChao) {
		this.inputQtdCocoNoChao = inputQtdCocoNoChao;
	}

	public JTextField getInputQtdArvoreAcerola() {
		return inputQtdArvoreAcerola;
	}

	public void setInputQtdArvoreAcerola(JTextField inputQtdArvoreAcerola) {
		this.inputQtdArvoreAcerola = inputQtdArvoreAcerola;
	}

	public JTextField getInputQtdAcerolaNoChao() {
		return inputQtdAcerolaNoChao;
	}

	public void setInputQtdAcerolaNoChao(JTextField inputQtdAcerolaNoChao) {
		this.inputQtdAcerolaNoChao = inputQtdAcerolaNoChao;
	}

	public JTextField getInputQtdArvoreAmora() {
		return inputQtdArvoreAmora;
	}

	public void setInputQtdArvoreAmora(JTextField inputQtdArvoreAmora) {
		this.inputQtdArvoreAmora = inputQtdArvoreAmora;
	}

	public JTextField getInputQtdAmoraNoChao() {
		return inputQtdAmoraNoChao;
	}

	public void setInputQtdAmoraNoChao(JTextField inputQtdAmoraNoChao) {
		this.inputQtdAmoraNoChao = inputQtdAmoraNoChao;
	}

	public JTextField getInputQtdArvoreGoiaba() {
		return inputQtdArvoreGoiaba;
	}

	public void setInputQtdArvoreGoiaba(JTextField inputQtdArvoreGoiaba) {
		this.inputQtdArvoreGoiaba = inputQtdArvoreGoiaba;
	}

	public JTextField getInputQtdGoiabaNoChao() {
		return inputQtdGoiabaNoChao;
	}

	public void setInputQtdGoiabaNoChao(JTextField inputQtdGoiabaNoChao) {
		this.inputQtdGoiabaNoChao = inputQtdGoiabaNoChao;
	}

	public JTextField getInputQtdMaracujaArvore() {
		return inputQtdMaracujaArvore;
	}

	public void setInputQtdMaracujaArvore(JTextField inputQtdMaracujaArvore) {
		this.inputQtdMaracujaArvore = inputQtdMaracujaArvore;
	}

	public JTextField getInputMaracujaNoChao() {
		return inputMaracujaNoChao;
	}

	public void setInputMaracujaNoChao(JTextField inputMaracujaNoChao) {
		this.inputMaracujaNoChao = inputMaracujaNoChao;
	}

	public JTextField getInputBichada() {
		return inputBichada;
	}

	public void setInputBichada(JTextField inputBichada) {
		this.inputBichada = inputBichada;
	}
	
	
}
