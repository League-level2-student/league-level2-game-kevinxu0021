package default_package;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Random random;
	int number;
	Character character;
	ArrayList<Obstacles> obstacle = new ArrayList<Obstacles>();
	//ArrayList<Obstacles> obstacle1 = new ArrayList<Obstacles>();
	ScoreChecker scoreChecker = new ScoreChecker(0, -910, Game.width, 10);
	long obstacleTimer = 0;
	int obstacleSpawnTime = 2000;
	int score = 0;

	ObjectManager(Character character) {
		this.character = character;
	}

	void update() {
		character.update();
		for (int i = 0; i < obstacle.size(); i++) {
			obstacle.get(i).update();
		}
		//for (int i = 0; i < obstacle1.size(); i++) {
		//	obstacle1.get(i).update();
		//}
		scoreChecker.update();
	}

	void draw(Graphics g) {
		random = new Random();
		
		character.draw(g);
		for (int i = 0; i < obstacle.size(); i++) {
			number = random.nextInt(2);
			if(number == 0) {
			obstacle.get(i).draw(g);
			}
			else if(number == 1) {
				obstacle.get(i).draw1(g);
			}
		}


		scoreChecker.draw(g);
	}

	void addObstacles(Obstacles o) {
		obstacle.add(o);
	}

	//void addObstacles1(Obstacles o1) {
	//	obstacle1.add(o1);
	//}

	void manageObstacles() {
		if (System.currentTimeMillis() - obstacleTimer >= obstacleSpawnTime) {
			addObstacles(new Obstacles(new Random().nextInt(Game.width), 0, 50, 50));
		//	addObstacles1(new Obstacles(new Random().nextInt(Game.width), 0, 50, 50));
			obstacleTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < obstacle.size(); i++) {
			if (obstacle.get(i).isAlive == false) {
				obstacle.remove(i);
			}
		}
		//for (int i = 0; i < obstacle1.size(); i++) {
		//	if (obstacle1.get(i).isAlive == false) {
		//		obstacle1.remove(i);
		//	}
		//}
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
		//for (Obstacles o1 : obstacle1) {
		//	if (character.collisionBox.intersects(o1.collisionBox)) {
		//		character.isAlive = false;
		//	}
	//	}
	//	for (Obstacles o1 : obstacle1) {
		//	if (o1.collisionBox.intersects(scoreChecker.collisionBox)) {
		//		o1.isAlive = false;
		//		score++;
		//	}
		//}
	}
}
