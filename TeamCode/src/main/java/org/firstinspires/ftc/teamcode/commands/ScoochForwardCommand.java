package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.concurrent.TimeUnit;

public class ScoochForwardCommand extends CommandBase {
    private final DriveSubsystem drive;
    private Timing.Timer timer = new Timing.Timer(300, TimeUnit.MILLISECONDS);
    public ScoochForwardCommand(DriveSubsystem drive) {
        //Constructing command w/ subsystem
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        //Drive in +y and start timer
        drive.setDriveVectors(0, 1, 0);
        timer.start();
    }
    public boolean isFinished() {
        //Return true when timer>300ms
        return timer.done();
    }
}
