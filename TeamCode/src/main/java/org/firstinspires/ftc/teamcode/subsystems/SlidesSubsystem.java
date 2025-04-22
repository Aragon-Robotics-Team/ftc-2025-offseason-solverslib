package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDController;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;

public class SlidesSubsystem extends SubsystemBase {
    public SolversMotor slideLeft;
    public SolversMotor slideRight;

    public int targetPos;

    PIDController pidController;
    private double kP = 0, kI = 0, kD = 0;

    public double slidePowerThreshold = 0.1;

    public SlidesSubsystem(final HardwareMap hm, final String left, final String right) {
        slideLeft = new SolversMotor(hm.get(DcMotorEx.class, left), slidePowerThreshold);
        slideRight = new SolversMotor(hm.get(DcMotorEx.class, right), slidePowerThreshold);

        pidController = new PIDController(kP, kI, kD);

        slideLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slideRight.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void periodic(){
        double output = pidController.calculate(slideLeft.getPosition(), targetPos); // calculates output needed
        slideLeft.setPower(output);
        slideRight.setPower(output);
    }
    
    public void setTargetPos(int targetPos){
        this.targetPos = targetPos;
    }
}
