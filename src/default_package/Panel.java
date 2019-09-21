package default_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import keybinds.Keybind;
import keybinds.KeybindPanel;

public class Panel extends JPanel implements KeyListener, ActionListener, MouseListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int PAUSE_STATE = 3;
	int currentState = MENU_STATE;
	Timer timer;
	Font font;
	Font font2;
	Font Title;
	Font Subtitle;
	Keybind keybind = new Keybind();
	KeybindPanel keybindPanel = new KeybindPanel();
	GamePanel gamePanel;

	Panel() {
		timer = new Timer(1000 / 60, this);
		font = new Font("Arial", Font.BOLD, 36);
		Title = new Font("Times New Roman", Font.BOLD, 65);
		Subtitle = new Font("Times New Roman", Font.PLAIN, 24);
		gamePanel = new GamePanel();
	}

	void startGame() {
		timer.start();
	}

	void drawPauseScreen(Graphics g) {

		g.setColor(Color.BLACK);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Paused", 175, 350);

	}

	void drawMenuScreen(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 500, 900);
		g.setColor(Color.BLACK);
		g.setFont(Title);
		g.drawString("Welcome", 110, 200);
		g.setFont(Subtitle);
		g.drawString("Press ENTER To Start", 135, 425);
		g.drawString("Press SPACE For Instructions", 100, 650);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentState == PAUSE_STATE) {
			drawPauseScreen(g);
			rectangles(g);

		}
		if (currentState == MENU_STATE) {
			drawMenuScreen(g);
		}
		if (currentState == GAME_STATE) {
			gamePanel.paintComponemt(g);
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
			if (currentState == GAME_STATE) {
				currentState = PAUSE_STATE;
			} else if (currentState == PAUSE_STATE) {
				currentState = GAME_STATE;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU_STATE) {
				JOptionPane.showMessageDialog(null,
						"Use whatever key you programmed to move left and right, and avoid the blockings. ",
						"Instructions", 0, null);
			}
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

	void rectangles(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 75, 25);
		g.setColor(Color.black);
		g.drawRect(0, 0, 75, 25);
		font2 = new Font("Arial", Font.PLAIN, 14);
		g.setFont(font2);
		g.drawString("Keybinds", 10, 17);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		if (e.getButton() == MouseEvent.BUTTON1 && currentState == PAUSE_STATE) {
			if (e.getPoint().x < 100 && e.getPoint().y < 50) {
				keybind.setup();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
