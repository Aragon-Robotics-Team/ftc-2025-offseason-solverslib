package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.Subsystem;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.commands.DriveForXCommand;
import org.firstinspires.ftc.teamcode.commands.SlidesHigh;
import org.firstinspires.ftc.teamcode.commands.SlidesLow;
import org.firstinspires.ftc.teamcode.commands.SlidesMed;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

@TeleOp
public class TeleOpCommandOpMode extends CommandOpMode {
    private DriveSubsystem drive;
    private SlidesSubsystem slides;
    private DriveForXCommand driveForXCommand;
    private SlidesHigh slidesHigh;
    private SlidesMed slidesMed;
    private SlidesLow slidesLow;
    GamepadEx gp1 = new GamepadEx(gamepad1);
    GamepadEx gp2 = new GamepadEx(gamepad2);
    @Override
    public void initialize() {
        //Initialize hardware
        DriveSubsystem drive = new DriveSubsystem(hardwareMap, "leftFront", "leftRear", "rightFront", "rightRear");
        SlidesSubsystem slides = new SlidesSubsystem(hardwareMap, "slideL", "slideR");

        //Schedule commands
        schedule(driveForXCommand);
    }
    @Override
    public void run() {
        super.run();
    }

    @Override
    public void schedule(Command... commands) {
        super.schedule(commands);
    }

    @Override
    public void register(Subsystem... subsystems) {
        super.register(subsystems);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();
    }

    @Override
    public void end() {
        super.end();
    }

    @Override
    public void initialize_loop() {
        super.initialize_loop();
    }


}
