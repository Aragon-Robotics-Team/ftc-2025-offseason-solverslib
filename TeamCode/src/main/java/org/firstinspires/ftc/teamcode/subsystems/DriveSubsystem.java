package org.firstinspires.ftc.teamcode.subsystems;


import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.hardware.RobotHardware;


public class DriveSubsystem extends SubsystemBase {

    private final RobotHardware robot = RobotHardware.getInstance();

    double frontLeftPower, backLeftPower, frontRightPower, backRightPower;

    public void init() {
        frontLeftPower = 0;
        backLeftPower = 0;
        frontRightPower = 0;
        backRightPower = 0;
    }
    public void setDriveVectors(double x, double y, double rx) {
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        frontLeftPower = (y + x + rx) / denominator;
        backLeftPower = (y - x + rx) / denominator;
        frontRightPower = (y - x - rx) / denominator;
        backRightPower = (y + x - rx) / denominator;
    }
    @Override
    public void periodic() {
        robot.leftFront.setPower(frontLeftPower);
        robot.leftRear.setPower(backLeftPower);
        robot.rightFront.setPower(frontRightPower);
        robot.rightRear.setPower(backRightPower);
    }
}
