package frc.team3256.robot.teleop.control;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3256.warriorlib.control.XboxListenerBase;

public class DriverControlScheme extends XboxListenerBase {

    private boolean highGear = false;
    private boolean quickTurn = false;

    private double leftX = 0.0;
    private double leftY = 0.0;

    private double rightX = 0.0;
    private double rightY = 0.0;

    public boolean isHighGear() {
        return highGear;
    }

    public boolean isQuickTurn() {
        return quickTurn;
    }

    public double getLeftX() {
        return leftX;
    }

    public double getLeftY() {
        return leftY;
    }

    public double getRightX() {
        return rightX;
    }

    public double getRightY() {
        return rightY;
    }

    @Override
    public void onAPressed() {

    }

    @Override
    public void onBPressed() {

    }

    @Override
    public void onXPressed() {

    }

    @Override
    public void onYPressed() {

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

    }

    @Override
    public void onSelectedReleased() {

    }

    @Override
    public void onStartReleased() {

    }

    @Override
    public void onLeftShoulderPressed() { }

    @Override
    public void onLeftShoulderReleased() { }

    @Override
    public void onRightShoulderPressed() { }

    @Override
    public void onRightShoulderReleased() { }

    @Override
    public void onLeftTrigger(double value) {
        highGear = value > 0.25;
        SmartDashboard.putBoolean("HighGear", highGear);
    }

    @Override
    public void onRightTrigger(double value) {
        quickTurn = value > 0.25;
    }

    @Override
    public void onLeftJoystick(double x, double y) {
        leftX = x;
        leftY = y;
    }

    @Override
    public void onRightJoystick(double x, double y) {
        rightX = x;
        rightY = y;
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
