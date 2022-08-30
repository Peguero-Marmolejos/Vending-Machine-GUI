import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	private Snacks snacks;
	private Chooser selector;
	private Display display1;
	private Display display2;
	private JTextField money;
	private Display itemReceived;
	private JButton cancel;
	private JButton buy;
	private boolean on;
	private JLabel bills;
	private double moneyOwed = 0, moneyGiven = 0;
	
	
	public MainFrame() {
		super("Vending Machine Demo");
		setLayout(new BorderLayout());
		
		on = false;
		
		bills = new JLabel();
		snacks = new Snacks();
		selector = new Chooser();
		display1 = new Display();
		display2 = new Display();
		money = new JTextField();
		itemReceived = new Display();

		ImageIcon bill = new ImageIcon("money.jpg");
		bills.setIcon(new ImageIcon(bill.getImage().getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH)));
		 
		buy = new JButton("buy");
		cancel = new JButton("Cancel");
		
		setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.setPreferredSize(new Dimension (200, 400));
        p1.add(display1);
        p1.add(selector);
        p1.add(bills);
        p1.add(money);
        
        p1.add(buy);
        p1.add(cancel);
        p1.add(display2);
        
        display1.appendText("Make a Selection.");
        display1.setEditable(false);
        
        money.setEditable(false);
        money.setBackground(Color.GRAY);
        
        selector.setStringListener(new StringListener() {
			public void textEmitted(String b){
				if(on == false) {
					if(display1.getData().equals("Make a Selection.") || display1.getData().equals("ERROR INCORRECT SELECTION")) {
						display1.clear();
						display1.appendText(b);
					}
					else if(display1.getData().length()> 0 && display1.getData().length() < 2) {
						display1.appendText(b);
						this.read(display1.getData());
					}else {
						display1.clear();
						display1.appendText(b);
					}
				}
			}

			public void read(String a) {
				switch(a){
					case "A1" :
					case "1A" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("A1"));
						money.setText("");
						break;
					case "A2" :
					case "2A" :						
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("A2"));
						money.setText("");
						break;
					case "A3" :
					case "3A" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("A3"));
						money.setText("");
						break;
					case "A4" :
					case "4A" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("A4"));
						break;
					case "B1" :
					case "1B" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("B1"));
						break;
					case "B2" :
					case "2B" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("B2"));
						break;
					case "B3" :
					case "3B" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("B3"));
						break;
					case "B4" :
					case "4B" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("B4"));
						break;
					case "C1" :
					case "1C" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("C1"));
						break;
					case "C2" :
					case "2C" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("C2"));
						break;
					case "C3" :
					case "3C" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("C3"));
						break;
					case "C4" :
					case "4C" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("C4"));
						break;
					case "D1" :
					case "1D" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("D1"));
						break;
					case "D2" :
					case "2D" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("D2"));
						break;
					case "D3" :
					case "3D" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("D3"));
						break;
					case "D4" :
					case "4D" :
						snacks.unhighLight();
						display1.appendText(" " + snacks.getSnack("D4"));
						break;
					default:
						snacks.unhighLight();
						display1.clear();
						display1.appendText("ERROR INCORRECT SELECTION");
					}
				}
        });
		
        buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String f = display1.getData();
				String h = new String();
				if(f.equals("ERROR INCORRECT SELECTION") || f.equals("Make a Selection.") || f.equals("Hit cancel when done.")) {
					display1.clear();
					display1.appendText("Make a Selection.");
					
					display2.clear();
					itemReceived.clear();
					itemReceived.setColor(Color.pink);
					
					snacks.unhighLight();
					
					money.setBackground(Color.GRAY);
					money.setEditable(false);
				}else {
					on = true;
					h = f.substring(f.length()-4, f.length());
					display1.appendText("\nPlease Pay : " + h + " below:");
					moneyOwed = Double.parseDouble(h);
						
					money.setBackground(Color.WHITE);
					money.setEditable(true);
				}
			}	
		});
        
        cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				System.out.println(on);
				if(on == false) {
					moneyOwed = 0.0;
					moneyGiven = 0.0;
				
					display1.clear();
					display1.appendText("Make a Selection.");
				
					itemReceived.clear();
					itemReceived.setColor(Color.pink);
			
					snacks.unhighLight();
				
					money.setText("");
					money.setBackground(Color.GRAY);
					money.setEditable(false);
				
					display2.clear();
				}
				else {
					display2.appendText("Your change : " + String.format("%.2f",moneyGiven));
					display1.clear();
					display1.appendText("Hit cancel when done.");
					on = false;
				}
			}
		});
        
        money.addKeyListener(new KeyListener() {
        	public void keyPressed(KeyEvent ae) {
        		if(ae.getKeyCode()==KeyEvent.VK_ENTER) {
        			String input = money.getText();
        			on = true;
        			double mG = 0.00;
        			money.setText("");
        			System.out.println(input);
        			double j = 0.05;
        			if(moneyOwed>0) {
        				try {
        					mG = Double.parseDouble(input);
        					System.out.println(mG);
        					System.out.println((100*mG) );

        					if((mG > 5.0 || mG <0.05) || (mG*100) % 5 != 0) {
        						display1.appendText("\nWe do not accept less" + "\nthan a nickel or more than $5." + "\nWe do not accept pennies.");
        					}else {
        						moneyGiven+=mG;
        						moneyOwed-=moneyGiven;
        						display1.appendText("\nGIVEN: " + String.format("%.2f", moneyGiven));
        						display1.appendText("\nOWED:" + String.format("%.2f", moneyOwed));
        					}
               		 	}catch (NumberFormatException numberFormatException) {
               		 		switch(input.toUpperCase()) {
               		 		case "QTR" : 
               		 			moneyGiven += .25;
               		 			moneyOwed-=.25;
               		 			display1.appendText("\nGIVEN: " + String.format("%.2f", moneyGiven));
               		 			display1.appendText("\nOWED:" + String.format("%.2f", moneyOwed));
               		 			break;
               		 		case "DIME": 
               		 			moneyGiven += .10;
               		 			moneyOwed-=.10;
               		 			display1.appendText("\nGIVEN:" + String.format("%.2f", moneyGiven));
               		 			display1.appendText("\nOWED:" + String.format("%.2f", moneyOwed));
               		 			break;
               		 		case "NICKEL" : 
               		 			moneyGiven += .05;
               		 			moneyOwed-=.05;
               		 			display1.appendText("\nGIVEN:" + String.format("%.2f", moneyGiven));
               		 			display1.appendText("\nOWED:" + String.format("%.2f", moneyOwed));
               		 			break;
               		 		case "$1" : 
               		 			moneyGiven += 1.00;
               		 			moneyOwed-=1.00;
               		 			display1.appendText("\nGIVEN:" + String.format("%.2f", moneyGiven));
               		 			display1.appendText("\nOWED:" + String.format("%.2f", moneyOwed));
               		 			break;
               		 		case "$5" : 
               		 			moneyGiven += 5.00;
               		 			moneyOwed-=5.00;
               		 			display1.appendText("\nGIVEN:" + String.format("%.2f", moneyGiven));
               		 			display1.appendText("\nOWED:" + String.format("%.2f", moneyOwed));
               		 			break;
               		 		
               		 		default: display1.appendText("\nThat entry is unaccepted.");
               		 		}//switch
               		 	}//catch
        			}if(moneyOwed <= 0 ){
        				display2.appendText("Your change : " + String.format("%.2f", Math.abs(moneyOwed)));
        				display2.appendText(display2.printCoins(Math.abs(moneyOwed)));
        				itemReceived.appendText("Item Recieved");
        				itemReceived.setColor(Color.GREEN);
        				display1.clear();
        				display1.appendText("Hit cancel when done.");
        				money.setEditable(false);
        				money.setBackground(Color.GRAY);
        				on = false;
               		 }
        			
        		}
        	}
			public void keyReleased(KeyEvent arg1) {
			}
			public void keyTyped(KeyEvent arg0) {	
			}
        });
        
       
        
        this.add(p1, BorderLayout.EAST);
        this.add(itemReceived,BorderLayout.SOUTH);
        this.add(snacks, BorderLayout.CENTER);
		setVisible(true);			//makes it visible because its not visual by nature
		this.setResizable(false);	//Doesn't let window manager resize program
		this.setSize(900, 1000);	//size of jframe
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes 'X' end program
	}
}
