package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.MainWindow;

public class EventManager implements ActionListener{
	
	// Aqui almacenaremos la direccion en memoria de la ventana
	private MainWindow window;
	// Constructor
	public EventManager(MainWindow window) {
		super();
		this.window = window;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Boolean condicionBucle = true;
		// Almacena en un string el boton pulsado
		String cmd = e.getActionCommand().toString();
		// En funcion del valor del boton pulsado
		switch (cmd) {
			
			case ".":
				if (!window.screen.getText().contains(".")){
					addSymbol(".");
				}
				break;
  
			case "0": 
				if (window.screen.getText().toString() != "0"){
					addSymbol("0");
				}
				break;

			case "1": addSymbol("1");
				break;

			case "2": addSymbol("2");
				break;

			case "3": addSymbol("3");
				break;

			case "4": addSymbol("4");
				break;

			case "5": addSymbol("5");
				break;

			case "6": addSymbol("6");
				break;

			case "7": addSymbol("7");
				break;

			case "8": addSymbol("8");
				break;

			case "9": addSymbol("9");
				break;

			case "÷":addOperator("÷");
				break;

			case "x":addOperator("x");
				break;
				
			case "-":addOperator("-");
				break;

			case "+":addOperator("+");
				break;
			
			case "%":
				try {
					do {
					String input = JOptionPane.showInputDialog(window, "contrase�a", "Acceso", JOptionPane.QUESTION_MESSAGE);
					if(input.equals("contrase�a123")){
						JOptionPane.showMessageDialog(window, "contrase�a correcta", "Acceso permitido", JOptionPane.PLAIN_MESSAGE);
						condicionBucle = false;
						if(!window.screen.getText().isEmpty()) {
						double numero = Double.parseDouble(window.screen.getText().toString());
						double resultado = Math.cbrt(numero);
						window.screen.setText(Double.toString(resultado));
						window.condicion = "operado";
						}
					}else {
						JOptionPane.showMessageDialog(window, "Contrase�a incorrecta\nVuelve a intentarlo", "Acceso denegado", JOptionPane.PLAIN_MESSAGE);
					}
				}while(condicionBucle);
				} catch (NullPointerException e2) {
					
				}
				
			case "+/-":
				JOptionPane.showMessageDialog(window,"funcionalidad no disponible", "RaizCuadrada", JOptionPane.INFORMATION_MESSAGE);
				break;
			// Reinicia los valores de las variables	
			case "AC":
				window.screen.setText("");
				window.firstNum = 0;
				window.secondNum = 0;
				window.operator = 0;
				window.condicion = "vacio";
				break;
				
			// Calcula el resultado 
			case "=":
				calc();
				break;
	
		}

	}
	
	// Realiza la operacion matematica
	public void calc(){
		// Si el texto no esta vacio
		if (!window.screen.getText().isEmpty()){
			// Guarda en la variable secondNum el segundo numero para operar
			window.secondNum = Double.parseDouble(window.screen.getText().toString());
			// Realiza el calculo en funcion del operador que hemos introducido
			switch(Integer.toString(window.operator)){
				// Division
				case "1": window.firstNum = window.firstNum / window.secondNum;
					break;
				// Multiplicacion
				case "2": window.firstNum = window.firstNum * window.secondNum;
				// Resta
					break;
				case "3": window.firstNum = window.firstNum - window.secondNum;
				// Suma
					break;
				case "4": window.firstNum = window.firstNum + window.secondNum;
					break;
			}
			window.condicion = "operado";
			// Reiniciamos las variables
			window.secondNum = 0;
			window.operator = 0;
			// Mostramos el resultado y lo mantenemos como primer valor de la siguiente operacion
			window.screen.setText(Double.toString(window.firstNum));
		
		}
	}
	
	// Añade numeros al texto
	public void addSymbol(String symbol) {
		// Si ya hemos realizado una operacion previa
		if (window.condicion.equals("operado")) {
			// Reiniciamos la pantalla
			window.screen.setText("");
		}
		// Añadimos el numero
		if (window.screen.getText().toString() == "0") {
			window.screen.setText(symbol);
		} else {
			window.screen.setText(window.screen.getText() + symbol);
		}
		
		
	}
	
	// Añade un operador si ya hay un operador calcula el resultado y añade el operador despues
	public void addOperator(String symbol) {
		// Si el texto no esta vacio 
		if (!window.screen.getText().isEmpty()){
			// Si no se ha guardado el primer numero
			if (window.firstNum == 0){
				// Entonces almacena el valor del texto que hay en pantalla en la variable 1
				window.firstNum = Double.parseDouble(window.screen.getText().toString());
				// Vacia la pantalla
				window.screen.setText("");
			}else {
				// Si ya hay un numero en la variable entonces la almacena el la segunda
				window.secondNum = Double.parseDouble(window.screen.getText().toString());
				// calcula el resultado y el metodo almacenara el resultado en la variable firstNum
				calc();
			}
			// Una vez realizada la operacion asigna el valor del operador para la siguiente operacion
			switch(symbol) {
				case "÷": window.operator = 1;
					break;
				case "x": window.operator = 2;
					break;
				case "-": window.operator = 3;
					break;
				case "+": window.operator = 4;
					break;
			}
		
		}
	}
}
