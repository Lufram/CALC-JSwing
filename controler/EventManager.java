package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainWindow;

public class EventManager implements ActionListener{
	
	private MainWindow window;
	
	public EventManager(MainWindow window) {
		
	private String firstNum = null;
	private String secondNum = null;
	private int operator = 0;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand().toString();

		switch (cmd) {
			
			case ".":
				if (!screen.getText().contains(".")){

					screen.getText(screen.getText() + ".");
				}
				break;

			case "0":
				screen.getText(screen.getText() + "0");
				break;

			case "1":
				screen.getText(screen.getText() + "1");
				break;

			case "2":
				screen.getText(screen.getText() + "2");
				break;

			case "3":
				screen.getText(screen.getText() + "3");
				break;

			case "4":
				screen.getText(screen.getText() + "4");
				break;

			case "5":
				screen.getText(screen.getText() + "5");
				break;

			case "6":
				screen.getText(screen.getText() + "6");
				break;

			case "7":
				screen.getText(screen.getText() + "7");
				break;

			case "8": screen.getText(screen.getText() + "8");
				break;

			case "9": screen.getText(screen.getText() + "9");
				break;

				

				

			case "÷":
				if (!screen.getText().isEmpty()){
					
					if (firstNum == null){
						firstNum = Doble.parseDouble(screen.getText().toString());
						operator = 1;

					screen.getText(screen.getText() + " ÷ ");

					}else if(secondNum != null){
						// Resuelve la operacion y el resultado lo almacena en la variable
						firstNum = Doble.parseDouble(calc().toString());
						// Asigna suma al operador
						operator = 1;
						// Muestra el resultado 
						screen.setText(firstNum + " ÷ ");
					}
				}
				break;

			case "X":
				if (!screen.getText().isEmpty()){
					
					firstNum = Doble.parseDouble(screen.getText().toString());
					operator = 2;
					screen.setText("");

				}
				break;
			case "-":
				if (!screen.getText().isEmpty()){
					
					firstNum = Doble.parseDouble(screen.getText().toString());
					operator = 3;
					screen.setText("");

				}
				break;

			case "+":
				if (!screen.getText().isEmpty()){
					
					firstNum = Doble.parseDouble(screen.getText().toString());
					operator = 4;
					screen.setText("");

				}
				break;
			
			case "%":
				double num = Double.parseDouble(screen.getText().toString());
				screen.setText(String.valueOf(num/100.0));
				break;

			case "+/-":

				
				break;

			case "AC":
				screen.setText("");
				firstNum = null;
				secondNum = null;
				operator = 0;
				break;
				
		
			case "=":
				calc(Double firstNum, Double secondNum, int operator);
				break;

				


		}
		
	public string calc(){
			witch(operator){
					case "1": screen.setText(Float.toString(firstNum / secondNum));
					case "2": screen.setText(Float.toString(firstNum * secondNum));
					case "3": screen.setText(Float.toString(firstNum - secondNum));
					case "4": screen.setText(Float.toString(firstNum + secondNum));

				}

	}

}
