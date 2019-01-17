package frc.team3256.robot;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {
    XboxController xboxController;
    CANSparkMax sparkMax;
    CANPIDController pidController;

    /**
     * This function is called when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        sparkMax = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        sparkMax.setIdleMode(CANSparkMax.IdleMode.kBrake);
        xboxController = new XboxController(0);

        pidController = sparkMax.getPIDController();
        pidController.setP(0.1); //velocity: 5e-5
        pidController.setI(1e-8); //velocity: 1e-6
        pidController.setD(1); //velocity: 0
        pidController.setIZone(0);
        pidController.setFF(0);
        pidController.setOutputRange(-1, 1);
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
        //pidController.setReference(5000, ControlType.kVelocity);
        //pidController.setReference(0, ControlType.kPosition);
    }


    /**
     * This function is called periodically during teleop.
     */
    @Override
    public void teleopPeriodic() {
        //double setpoint = -xboxController.getY(GenericHID.Hand.kRight)*5700;
        //pidController.setReference(setpoint, ControlType.kVelocity);

        if (xboxController.getYButtonPressed()) {
            pidController.setReference(500, ControlType.kPosition);
        }
        if (xboxController.getAButtonPressed()) {
            pidController.setReference(0, ControlType.kPosition);
        }

        /*
        double output = -xboxController.getY(GenericHID.Hand.kRight);
        if (Math.abs(output) >= 0.05)
            sparkMax.set(output);
        else
            sparkMax.set(0);
        */
        System.out.println("Position: " + sparkMax.getEncoder().getPosition());
        System.out.println("Velocity: " + sparkMax.getEncoder().getVelocity());
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {

    }
}