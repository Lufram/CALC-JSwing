package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
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
	
	// Variables
	public int operator = 0;
	public double firstNum = 0, secondNum = 0;
	
	// Paneles
	private JPanel panel = new JPanel(new BorderLayout(5,5));
	private JPanel btnPanel = new JPanel(new GridLayout(5,4,1,1));
	private JButton[] btns = new JButton[19];
	public JTextArea screen = new JTextArea(5,40);
	
	// Esto no me acuerdo para que era xDD
	private JTextField calculatingTf = new JTextField(40);
	
	
	// Constructor
	public MainWindow() {
		
		// asigna las propiedades a los paneles
		panel.setBackground(Color.decode("#353535"));
		btnPanel.setBackground(Color.decode("#353535"));
		screen.setBackground(Color.decode("#353535"));
		screen.setForeground(Color.WHITE);
		screen.setFont(new Font("Roboto", Font.BOLD, 25));
		
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
				
			}else if (symbols[i] == "÷" | symbols[i] == "x" | symbols[i] == "-" | symbols[i] == "+" ) {
				
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
			
			// Intento que el boton 0 ocupe 2 espacios
			GridBagConstraints c = new GridBagConstraints();
			c.gridwidth = 2;
			c.fill = GridBagConstraints.HORIZONTAL;
			// Añade el boton al panel
			if(symbols[i] == "0") {
				btnPanel.add(btns[i],c);
			}else {
				btnPanel.add(btns[i]);
			}
		}
		
		// Asigna la gerarquia de los elementos
		panel.add(calculatingTf, BorderLayout.SOUTH);
		panel.add(btnPanel, BorderLayout.CENTER);
		panel.add(screen, BorderLayout.NORTH);
		add(panel);
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
		// Visibilidad -- colocar la ultima
		setVisible(true);
	}
	

}

