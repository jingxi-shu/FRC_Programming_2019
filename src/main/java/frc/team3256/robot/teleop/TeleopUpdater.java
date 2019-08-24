package frc.team3256.robot.teleop;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3256.robot.subsystems.*;
import frc.team3256.robot.teleop.control.*;
import frc.team3256.robot.teleop.scheme.CargoIntakeControlScheme;
import frc.team3256.robot.teleop.scheme.HatchIntakeControlScheme;
import frc.team3256.warriorlib.control.DrivePower;
import frc.team3256.warriorlib.control.XboxControllerObserver;
import frc.team3256.warriorlib.control.XboxListenerBase;

public class TeleopUpdater {
    private DriveTrain driveTrain = DriveTrain.getInstance();

    private IDriverController driverController = XboxDriverController.getInstance();

    private Elevator mElevator = Elevator.getInstance();
    private Pivot mPivot = Pivot.getInstance();
    private CargoIntake mCargoIntake = CargoIntake.getInstance();
    private Hanger mHanger = Hanger.getInstance();
    private Sensors mSensors = Sensors.getInstance();

    private static TeleopUpdater instance;
    public static TeleopUpdater getInstance() {
        return instance == null ? instance = new TeleopUpdater() : instance;
    }

    private TeleopUpdater() {
    }

    public void handleDrive() {
        driveTrain.setBrakeMode();
        DrivePower drivePower = DriveTrain.getInstance().betterCurvatureDrive(
                Math.abs(driverController.getThrottle()) > 0.15 ? driverController.getThrottle() : 0.0,
                driverController.getTurn()*(driverController.getHighGear() ? 0.6 : 1.0),
                driverController.getQuickTurn(),
                driverController.getHighGear()
        );
        driveTrain.setHighGear(drivePower.getHighGear());
        driveTrain.setPowerOpenLoop(drivePower.getLeft(), drivePower.getRight());

    }

    public void handleEverythingElse() {
        if (driverController.shouldElevatorUp()) {
            mElevator.setWantedState(Elevator.WantedState.WANTS_TO_MANUAL_UP);
        } else if (driverController.shouldElevatorDown()) {
            mElevator.setWantedState(Elevator.WantedState.WANTS_TO_MANUAL_DOWN);
        } else {
            mElevator.setWantedState(Elevator.WantedState.WANTS_TO_HOLD);
        }

        if(driverController.shouldCargoIntake()) {
            mCargoIntake.setWantedState(CargoIntake.WantedState.WANTS_TO_INTAKE);
        } else if (driverController.shouldCargoOuttake()) {
            mCargoIntake.setWantedState(CargoIntake.WantedState.WANTS_TO_EXHAUST);
        } else {
            mCargoIntake.setWantedState(CargoIntake.WantedState.WANTS_TO_STOP);
        }
    }

    public void update() {
        handleDrive();
        handleEverythingElse();
    }
}
