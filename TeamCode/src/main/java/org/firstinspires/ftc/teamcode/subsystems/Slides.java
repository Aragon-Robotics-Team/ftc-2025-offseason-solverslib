package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.controller.PIDController;

public class Slides {
    DcMotorEx slideLeft;
    DcMotorEx slideRight;

    public int targetPos = 0;
    public int low = 0;
    public int med = 200;
    public int high = 500;

    public int power = 0;

    private PIDController controller;
    private static double p = 0, i = 0, d = 0;
    private boolean usingpid = false;
    private double pid;

    public void init(HardwareMap hm){
        controller = new PIDController(p,i,d);

        slideLeft = hm.get(DcMotorEx.class, "slideLeft");
        slideRight = hm.get(DcMotorEx.class, "slideRight");

        slideLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        slideLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        slideRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void Loop(){
        if (usingpid){ //if usingpid = true
            controller.setPID(p,i,d);

            pid = controller.calculate(slideRight.getCurrentPosition(), targetPos); //calc output

            slideLeft.setPower(pid); //do said output
            slideRight.setPower(pid);
        }
        else { //if usingpid = false
            slideLeft.setPower(power);
            slideRight.setPower(power);
        }
    }

    public void setTargetPos(int targetPos){
        this.targetPos = targetPos;
    }
}
