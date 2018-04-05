package pol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class GUI {
Polinom pol1=new Polinom();
Polinom pol2=new Polinom();

	
private JFrame Frame;

private JButton BAdunare;
private JButton BScadere;
private JButton BInmultire;
private JButton BImpartire;
private JButton BDerivare;
private JButton BIntegrare;
private JButton BClear;

private JTextField Polinom1;
private JTextField Polinom2;
private JTextField Rezultat;

public GUI() {
	Frame = new JFrame("Calculator polinoame");
	Frame.setVisible(true);
	Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Frame.setSize(600, 500);
	
	BAdunare = new JButton("+");
	BScadere = new JButton("-");
	BInmultire = new JButton("*");
	BImpartire = new JButton("/");
	BDerivare = new JButton("Derivare");
	BIntegrare = new JButton("Integrare");
	BClear = new JButton("CLEAR");
	
	Polinom1 = new JTextField("Introduceti primul polinom:");
	Polinom2 = new JTextField("Introduceti al doilea polinom:");
	Rezultat = new JTextField("Rezultatul operatiei este:");
	
	Frame.add(BAdunare);
	Frame.add(BScadere);
	Frame.add(BInmultire);
	Frame.add(BImpartire);
	Frame.add(BDerivare);
	Frame.add(BIntegrare);
	Frame.add(BClear);
	Frame.add(Polinom1);
	Frame.add(Polinom2);
	Frame.add(Rezultat);
	
	Polinom1.setBounds(50, 50, 500, 25);
	Polinom2.setBounds(50, 90, 500, 25);
	BAdunare.setBounds(50, 140, 60, 60);
	BScadere.setBounds(120, 140, 60, 60);
	BInmultire.setBounds(50, 210, 60, 60);
	BImpartire.setBounds(120, 210, 60, 60);
	BDerivare.setBounds(190, 140, 200, 60);
	BIntegrare.setBounds(190, 210, 200, 60);
	BClear.setBounds(400, 140, 100, 130);
	Rezultat.setBounds(50, 290, 500, 25);
	
	BAdunare.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String p1;
		String p2;
		
		p1=Polinom1.getText();
		p2=Polinom2.getText();
		
		pol1.parse(p1);
		pol2.parse(p2);
		
		Rezultat.setText(pol1.adunarePolinom(pol2).toStringP());
		}
	});
	
	BScadere.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String p1;
		String p2;
		
		p1=Polinom1.getText();
		p2=Polinom2.getText();
		
		pol1.parse(p1);
		pol2.parse(p2);
		
		Rezultat.setText(pol1.scaderePolinom(pol2).toStringP());
		}
	});
	BInmultire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String p1;
		String p2;
		
		p1=Polinom1.getText();
		p2=Polinom2.getText();
		
		pol1.parse(p1);
		pol2.parse(p2);
		
		Rezultat.setText(pol1.inmultirePolinom(pol2).toStringP());
		}
	});

	BClear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Polinom1.setText("");
		Polinom2.setText("");
		Rezultat.setText("");
		}
	});
	BDerivare.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String p1;
		
		p1=Polinom1.getText();
		
		pol1.parse(p1);
		
		Rezultat.setText(pol1.derivarePolinom().toStringP());
		}
	});
	BIntegrare.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String p1;
		
		p1=Polinom1.getText();
		
		pol1.parse(p1);
		
		Rezultat.setText(pol1.integrarePolinom().toStringP());
		}
	});

}
}
