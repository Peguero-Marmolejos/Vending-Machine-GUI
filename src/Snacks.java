import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Snacks extends JPanel {
	private JLabel [][] labels = new JLabel [4][4];
	private ImageIcon [][]icons = new ImageIcon[4][4];
	private GridLayout gridlayout;

	private final HashMap <String, String> hm;
	
	public Snacks() {
		
		
		
		gridlayout = new GridLayout(4,4);
		setLayout(gridlayout);
		
		hm = new HashMap <String, String>();
		
		icons[0][0] = new ImageIcon("rasins.jpeg");
		icons[0][1] = new ImageIcon("peanuts.jpg");
		icons[0][2] = new ImageIcon("fruit_snack.png");
		icons[0][3] = new ImageIcon("chewing_gum.jpg");
		
		icons[1][0] = new ImageIcon("chips.jpg");
		icons[1][1] = new ImageIcon("pretzels.jpg");
		icons[1][2] = new ImageIcon("cookies.jpg");
		icons[1][3] = new ImageIcon("onion_rings.jpg");
		
		icons[2][0] = new ImageIcon("water.jpg");
		icons[2][1] = new ImageIcon("soda.png");
		icons[2][2] = new ImageIcon("coffee.jpg");
		icons[2][3] = new ImageIcon("energy_drink.jpg");
		
		icons[3][0] = new ImageIcon("chocolate_bar.jpg");
		icons[3][1] = new ImageIcon("protein_bar.png");
		icons[3][2] = new ImageIcon("trail_mix.jpg");
		icons[3][3] = new ImageIcon("nutter_butter.jpg");
		
		hm.put("A1", "RAISINS : 1.50");
		hm.put("A2", "PEANUTS : 2.25");
		hm.put("A3", "FRUIT SNACKS : 3.10");
		hm.put("A4", "CHEWING GUM : 1.20");
		hm.put("B1", "CHIPS : 1.55");
		hm.put("B2", "PRETZELS : 3.75");
		hm.put("B3", "COOKIES : 4.80");
		hm.put("B4", "ONION RINGS : 3.35");
		hm.put("C1", "WATER : 2.45");
		hm.put("C2", "SODA : 3.00");
		hm.put("C3", "COFFEE : 3.15");
		hm.put("C4", "ENERGY DRINK : 1.85");
		hm.put("D1", "CHOCOLATE BAR : 2.95");
		hm.put("D2", "PROTEIN BAR : 2.10");
		hm.put("D3", "TRAIL MIX : 4.30");
		hm.put("D4", "NUTTER BUTTER : 3.40");

		for(int i=0; i<4; i++) {
			for(int k=0; k<4; k++) {
				labels[i][k] = new JLabel();
				labels[i][k].setIcon(new ImageIcon(icons[i][k].getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
				add(labels[i][k]);
			}
		}
		
		labels[0][0].setText("A1");	//raisins");
		labels[0][1].setText("A2"); //peanuts");
		labels[0][2].setText("A3"); //fruit snacks");
		labels[0][3].setText("A4"); //chewing gum");
		labels[1][0].setText("B1"); //chips");
		labels[1][1].setText("B2"); //pretzels");
		labels[1][2].setText("B3"); //cookies");
		labels[1][3].setText("B4"); //onion rings");
		labels[2][0].setText("C1"); //water");
		labels[2][1].setText("C2"); //soda");
		labels[2][2].setText("C3"); //coffee");
		labels[2][3].setText("C4"); //energy drink");
		labels[3][0].setText("D1"); //chocolate bar");
		labels[3][1].setText("D2"); //protein bar");
		labels[3][2].setText("D3"); //trail mix");
		labels[3][3].setText("D4"); //nutter butter");
			
		for(int s = 0; s<4; s++) {
			for(int h = 0; h<4; h++) {
				labels[s][h].setVerticalTextPosition(JLabel.BOTTOM);
				labels[s][h].setHorizontalTextPosition(JLabel.CENTER);
			}
		}
	}
	
	public String getSnack(String key) {
		for(int s = 0; s<4; s++) {
			for(int h = 0; h<4; h++) {
				if(labels[s][h].getText().equals(key)) {
					Border border = BorderFactory.createLineBorder(Color.GREEN, 9);
					labels[s][h].setBorder(border);
				}
			}
		}
		return hm.get(key);
	}
	
	public void unhighLight() {
		for(int s = 0; s<4; s++) {
			for(int h = 0; h<4; h++) {
					Border border1 = BorderFactory.createEmptyBorder();
					labels[s][h].setBorder(border1);
			}
		}
	}
}

