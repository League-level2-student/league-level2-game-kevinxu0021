package default_package;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Random random;
	int number;
	Character character;
	ArrayList<Obstacles> obstacle = new ArrayList<Obstacles>();
	ArrayList<Obstacles1> obstacle1 = new ArrayList<Obstacles1>();
	ScoreChecker scoreChecker = new ScoreChecker(0, -910, DontDie.width, 10);
	long obstacleTimer = 0;
	long obstacleTimer1 = 0;
	int obstacleSpawnTime = 1565;
	int obstacleSpawnTime1 = 1234;
	int score = 0;

	ObjectManager(Character character) {
		this.character = character;
	}

	void update() {
		character.update();
		for (int i = 0; i < obstacle.size(); i++) {
			obstacle.get(i).update();
		}
		for (int i = 0; i < obstacle1.size(); i++) {
			obstacle1.get(i).update();
		}
		scoreChecker.update();
	}

	void draw(Graphics g) {
		character.draw(g);
		for (int i = 0; i < obstacle.size(); i++) {
				obstacle.get(i).draw(g);
			}
		for (int i = 0; i < obstacle1.size(); i++) {
			obstacle1.get(i).draw(g);
		}

		scoreChecker.draw(g);
	}

	void addObstacles(Obstacles o) {
		obstacle.add(o);
	}

	void addObstacles1(Obstacles1 o1) {
		obstacle1.add(o1);
	}

	void manageObstacles() {
		if (System.currentTimeMillis() - obstacleTimer >= obstacleSpawnTime) {
			addObstacles(new Obstacles(new Random().nextInt(DontDie.width), 0, 50, 50));

			obstacleTimer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - obstacleTimer1 >= obstacleSpawnTime1) {
			addObstacles1(new Obstacles1(new Random().nextInt(DontDie.width), 0, 50, 50));
			obstacleTimer1 = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < obstacle.size(); i++) {
			if (obstacle.get(i).isAlive == false) {
				obstacle.remove(i);
			}
		}
		for (int i = 0; i < obstacle1.size(); i++) {
			if (obstacle1.get(i).isAlive == false) {
				obstacle1.remove(i);
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
		for (Obstacles1 o1 : obstacle1) {
			if (character.collisionBox.intersects(o1.collisionBox)) {
				character.isAlive = false;
			}
		}
		for (Obstacles1 o1 : obstacle1) {
			if (o1.collisionBox.intersects(scoreChecker.collisionBox)) {
				o1.isAlive = false;
				score++;
			}
		}
	}
}
