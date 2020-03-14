package default_package;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements KeyListener, ActionListener {

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int PAUSE_STATE = 3;
	final int INSTRUCTIONS = 4;
	int currentState = MENU_STATE;

	Timer timer;

	Font font;
	Font font2;
	Font Title;
	Font Subtitle;
	Font instructions;

	Character character = new Character(225, -750, 75, 75);
	Obstacles Obstacle = new Obstacles(100, 900, 100, 100);
	Obstacles obstacle1 = new Obstacles(100, 900, 100, 100);
	ObjectManager objectManager = new ObjectManager(character);

	public static BufferedImage spaceImg;
	public static BufferedImage characterImg;

	Panel() {
		timer = new Timer(1000 / 240, this);

		font = new Font("Arial", Font.BOLD, 36);
		Title = new Font("Times New Roman", Font.BOLD, 65);
		Subtitle = new Font("Times New Roman", Font.PLAIN, 24);
		instructions = new Font("Times New Roman", Font.PLAIN, 18);

		try {
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.jpeg"));
			characterImg = ImageIO.read(this.getClass().getResourceAsStream("character.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void startGame() {
		timer.start();
	}

	void updateGameState() {
		objectManager.update();
		objectManager.manageObstacles();
		objectManager.checkCollision();
		objectManager.purgeObjects();
		if (character.isAlive == false) {
			currentState = END_STATE;
		}
	}

	void drawPauseScreen(Graphics g) {

		g.setColor(Color.BLACK);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Paused", 175, 350);

	}

	void drawMenuScreen(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, DontDie.width, DontDie.height);
		g.setColor(Color.BLACK);
		g.setFont(Title);
		g.drawString("Welcome", 110, 200);
		g.setFont(Subtitle);
		g.drawString("Press ENTER To Start", 135, 425);
		g.drawString("Press SPACE For Instructions", 100, 650);

	}

	void drawGameScreen(Graphics g) {
		g.drawImage(spaceImg, 0, 0, DontDie.width, DontDie.height, null);
		objectManager.draw(g);
	}

	void drawEndScreen(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, DontDie.width, DontDie.height);
		g.setFont(Title);
		g.setColor(Color.WHITE);
		g.drawString("You Died", 100, 200);
		g.setFont(Subtitle);
		g.drawString("Score: " + objectManager.score, 200, 650);
	}

	void drawInstructionScreen(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, DontDie.width, DontDie.height);
		g.setColor(Color.BLACK);
		g.setFont(instructions);
		g.drawString("Use the arrow keys to move around", 120, 100);
		g.drawString("Your goal is to not hit the floating objects while falling down", 30, 300);
		g.drawString("If you hit the floating objects, you die", 110, 500);
		g.drawString("Good Luck", 195, 700);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentState == PAUSE_STATE) {
			drawPauseScreen(g);
		}
		if (currentState == MENU_STATE) {
			drawMenuScreen(g);
		}
		if (currentState == GAME_STATE) {
			drawGameScreen(g);
		}
		if (currentState == END_STATE) {
			drawEndScreen(g);
		}
		if (currentState == INSTRUCTIONS) {
			drawInstructionScreen(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState <= 2) {
				currentState++;
			}
			if (currentState == 3) {
				character = new Character(225, -750, 75, 75);
				objectManager = new ObjectManager(character);
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU_STATE) {
				currentState = INSTRUCTIONS;
			} else if (currentState == INSTRUCTIONS) {
				currentState = MENU_STATE;
			}
		}
		if (currentState == GAME_STATE) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				character.up = true;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				character.down = true;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				character.left = true;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				character.right = true;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (currentState == GAME_STATE) {
				currentState = PAUSE_STATE;
			} else if (currentState == PAUSE_STATE) {
				currentState = GAME_STATE;
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (currentState == GAME_STATE) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				character.up = false;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				character.down = false;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				character.left = false;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				character.right = false;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == GAME_STATE) {
			updateGameState();
		}
	}

}
