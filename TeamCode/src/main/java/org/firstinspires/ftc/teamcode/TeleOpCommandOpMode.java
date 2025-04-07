package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.commands.ScoochForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

@TeleOp
public class TeleOpCommandOpMode extends CommandOpMode {
    private DriveSubsystem drive;
    private SlidesSubsystem slides;
    private ScoochForwardCommand scoochForwardCommand;
    @Override
    public void initialize() {
        //Initializing hardware
        DriveSubsystem drive = new DriveSubsystem(hardwareMap, "leftFront", "leftRear", "rightFront", "rightRear");
        SlidesSubsystem slides = new SlidesSubsystem(hardwareMap, "slideL", "slideR");

        //Scheduling commands
        schedule();
    }
}
