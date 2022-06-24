package main;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PassGenerate extends JFrame {
	
	JTextField phrase;

	JTextField strLength;
	JCheckBox isNumber;
	JCheckBox isUppercase;
	JButton button;
	
	Random rand;
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	String number = "0123456789";
	
	public PassGenerate() {
		
		rand = new Random();
		
		JPanel allPane = new JPanel();
		
		phrase = new JTextField();
		phrase.setEditable(false);

		JPanel bottomPane = new JPanel();
		bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.X_AXIS));
		
		strLength = new JTextField(5);
		isNumber = new JCheckBox("Num:");
		isUppercase = new JCheckBox("Upper:");
		button = new JButton("creating!");
		
		isNumber.setHorizontalTextPosition(JCheckBox.LEFT);
		isUppercase.setHorizontalTextPosition(JCheckBox.LEFT);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String len = strLength.getText();
				if (checkStringNumber(len)) {
					
					int passLength = Integer.parseInt(len);
					String pass = "";
					
					if (isNumber.isSelected()) {
						for (int i = 0; i < passLength; i++) {
							String piece;
							if (rand.nextInt(2) % 2 == 0) {
								piece = number.charAt(rand.nextInt(number.length())) + "";
							} else {
								piece = alphabet.charAt(rand.nextInt(alphabet.length())) + "";
								if (isUppercase.isSelected()) {
									if (rand.nextInt(2) % 2 == 0) {
										piece = piece.toUpperCase();
									}
								}
							}
							pass += piece;
						}
					} else {
						for (int i = 0; i < passLength; i++) {
							String piece;
							piece = alphabet.charAt(rand.nextInt(alphabet.length())) + "";
							if (isUppercase.isSelected()) {
								if (rand.nextInt(2) % 2 == 0) {
									piece = piece.toUpperCase();
								}
							}
							pass += piece;
						}
					}
					phrase.setText(pass);
					phrase.selectAll();
					phrase.copy();
				}
			}
		});
		
		bottomPane.add(strLength);
		bottomPane.add(isNumber);
		bottomPane.add(isUppercase);
		bottomPane.add(button);
		
		allPane.setLayout(new GridLayout(2, 1));
		allPane.add(phrase);
		allPane.add(bottomPane);
		
		getContentPane().add(allPane, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public boolean checkStringNumber(String number) {
		if (number.length() == 0) return false;
		
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(number);
		return m.find();
	}
	
	public static void main(String[] args) {
		new PassGenerate();
	}
}
