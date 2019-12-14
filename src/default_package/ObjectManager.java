package default_package;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Character character;
	ArrayList<Obstacles> obstacle = new ArrayList<Obstacles>();
	long obstacleTimer = 0;
	int obstacleSpawnTime = 1000;

	ObjectManager(Character character) {
		this.character = character;
	}

	void update() {
		character.update();
		for (int i = 0; i < obstacle.size(); i++) {
			obstacle.get(i).update();
		}
	}

	void draw(Graphics g) {
		character.draw(g);
		for (int i = 0; i < obstacle.size(); i++) {
			obstacle.get(i).draw(g);
		}
	}

	void addObstacles(Obstacles o) {
		obstacle.add(o);
	}

	void manageObstacles() {
		if (System.currentTimeMillis() - obstacleTimer >= obstacleSpawnTime) {
			addObstacles(new Obstacles(new Random().nextInt(Game.width), 0, 50, 50));

			obstacleTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < obstacle.size(); i++) {
			if (obstacle.get(i).isAlive == false) {
				obstacle.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Obstacles o : obstacle) {
			if (character.collisionBox.intersects(o.collisionBox)) {
				character.isAlive = false;
			}
		}
	}
}
