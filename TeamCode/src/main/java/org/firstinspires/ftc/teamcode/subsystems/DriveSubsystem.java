package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;

public class DriveSubsystem extends SubsystemBase {
    SolversMotor leftFront, leftRight, rightFront, rightRear;
    private double drivePowerThreshold = 0.01;
    double frontLeftPower, backLeftPower, frontRightPower, backRightPower;
    public DriveSubsystem(final HardwareMap hm, final String lf, final String lr, final String rf, final String rr) {
        SolversMotor leftFront = new SolversMotor(hm.get(DcMotorEx.class, lf), drivePowerThreshold);
        SolversMotor leftRight = new SolversMotor(hm.get(DcMotorEx.class, lr), drivePowerThreshold);
        SolversMotor rightFront = new SolversMotor(hm.get(DcMotorEx.class, rf), drivePowerThreshold);
        SolversMotor rightRear = new SolversMotor(hm.get(DcMotorEx.class, rr), drivePowerThreshold);
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
        leftFront.setPower(frontLeftPower);
        leftRight.setPower(backLeftPower);
        rightFront.setPower(frontRightPower);
        rightRear.setPower(backRightPower);
    }
}
