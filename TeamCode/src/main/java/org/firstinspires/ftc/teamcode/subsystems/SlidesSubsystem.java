package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDController;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;

import org.firstinspires.ftc.teamcode.hardware.RobotHardware;

public class SlidesSubsystem extends SubsystemBase {

    private final RobotHardware robot = RobotHardware.getInstance();

    public int targetPos;
    double slideLeftPower, slideRightPower;

    private double kP = 0, kI = 0, kD = 0;
    PIDController pidController = new PIDController(kP, kI, kD);

    public void init() {
        slideLeftPower = 0;
        slideRightPower = 0;
    }

    @Override
    public void periodic(){
        double output = pidController.calculate(robot.slideLeft.getPosition(), targetPos); // calculates output needed
        robot.slideLeft.setPower(output);
        robot.slideRight.setPower(output);
    }
    
    public void setTargetPosition(int targetPos){
        this.targetPos = targetPos;
    }
}
