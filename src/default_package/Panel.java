package default_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener, ActionListener {
	final int MENU_STATE = 0;
	final int PAUSE_STATE = 3;
	int currentState = MENU_STATE;
	Timer timer;
	Font font;
	

	Panel() {
		timer = new Timer(1000 / 60, this);
		font = new Font("Arial", Font.BOLD, 36);
		Button button = new Button();


	}

	void startGame() {
		timer.start();
	}

	void drawPauseScreen(Graphics g) {

		g.setColor(Color.BLACK);
		//g.fillRect(0, 0, Dropper.width, Dropper.height);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Paused", 175, 350);
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentState == PAUSE_STATE) {
			drawPauseScreen(g);
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			currentState = PAUSE_STATE;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}
