package default_package;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Random random;
	int number;
	Character character;
	ArrayList<Obstacles> obstacle = new ArrayList<Obstacles>();
	ScoreChecker scoreChecker = new ScoreChecker(0, -910, Game.width, 10);
	long obstacleTimer = 0;
	int obstacleSpawnTime = 500;
	int score = 0;

	ObjectManager(Character character) {
		this.character = character;
	}

	void update() {
		character.update();
		for (int i = 0; i < obstacle.size(); i++) {
			obstacle.get(i).update();
		}
		scoreChecker.update();
	}

	void draw(Graphics g) {
		random = new Random();
		number = random.nextInt(2);
		character.draw(g);
		for (int i = 0; i < obstacle.size(); i++) {
			if (number == 0) {
				obstacle.get(i).draw(g);
			}
			if (number == 1) {
				obstacle.get(i).draw1(g);
			}
		}

		scoreChecker.draw(g);
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
		for (Obstacles o : obstacle) {
			if (o.collisionBox.intersects(scoreChecker.collisionBox)) {
				o.isAlive = false;
				score++;

			}
		}
	}
}
