package brickbreak;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gameplay game = new Gameplay();
		JFrame obj = new JFrame();
		obj.setBounds(10,10,700,600);
		obj.setTitle("Brick Breaker Game");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(game);

	}

}
