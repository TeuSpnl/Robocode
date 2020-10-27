package MsSpnl;
import robocode.*;
import java.awt.Color;


// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * TurnShot - a robot by Mateus Spínola
 * @author Mateus Spínola
 */
public class TurnShot extends Robot
{
	/**
	 * run: TurnShot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		initialize();

		// Robot main loop
		while(true) {
			ahead(30);
			turnRight(30);
			turnGunRight(360);
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
		turnGunLeft(360);
		turnLeft(30);
		ahead(50);
	}	
	
	private void initialize() {
		// Body moves, gun and radar don't
		setAdjustGunForRobotTurn(true);
		
		//Set Robot Colors
		setBodyColor(new Color(0xC0,	0xC0, 0xC0)); // Silver
		setGunColor(new Color(0x99,	0xCC, 0xFF)); // Light Blue
		setRadarColor(new Color(0xCC, 0xFF, 0xFF)); // Lighter Blue + a Little of Green
		setBulletColor(new Color(0xFF, 0x00, 0xFF)); // Fuchsia
		setScanColor(new Color(0xCC, 0xFF, 0xFF)); // It's the Same of the Radar color
	}
}
