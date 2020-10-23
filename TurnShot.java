package MsSpnl;
import robocode.*;

//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * TurnShot - a robot by (your name here)
 */
public class TurnShot extends Robot
{
	/**
	 * run: TurnShot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(50);
			turnRight(30);
			final int i = 0;
			i = i + 1;
		
			if (i < 1) {
				turnGunRight(360);
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		
		
		if (e.getDistance() < 100) {
			fire(3);
		}
		else if (e.getDistance() > 99 && e.getDistance() < 300) {
			fire(1.5);
		}
		else if (e.getDistance() > 299 && e.getDistance() < 1000) {
			fire(1);
		}
		else {
			fire (.5);
		}
		
		final double b = e.getBearing();
		turnGunLeft(b);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(300);
		turnLeft(30);
		ahead(50);
	}	
}
