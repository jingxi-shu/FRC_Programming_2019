package frc.team3256.robot.teleop;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3256.robot.subsystems.DriveTrain;
import frc.team3256.robot.teleop.control.DriverControlScheme;
import frc.team3256.warriorlib.control.DrivePower;
import frc.team3256.warriorlib.control.XboxControllerObserver;
import frc.team3256.warriorlib.control.XboxListenerBase;

public class TeleopUpdater {
    private DriveTrain driveTrain = DriveTrain.getInstance();

    private XboxControllerObserver driverController;
    private DriverControlScheme driverControlScheme;

    private XboxListenerBase currentControlScheme;

    private static TeleopUpdater instance;
    public static TeleopUpdater getInstance() {
        return instance == null ? instance = new TeleopUpdater() : instance;
    }

    private TeleopUpdater() {
        driverController = new XboxControllerObserver(0);

        driverControlScheme = new DriverControlScheme();
        driverController.setListener(driverControlScheme);
        driverControlScheme.setController(driverController);
    }

    private void handleDrive() {
        driveTrain.setBrakeMode();
        DrivePower drivePower = DriveTrain.curvatureDrive(
                driverControlScheme.getLeftY(),
                driverControlScheme.getRightX(),
                driverControlScheme.isQuickTurn(),
                driverControlScheme.isHighGear());
        driveTrain.setHighGear(drivePower.getHighGear());
        driveTrain.setOpenLoopCurve(drivePower.getLeft(), drivePower.getRight());
    }

    public void update() {
        handleDrive();
        driverController.update();
        SmartDashboard.putNumber("Left RPM", driveTrain.getLeftRPM());
        SmartDashboard.putNumber("Right RPM", driveTrain.getRightRPM());
        SmartDashboard.putNumber("RPM Difference", driveTrain.getLeftRPM() - driveTrain.getRightRPM());
    }

    public XboxController getDriverController() {
        return driverController.getXboxController();
    }
}
