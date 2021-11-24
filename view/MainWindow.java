package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	
	private DecimalFormat df = new DecimalFormat ("#,###.00");
	
	// Simbolos para los botones
	private String[] symbols = {
			"AC", "+/-", "%", "÷",
			"7","8","9","X",
			"4","5","6","-",
			"1","2","3","+",
			"0",".","=",
	};
	
	public int operator = 0;
	
	private JPanel panel = new JPanel(new BorderLayout(5,5));
	private JPanel btnPanel = new JPanel(new GridLayout(5,3,2,2));
	private JButton[] btns = new JButton[19];
	public JTextArea screen = new JTextArea(5,40);
	
	public double firstNum = 0, secondNum = 0;
	
	private JTextField calculatingTf = new JTextField(40);
	
	
	
	public MainWindow() {
		
		
		panel.setBackground(Color.BLACK);
		btnPanel.setBackground(Color.BLACK);
		screen.setBackground(Color.BLACK);
		screen.setForeground(Color.WHITE);
		screen.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		// Bucle que crea un boton por cada simbolo
		for (int i = 0; i < btns.length ; i++) {
			// Crea un boton
			btns[i] = new JButton(symbols[i]);
			
			btns[i].setOpaque(false);
			// Sin borde
			btns[i].setBorderPainted(false);
			// Fondo negro
			btns[i].setBackground(Color.BLACK);
			// Contenido en blanco
			btns[i].setForeground(Color.WHITE);
			// Añade un listener al boton
			btns[i].addActionListener(new EventManager(this));
			// Añade el boton al panel
			btnPanel.add(btns[i]);
		
		}
		
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

