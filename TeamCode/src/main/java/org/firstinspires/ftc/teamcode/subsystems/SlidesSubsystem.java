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
    private double kP, kI =0, kD = 0;


    private double powerThreshold = 0.2;

    public int targetPos = 0;
    public int low = 0;
    public int med = 200;
    public int high = 500;

    public void init(HardwareMap hm){
        pidController.setPID(0.1, 0.1, 0.1);

        SolversMotor slideLeft = new SolversMotor(hm.get(DcMotorEx.class, "slideL"), powerThreshold);
        SolversMotor slideRight = new SolversMotor(hm.get(DcMotorEx.class, "slideR"), powerThreshold);

        slideLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slideRight.setDirection(DcMotorSimple.Direction.FORWARD);

        pidController  = new PIDController(kP, kI, kD);

        slideLeft.getPosition();
    }

    public void updatePID(){
        slideLeft.setPower(powerThreshold);
        slideRight.setPower(powerThreshold);


    }

    public void setTargetPos(int targetPos){
        this.targetPos = targetPos;
    }
}
