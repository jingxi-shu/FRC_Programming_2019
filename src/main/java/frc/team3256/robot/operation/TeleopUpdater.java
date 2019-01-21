package frc.team3256.robot.operation;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.team3256.robot.operations.DrivePower;
import frc.team3256.robot.subsystems.CargoIntake;
import frc.team3256.robot.subsystems.DriveTrain;

public class TeleopUpdater {
    DriveConfigImplementation driveConfigImplementation = new DriveConfigImplementation();
    XboxController xboxController;
    DriveTrain driveTrain;
    //HatchIntake hatchIntake;
    CargoIntake cargoIntake;
    boolean highGear = true;

    public TeleopUpdater(){
        xboxController = new XboxController(0);
        driveTrain = DriveTrain.getInstance();
        //hatchIntake = HatchIntake.getInstance();
        //cargoIntake = CargoIntake.getInstance();
    }

    public void update(){
        //hatchIntake.update(Timer.getFPGATimestamp());
        //cargoIntake.update(Timer.getFPGATimestamp());

        //Drivetrain subsystem
        
        double throttle = driveConfigImplementation.getThrottle();
        double turn = driveConfigImplementation.getTurn();
        boolean quickTurn = driveConfigImplementation.getQuickTurn();

        DrivePower drivePower = DriveTrain.curvatureDrive(throttle, turn, quickTurn, highGear);
        //driveTrain.setHighGear(drivePower.highGear());
        driveTrain.setOpenLoop(drivePower.getLeft(), drivePower.getRight());

        if (driveTrain.leftSlave.getOutputCurrent() > 10 || driveTrain.leftSlave.getOutputCurrent() > 10)
            System.out.println("LEFT " + driveTrain.leftSlave.getOutputCurrent() + " RIGHT " + driveTrain.rightSlave.getOutputCurrent());


    }
}
