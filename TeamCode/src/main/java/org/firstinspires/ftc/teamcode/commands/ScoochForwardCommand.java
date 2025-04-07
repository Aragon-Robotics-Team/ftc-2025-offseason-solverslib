package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

public class ScoochForwardCommand extends CommandBase {
    private final DriveSubsystem drive;
    public ScoochForwardCommand(DriveSubsystem drive) {
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.setDriveVectors(0, 1, 0);
    }
}
