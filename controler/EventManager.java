package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainWindow;

public class EventManager implements ActionListener{
	
	private MainWindow window;
	
	public EventManager(MainWindow window) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*String cmd = e.getActionCommand().toString();

		switch (cmd) {
			
			case ".":
				if (!window.getText().contains(".")){

					window.getText(window.getText() + ".");
				}
				break;

			case "0":
				window.getText(window.getText() + "0");
				break;

			case "1":
				window.getText(window.getText() + "1");
				break;

			case "2":
				window.getText(window.getText() + "2");
				break;

			case "3":
				window.getText(window.getText() + "3");
				break;

			case "4":
				window.getText(window.getText() + "4");
				break;

			case "5":
				window.getText(window.getText() + "5");
				break;

			case "6":
				window.getText(window.getText() + "6");
				break;

			case "7":
				window.getText(window.getText() + "7");
				break;

			case "8":
				window.getText(window.getText() + "8");
				break;

			case "9":
				window.getText(window.getText() + "9");
				break;

			case "4":
				window.getText(window.getText() + "0");
				break;

			case "+":
				if (!window.getText().isEmpty()){
					
					firstNum = Doble.parseDouble(window.getText().toString());
					operator = 1;
					window.setText("");

				}
				break;

			case "%":
				double num = Double.parseDouble(window.getText().toString());
				window.setText(String.valueOf(num/100.0));
				break;

			case "+/-":

				
				break;

			case "AC":
				window.setText("");
				break;
				
		


				*/


		}
		
	

}
