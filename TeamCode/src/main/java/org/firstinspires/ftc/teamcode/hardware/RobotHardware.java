package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.solversHardware.SolversMotor;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

import java.util.List;

public class RobotHardware {
    public List<LynxModule> allHubs;
    public SolversMotor leftFront;
    public SolversMotor leftRear;
    public SolversMotor rightFront;
    public SolversMotor rightRear;
    public SolversMotor slideLeft;
    public SolversMotor slideRight;
    public DriveSubsystem drive;
    public SlidesSubsystem slides;
    private static RobotHardware instance = new RobotHardware();
    public static RobotHardware getInstance() {
        if (instance == null) {
            instance = new RobotHardware();
        }
        return instance;
    }
    public void init(HardwareMap hm) {
        leftFront = new SolversMotor(hm.get(DcMotorEx.class, "lf"), 0.01);
        leftRear = new SolversMotor(hm.get(DcMotorEx.class, "lr"), 0.01);
        rightFront = new SolversMotor(hm.get(DcMotorEx.class, "rf"), 0.01);
        rightRear = new SolversMotor(hm.get(DcMotorEx.class, "rr"), 0.01);
        slideLeft = new SolversMotor(hm.get(DcMotorEx.class, "slideLeft"), 0.01);
        slideRight = new SolversMotor(hm.get(DcMotorEx.class, "slideRight"), 0.01);

        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //Run without velocity PID control
        leftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slideLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slideRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        slideLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slideRight.setDirection(DcMotorSimple.Direction.FORWARD);

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        allHubs = hm.getAll(LynxModule.class);
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }

        drive = new DriveSubsystem();
        slides = new SlidesSubsystem();
    }
    public void initSubsystems() { //Run after registering subsystems to scheduler
        drive.init();
        slides.init();
    }
}
