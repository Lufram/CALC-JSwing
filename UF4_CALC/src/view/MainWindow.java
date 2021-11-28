package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controler.EventManager;

public class MainWindow extends JFrame {
	
	// Simbolos para los botones
	private String[] symbols = {
			"AC", " √ ", " ∛ ", "÷",
			"7","8","9","x",
			"4","5","6","-",
			"1","2","3","+",
			"0",".","=",
	};
	
	// Variables
	public int operator = 0;
	public double firstNum = 0, secondNum = 0;
	public String condicion = "vacio";
	
	// Paneles
	private JPanel panel = new JPanel(new GridBagLayout());
	private JTextField screen = new JTextField();
	private JPanel btnPanel = new JPanel(new GridBagLayout());
	private JButton[] btns = new JButton[19];

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
		// Logo calculadora
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/calcIcon.jpg"));
		// Visibilidad -- colocar la ultima
		setVisible(true);
	
	}
	
	// Inicia los componentes
	private void initComponents() {
		// Propiedades del panel principal
		// Asigna las propiedades a los paneles
		panel.setBackground(Color.decode("#353535"));
		// Propiedades del panel donde se escribiran los numero de la calculadora
		// Color y fuente del texto
		screen.setForeground(Color.WHITE);
		// Opacidad
		screen.setOpaque(false);
		screen.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		screen.setHorizontalAlignment(SwingConstants.RIGHT);
		// Tipografia y tamaño de letra
		screen.setFont(new Font("Roboto", Font.BOLD, 40));
		screen.setEditable(false);
		// Propieades del panel contenedor de botones
		// Opacidad
		btnPanel.setOpaque(false);
	
		//Variables que utilizaremos para generar los botones y su colocacion
				int colCont = 0;
				int lineCont = 0;
				
		// Bucle que crea un boton por cada simbolo del array
		for (int i = 0; i < btns.length ; i++) {
			// Crea un boton
			btns[i] = new JButton(symbols[i]);
			// Opacidad
			btns[i].setOpaque(true);
			// Sin borde
			btns[i].setBorderPainted(false);
			if (symbols[i] == "AC" | symbols[i] == " C " | symbols[i] == " √ " | symbols[i] == " ∛ " ){
				// Color de fondo
				btns[i].setBackground(Color.decode("#949392"));
				// Contenido en blanco
				btns[i].setForeground(Color.WHITE);
				
				btns[i].setFont(new Font("Roboto", Font.ROMAN_BASELINE, 20));
				
			}else if (symbols[i] == "÷" | symbols[i] == "x" | symbols[i] == "-" | symbols[i] == "+" | symbols[i] == "=" ) {
				// Color de fondo
				btns[i].setBackground(Color.decode("#e47608"));
				// Contenido en blanco
				btns[i].setForeground(Color.WHITE);
				btns[i].setFont(new Font("Roboto", Font.ROMAN_BASELINE, 30));
			}else {
				btns[i].setBackground(Color.decode("#d1d1d1"));
				// Contenido en negro
				btns[i].setForeground(Color.BLACK);
				btns[i].setFont(new Font("Roboto", Font.ROMAN_BASELINE, 25));
			}
		
			// Añade un listener al boton
			btns[i].addActionListener(new EventManager(this));
			btns[i].setFocusable(false);
			
			
			// Propiedades comunes	para gid bag
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(0,0,1,1);
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.weighty = 1;
			
			c.gridx = colCont;
			c.gridy = lineCont;
			c.gridheight = 1;
			
			// Tamaño mas grande para el boton del 0
			if (colCont == 0 & lineCont == 4) { 
				c.gridwidth = 2;
				colCont++;
			} else {
				c.gridwidth = 1;
			}
			colCont++;
			//Reinicia a 0 la columna y salta de linea
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
		// Asigna la gerarquia de los elementos
		f.weighty = 4;
		panel.add(screen, f);
		f.gridy = 1;
		f.weighty = 14;
		panel.add(btnPanel, f);
		
		add(panel);
		
	}


	public String[] getSymbols() {
		return symbols;
	}

	public void setSymbols(String[] symbols) {
		this.symbols = symbols;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JTextField getScreen() {
		return screen;
	}

	public void setScreen(JTextField screen) {
		this.screen = screen;
	}

	public JPanel getBtnPanel() {
		return btnPanel;
	}

	public void setBtnPanel(JPanel btnPanel) {
		this.btnPanel = btnPanel;
	}

	public JButton[] getBtns() {
		return btns;
	}

	public JButton getBtns(int position) {
		return btns[position];
	}
	
	public void setBtns(JButton[] btns) {
		this.btns = btns;
	}
	
	
}

