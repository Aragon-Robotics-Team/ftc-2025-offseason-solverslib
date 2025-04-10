package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.concurrent.TimeUnit;

public class DriveForXCommand extends CommandBase {
    private final DriveSubsystem drive;
    private ElapsedTime timer = new ElapsedTime();
    private int driveTime_ms;
    private double driveX, driveY, driveRX;
    public DriveForXCommand(DriveSubsystem drive, double driveX, double driveY, double driveRX, int driveTime_ms) {
        //Constructing command w/ subsystem
        this.drive = drive;
        this.driveX = driveX;
        this.driveY = driveY;
        this.driveRX = driveRX;
        this.driveTime_ms = driveTime_ms;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        //Drive in +y and start timer
        drive.setDriveVectors(driveX, driveY, driveRX);
        timer.reset();
    }
    @Override
    public boolean isFinished() {
        //Return true when timer>driveTime
        return timer.time(TimeUnit.MILLISECONDS) > driveTime_ms;
    }
    public void end() {
        drive.setDriveVectors(0,0,0);
    }
}
