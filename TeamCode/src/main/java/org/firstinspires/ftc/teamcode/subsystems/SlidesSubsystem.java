package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDController;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;

public class SlidesSubsystem extends SubsystemBase {
    SolversMotor slideLeft, slideRight;

    PIDController pidController;
    private double kP = 0, kI = 0, kD = 0;

    public double slidePowerThreshold = 0.1;

    public int targetPos = 0;
    public int low = 0;
    public int med = 200;
    public int high = 500;

    public SlidesSubsystem(final HardwareMap hm, final String left, final String right) {
        SolversMotor slideleft = new SolversMotor(hm.get(DcMotorEx.class, left), slidePowerThreshold);
        SolversMotor slideright = new SolversMotor(hm.get(DcMotorEx.class, right), slidePowerThreshold);

        pidController = new PIDController(kP, kI, kD);

        slideLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slideRight.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void Loop(){
        double output = pidController.calculate(slideLeft.getPosition(), targetPos); // calculates output needed
        slideLeft.setPower(output);
        slideRight.setPower(output);
    }

//  dunno if i need
//    public void setTargetPos(int targetPos){
//        this.targetPos = targetPos;
//    }

    public void setHigh(){
        targetPos = high;
    }

    public void setMed(){
        targetPos = med;
    }

    public void setLow(){
        targetPos = low;
    }
}
