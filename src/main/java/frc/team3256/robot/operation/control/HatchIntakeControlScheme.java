package frc.team3256.robot.operation.control;

import frc.team3256.robot.operation.TeleopUpdater;
import frc.team3256.robot.operation.XboxListenerBase;
import frc.team3256.robot.operations.Constants;
import frc.team3256.robot.subsystems.Elevator;
import frc.team3256.robot.subsystems.HatchPivot;

public class HatchIntakeControlScheme extends XboxListenerBase {
    private HatchPivot hatchPivot = HatchPivot.getInstance();
    private Elevator elevator = Elevator.getInstance();

    @Override
    public void onAPressed() {
        elevator.setLowHatchPosition();
    }

    @Override
    public void onBPressed() {
        elevator.setMidHatchPosition();
    }

    // Home elevator
    @Override
    public void onXPressed() {
        elevator.setPosition(0);
    }

    @Override
    public void onYPressed() {
        elevator.setHighHatchPosition();
    }

    @Override
    public void onAReleased() {

    }

    @Override
    public void onBReleased() {

    }

    @Override
    public void onXReleased() {

    }

    @Override
    public void onYReleased() {

    }

    @Override
    public void onLeftDpadPressed() {

    }

    @Override
    public void onRightDpadPressed() {

    }

    @Override
    public void onUpDpadPressed() {

    }

    @Override
    public void onDownDpadPressed() {

    }

    @Override
    public void onLeftDpadReleased() {

    }

    @Override
    public void onRightDpadReleased() {

    }

    @Override
    public void onUpDpadReleased() {

    }

    @Override
    public void onDownDpadReleased() {

    }

    @Override
    public void onSelectedPressed() {

    }

    @Override
    public void onStartPressed() {
        TeleopUpdater.getInstance().changeToCargoControlScheme();
    }

    @Override
    public void onSelectedReleased() {

    }

    @Override
    public void onStartReleased() {

    }

    @Override
    public void onLeftShoulderPressed() {

    }

    @Override
    public void onRightShoulderPressed() {

    }

    @Override
    public void onLeftShoulderReleased() {

    }

    @Override
    public void onRightShoulderReleased() {

    }

    @Override
    public void onLeftTrigger(double value) {

    }

    @Override
    public void onRightTrigger(double value) {

    }

    // Move elevator manually
    @Override
    public void onLeftJoystick(double x, double y) {
        if (y > 0.25) {
            elevator.setOpenLoop(Constants.kElevatorUpManualPower);
        }
        if (y < 0.25){
            elevator.setOpenLoop(Constants.kElevatorDownManualPower);
        }
    }

    @Override
    public void onRightJoyStick(double x, double y) {

    }

    @Override
    public void onLeftJoystickPressed() {

    }

    @Override
    public void onRightJoystickPressed() {

    }

    @Override
    public void onLeftJoystickReleased() {

    }

    @Override
    public void onRightJoystickReleased() {

    }
}
