package default_package;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Character character;
	ArrayList<Obstacles> obstacles = new ArrayList<Obstacles>();
	// Obstacles obstacle;

	ObjectManager(Character character) {
		this.character = character;
		// this.obstacle = obstacle;
	}

	void update() {
		character.update();
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}
	}

	void draw(Graphics g) {
		character.draw(g);
	}
}
