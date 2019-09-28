package default_package;

import java.awt.Graphics;

public class ObjectManager {
	Character character;

	ObjectManager(Character character) {
		this.character = character;
	}

	void update() {
		character.update();
	}

	void draw(Graphics g) {
		character.draw(g);
	}
}
