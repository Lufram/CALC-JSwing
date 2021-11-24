package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainWindow;

public class EventManager implements ActionListener{
	
	private MainWindow window;
	
	public EventManager(MainWindow window) {
		super();
		this.window = window;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand().toString();

		switch (cmd) {
			
			case ".":
				if (!window.screen.getText().contains(".")){
					addSymbol(".");
				}
				break;

			case "0": addSymbol("0");
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

			case "X":addOperator("X");
				break;
				
			case "-":addOperator("-");
				break;

			case "+":addOperator("+");
				break;
			
			case "%":
				double num = Double.parseDouble(window.screen.getText().toString());
				

			case "+/-":
				break;

			case "AC":
				window.screen.setText("");
				window.firstNum = 0;
				window.secondNum = 0;
				window.operator = 0;
				break;
				
		
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
			// Reiniciamos las variables
			window.secondNum = 0;
			window.operator = 0;
			// Mostramos el resultado y lo mantenemos como primer valor de la siguiente operacion
			window.screen.setText(Double.toString(window.firstNum));
		
		}
	}
	
	// Añade numeros al texto
	public void addSymbol(String symbol) {
		// Añadimos el numero 
		window.screen.setText(window.screen.getText() + symbol);
	}
	
	
	public void addOperator(String symbol) {
		
		if (!window.screen.getText().isEmpty()){
			
			if (window.firstNum == 0){
				window.firstNum = Double.parseDouble(window.screen.getText().toString());
				window.screen.setText("");
			}else {
				window.secondNum = Double.parseDouble(window.screen.getText().toString());
				calc();
				window.screen.setText(Double.toString(window.firstNum));
			}
			
			switch(symbol) {
			case "÷": window.operator = 1;
				break;
			case "X": window.operator = 2;
				break;
			case "-": window.operator = 3;
				break;
			case "+": window.operator = 4;
				break;
			}
			
			
		}
	}
}
