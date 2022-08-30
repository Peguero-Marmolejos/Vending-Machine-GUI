import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Display extends JPanel {
	private JTextArea display;
	
	
	public Display() {
		display = new JTextArea();
		display.setBackground(Color.pink);
		setLayout(new BorderLayout());
		add(display, BorderLayout.CENTER);
	}
	
	public void clear() {
		display.setText("");
	}
	
	public void appendText(String a) {
		display.append(a);
	}
	
	public void setEditable(boolean a) {
			display.setEditable(a);
	}
	
	public String getData() {
		return display.getText();
	}
	public void setColor(Color c) {
		display.setBackground(c);
	}
	public String printCoins(double c) {
       	int coins = (int)(c*100);
       	int doll = coins/100;
       	coins%=100;
       	int quarters = coins / 25;
       	coins %= 25;
       	int dimes = coins / 10;
       	coins %= 10;
       	int nickels = coins / 5;
       	coins %= 5;
       	return "\nDollars : "+  doll + "\nQuarters : " +  quarters + "\nDimes : " + dimes + "\nNickels : " + nickels;
    }  	
}
