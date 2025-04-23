package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.hardware.GlobalConstants;
import org.firstinspires.ftc.teamcode.hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

public class SlidesLowCommand extends CommandBase {
    private final SlidesSubsystem slides;
    private final RobotHardware robot = RobotHardware.getInstance();

    public SlidesLowCommand(SlidesSubsystem slides){
        this.slides = slides;
        addRequirements(slides);
    }

    @Override
    public void initialize(){
        slides.setTargetPosition(GlobalConstants.SLIDES_LOWPOS);
    }

    public boolean isFinished() {
        if (Math.abs(robot.slideLeft.getPosition() - GlobalConstants.SLIDES_LOWPOS) < 10) {
            return true;
        }
        return false;
    }
}
