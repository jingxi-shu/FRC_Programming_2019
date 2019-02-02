package frc.team3256.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



public class Robot extends TimedRobot {

	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");
	NetworkTableEntry tv = table.getEntry("tv");
	NetworkTableEntry ts = table.getEntry("ts");
	NetworkTableEntry thor = table.getEntry("thor");
	NetworkTableEntry tvert = table.getEntry("tvert");

	/**
	 * This function is called when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

	}

	/**
	 * This function is called when the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	/**
	 * This function is called every robot packet, no matter the mode. Use
	 * this for items like diagnostics that you want ran during disabled,
	 * autonomous/sandstorm, teleoperated and test.
	 *
	 * <p>This runs after the mode specific periodic functions, but before
	 * LiveWindow and SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
		double x = tx.getDouble(0.0);
		double y = ty.getDouble(0.0);
		double area = ta.getDouble(0.0);
		double skew = ts.getDouble(0.0);
		double horizontal = thor.getDouble(0.0);
		double vertical = tvert.getDouble(0.0);
		boolean validTarget = tv.getDouble(0.0) == 1;

		System.out.println("LimelightX: " + x + "\tLimelightY: " + y);
		System.out.println("LimelightArea: " + area);
		System.out.println("LimelightValidTarget: " + validTarget);
		System.out.println("LimelightSkew: " + skew);
		System.out.println("LimelightHorizontal: " + horizontal);
		System.out.println("LimelightVertical: " + vertical);
	}

	/**
	 * This function is called when autonomous/sandstorm starts.
	 */
	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous/sandstorm.
	 */
	@Override
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called when teleop starts.
	 */
	@Override
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during teleop.
	 */
	@Override
	public void teleopPeriodic() {

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {

	}
}