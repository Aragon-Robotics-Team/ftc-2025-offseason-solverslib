package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp
public class TeleOpCommandOpMode extends CommandOpMode {
    @Override
    public void initialize() {
        DriveSubsystem drive = new DriveSubsystem(hardwareMap, "leftFront", "leftRear", "rightFront", "rightRear");
    }
}
