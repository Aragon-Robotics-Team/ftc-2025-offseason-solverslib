package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.hardware.GlobalConstants;
import org.firstinspires.ftc.teamcode.hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

public class SlidesHighCommand extends CommandBase {
    private final SlidesSubsystem slides;
    private final RobotHardware robot = RobotHardware.getInstance();

    public SlidesHighCommand(SlidesSubsystem slides) {
        this.slides = slides;
        addRequirements(slides);
    }

    @Override
    public void initialize() {
        slides.setTargetPosition(GlobalConstants.SLIDES_HIGHPOS);
    }

    public boolean isFinished() {
        if (Math.abs(robot.slideLeft.getPosition() - GlobalConstants.SLIDES_HIGHPOS) < 10) {
            return true;
        }
        return false;
    }
}
