package brickbreak;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private boolean play = false;
	private int score = 0;
	private int brickTotal = 21;
	private Timer time;
	private int delay = 1;
	private int playerX = 310;
	private int playerY = 300;

	private int ballX = 120;
	private int ballY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;

	private MapGenerator map;

	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		time = new Timer(delay, this);
		time.start();
		map = new MapGenerator(3, 7);

	}

	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);

		// draw map
		map.drawBricks((Graphics2D) g);

		// borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		// scores
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("" + score, 590, 30);

		// peddle
		g.setColor(Color.red);
		g.fillRect(playerX, 550, 100, 8);

		// ball
		g.setColor(Color.white);
		g.fillOval(ballX, ballY, 20, 20);
		
		if(brickTotal<=0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("You Win! ", 260, 300);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press enter to restart", 230, 350);
			
		}

		if (ballY > 570) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over, Score: "+score, 190, 300);

			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press enter to restart", 230, 350);
		}
		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time.start();

		if (play) {
			if (new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 100))) {
				ballYdir = -ballYdir;
			}

			a: for (int i = 0; i < map.map.length; i++) {
				for (int j = 0; j < map.map[0].length; j++) {
					if (map.map[i][j] > 0) {
						int brickX = j * map.brickw + 80;
						int brickY = i * map.brickh + 50;
						int brickw = map.brickw;
						int brickh = map.brickh;

						Rectangle rect = new Rectangle(brickX, brickY, brickw, brickh);
						Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
						Rectangle brickr = rect;

						if (ballRect.intersects(brickr)) {
							map.setBrickVal(0, i, j);
							brickTotal--;
							score += 5;

							if (ballX + 19 <= brickr.x || ballX + 1 >= brickr.x + brickr.width) {
								ballXdir = -ballXdir;
							} else {
								ballYdir = -ballYdir;
							}
							break a;
						}
					}
				}
			}

			ballX += ballXdir;
			ballY += ballYdir;
			if (ballX < 0) {
				ballXdir = -ballXdir;
			}
			if (ballY < 0) {
				ballYdir = -ballYdir;
			}
			if (ballX > 670) {
				ballXdir = -ballXdir;
			}

		}
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (playerX >= 600) {
				playerX = 600;
			} else {
				moveRight();
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerX < 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!play) {
				play = true;
				ballX = 120;
				ballY = 350;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 310;
				score = 0;
				brickTotal = 21;
				map = new MapGenerator(3, 7);
				repaint();
			}
		}
	}

	public void moveRight() {
		play = true;
		playerX += 20;
	}

	public void moveLeft() {
		play = true;
		playerX -= 20;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
