package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controler.EventManager;

public class MainWindow extends JFrame {
	
	// Esto da algun formato a los decimales pero ni idea de como funciona xD
	private DecimalFormat df = new DecimalFormat ("#,###.00");
	
	// Simbolos para los botones
	private String[] symbols = {
			"AC", "+/-", "%", "÷",
			"7","8","9","x",
			"4","5","6","-",
			"1","2","3","+",
			"0",".","=",
	};
	
	private String[] pycto = {"x", "-", "+"};
	
	// Variables
	public int operator = 0;
	public double firstNum = 0, secondNum = 0;
	
	// Paneles
	private JPanel panel = new RoundPanel(new GridBagLayout(), 50, Color.decode("#353535"));
	
	private JPanel btnWPanel = new JPanel(new GridBagLayout());
	private JButton[] wBtns = new JButton[3];
	
	public JTextField screen = new JTextField(30);
	
	private JPanel btnPanel = new JPanel(new GridBagLayout());
	private JButton[] btns = new JButton[19];
	
	
	// Esto no me acuerdo para que era xDD
	//private JTextField calculatingTf = new JTextField(40);
	
	
	// Constructor
	public MainWindow() {
		// Tamaño de la ventana
		setSize(300,500);
		// Localizaon de la ventana
		setLocationRelativeTo(null);
		// Metodo de cierre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Evita que el usuario redimensione la ventana
		setResizable(false);
		// Asigna un titulo
		setTitle("Calculadora");
		// Iniciamos los componentes
		initComponents();
		// Sin decoracion
		//setUndecorated(true);
		// Fondo transparente
		//setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
		// Visibilidad -- colocar la ultima
		setVisible(true);
	}
	

	private void initComponents() {
		
		// Asigna las propiedades a los paneles
		panel.setBackground(Color.decode("#353535"));
		// Color y fuente del texto
		screen.setForeground(Color.WHITE);
		screen.setOpaque(false);
		screen.setFont(new Font("Roboto", Font.BOLD, 25));
		btnPanel.setOpaque(false);
		
		int colCont = 0;
		int lineCont = 0;
		
		for (int i = 0; i < wBtns.length ; i++) {
			// Crea un boton
			btns[i] = new JButton(symbols[i]);
			// Opacidad
			btns[i].setOpaque(true);
			
			btns[i].setFont(new Font("Roboto", Font.ROMAN_BASELINE, 25));
			// Añade un listener al boton
			btns[i].addActionListener(new EventManager(this));
			
			btns[i].setBackground(Color.decode("#e47608"));
			// Contenido en blanco
			btns[i].setForeground(Color.WHITE);
		}
		
		// Bucle que crea un boton por cada simbolo del array
		for (int i = 0; i < btns.length ; i++) {
			// Crea un boton
			btns[i] = new JButton(symbols[i]);
			// Opacidad
			btns[i].setOpaque(true);
			// Sin borde
			btns[i].setBorderPainted(false);
			if (symbols[i] == "AC" | symbols[i] == "+/-" | symbols[i] == "%" ){
				
				btns[i].setBackground(Color.decode("#949392"));
				// Contenido en blanco
				btns[i].setForeground(Color.WHITE);
				
			}else if (symbols[i] == "÷" | symbols[i] == "x" | symbols[i] == "-" | symbols[i] == "+" | symbols[i] == "=" ) {
				
				btns[i].setBackground(Color.decode("#e47608"));
				// Contenido en blanco
				btns[i].setForeground(Color.WHITE);
			}else {
				btns[i].setBackground(Color.decode("#d1d1d1"));
				// Contenido en negro
				btns[i].setForeground(Color.BLACK);
			}
			btns[i].setFont(new Font("Roboto", Font.ROMAN_BASELINE, 25));
			// Añade un listener al boton
			btns[i].addActionListener(new EventManager(this));
			
			// Propiedades comunes	
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(0,0,1,1);
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.0;
			c.weighty = 1.0;
			
			c.gridx = colCont;
			c.gridy = lineCont;
			c.gridheight = 1;
			if (colCont == 0 & lineCont == 4) { 
				c.gridwidth = 2;
				colCont++;
			} else {
				c.gridwidth = 1;
			}
			colCont++;
			if (colCont > 3) { colCont = 0; lineCont++;}
			
			
			// Añade el boton al panel
			btnPanel.add(btns[i],c);
		
		}
		
		GridBagConstraints f = new GridBagConstraints();
		f.insets = new Insets(0,0,1,1);
		f.fill = GridBagConstraints.BOTH;
		f.weightx = 0.2;
		f.weighty = 0.2;
		
		f.gridx = 0;
		f.gridy = 0;
		f.gridheight = 1;
		f.gridwidth = 1;
		// Asigna la gerarquia de los elementos
		panel.add(btnWPanel, f);
		f.gridy = 1;
		f.weighty = 4;
		panel.add(screen, f);
		//panel.add(calculatingTf, BorderLayout.SOUTH);
		f.gridy = 2;
		f.weighty = 6;
		panel.add(btnPanel, f);
		
		add(panel);
		
	}
	
}

