package default_package;

import java.awt.Graphics;

public class ObjectManager {
	Character character;
	// Obstacles obstacle;

	ObjectManager(Character character) {
		this.character = character;
		// this.obstacle = obstacle;
	}

	void update() {
		character.update();
	}

	void draw(Graphics g) {
		character.draw(g);
	}
}
