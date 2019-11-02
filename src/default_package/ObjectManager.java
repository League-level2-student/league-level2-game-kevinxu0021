package default_package;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Character character;
	ArrayList<Obstacles> obstacles = new ArrayList<Obstacles>();
	long obstacleTimer = 0;
	int obstacleSpawnTime = 1000;

	ObjectManager(Character character) {
		this.character = character;
	}

	void update() {
		character.update();
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}
	}

	void draw(Graphics g) {
		character.draw(g);
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
	}

	void addObstacles(Obstacles o) {
		obstacles.add(o);
	}

	void manageObstacles() {
		if (System.currentTimeMillis() - obstacleTimer >= obstacleSpawnTime) {
			addObstacles(new Obstacles(new Random().nextInt(Dropper.width), 0, 50, 50));

			obstacleTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).isAlive == false) {
				obstacles.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Obstacles o : obstacles) {
			if (character.collisionBox.intersects(o.collisionBox)) {
				character.isAlive = false;
			}
		}
	}
}
