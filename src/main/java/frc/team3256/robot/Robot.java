package frc.team3256.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3256.robot.subsystems.DriveTrain;
import frc.team3256.robot.teleop.TeleopUpdater;
import frc.team3256.warriorlib.loop.Looper;
import frc.team3256.warriorlib.subsystem.DriveTrainBase;

public class Robot extends TimedRobot {

//	// Subsystems
	private DriveTrain driveTrain = DriveTrain.getInstance();

	// Loopers
	private Looper teleopLooper;
	private TeleopUpdater teleopUpdater;

	/**
	 * This function is called when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
//		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
//		camera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 360, 15);
		DriveTrainBase.setDriveTrain(driveTrain);

		teleopLooper = new Looper(1 / 200D);
		driveTrain.resetEncoders();
		driveTrain.resetGyro();

		teleopLooper.addLoops(driveTrain);

		teleopUpdater = TeleopUpdater.getInstance();
		SmartDashboard.putBoolean("visionEnabled", false);
		SmartDashboard.putBoolean("autoEnabled", true);
		SmartDashboard.putString("ControlScheme", "Cargo");
	}

	/**
	 * This function is called when the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		teleopLooper.stop();

		driveTrain.setCoastMode();
		driveTrain.setHighGear(true);
		driveTrain.setOpenLoopCurve(0, 0);
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
	public void robotPeriodic(){
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
		driveTrain.setBrakeMode();
		teleopLooper.start();
	}

	/**
	 * This function is called periodically during teleop.
	 */
	@Override
	public void teleopPeriodic() {
		teleopUpdater.update();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
//		SmartDashboard.putString("Pose", poseEstimator.getPose().toString());
		//cargoIntake.setIntakePower(0.5);
//		SmartDashboard.putNumber("Pose X", poseEstimator.getPose().x);
//		SmartDashboard.putNumber("Pose Y", poseEstimator.getPose().y);
//		SmartDashboard.putNumber("right encoder", driveTrain.getRightDistance());
//		SmartDashboard.putNumber("left encoder", driveTrain.getLeftDistance());
	}

	@Override
	public void disabledPeriodic() {
//		SmartDashboard.putNumber("hatchPivot", hatchPivot.getAngle());
//		SmartDashboard.putNumber("hatchPosition", hatchPivot.getEncoderValue());
//		SmartDashboard.putBoolean("hallEffect", elevator.getHallEffectTriggered());
	}
}