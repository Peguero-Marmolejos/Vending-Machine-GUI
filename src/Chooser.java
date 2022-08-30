import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Chooser extends JPanel implements ActionListener{

	private JButton [][] btnArray;
	private GridLayout row1;
	private StringListener textListener;

	
	public Chooser() {
		btnArray = new JButton[2][4];
		row1 = new GridLayout(2,4);
		
		btnArray [0][0] = new JButton("A");
		btnArray [0][1] = new JButton("B");
		btnArray [0][2] = new JButton("C");
		btnArray [0][3] = new JButton("D");
		btnArray [1][0] = new JButton("1");
		btnArray [1][1] = new JButton("2");
		btnArray [1][2] = new JButton("3");
		btnArray [1][3] = new JButton("4");
	
		setLayout(row1);
		for(int i = 0;i < 2; i++) {
			for(int j = 0; j < 4; j++) {
				 
				add(btnArray[i][j]);
				btnArray[i][j].addActionListener(this);
			}
		}
	}

	public void setStringListener(StringListener a) {
		textListener = a;
	}

	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		System.out.println(clicked.getText());
		
		switch(clicked.getText()) {
        case "A" :
        	textListener.textEmitted("A");
           break;
        case "B" :
        	textListener.textEmitted("B");
        	break;
        case "C" :
        	textListener.textEmitted("C");
        	break;
        case "D"  :
        	textListener.textEmitted("D");
        	break;
        case "1" :
        	textListener.textEmitted("1");	
        	break;
        case "2" :
        	textListener.textEmitted("2");
        	break;
        case "3" :
        	textListener.textEmitted("3");
        	break;
        case "4"  :
        	textListener.textEmitted("4");
        	break;
        default :
		  System.out.println("Invalid grade");
		}
     }
}