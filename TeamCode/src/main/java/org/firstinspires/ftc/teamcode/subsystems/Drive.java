package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;

public class Drive extends SubsystemBase {
    SolversMotor leftFront, leftRight, rightFront, rightRear;
    private double drivePowerThreshold = 0.01;
    public Drive(final HardwareMap hm, final String lf, final String lr, final String rf, final String rr) {
        SolversMotor leftFront = new SolversMotor(hm.get(DcMotorEx.class, lf), drivePowerThreshold);
        SolversMotor leftRight = new SolversMotor(hm.get(DcMotorEx.class, lr), drivePowerThreshold);
        SolversMotor rightFront = new SolversMotor(hm.get(DcMotorEx.class, rf), drivePowerThreshold);
        SolversMotor rightRear = new SolversMotor(hm.get(DcMotorEx.class, rr), drivePowerThreshold);
    }
    public void driveRobotCentric(double x, double y, double rx) {
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        leftFront.setPower(frontLeftPower);
        leftRight.setPower(backLeftPower);
        rightFront.setPower(frontRightPower);
        rightRear.setPower(backRightPower);
    }


}
