package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.Subsystem;

import org.firstinspires.ftc.teamcode.commands.DriveForXCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

@TeleOp
public class TeleOpCommandOpMode extends CommandOpMode {
    private DriveSubsystem drive;
    private SlidesSubsystem slides;
    private DriveForXCommand scoochForwardCommand;
    @Override
    public void initialize() {
        //Initialize hardware
        DriveSubsystem drive = new DriveSubsystem(hardwareMap, "leftFront", "leftRear", "rightFront", "rightRear");
        SlidesSubsystem slides = new SlidesSubsystem(hardwareMap, "slideL", "slideR");

        //Schedule commands
        schedule();
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
