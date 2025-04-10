package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

public class SlidesLow extends CommandBase {
    private final SlidesSubsystem slides;
    private int low = 100;

    public SlidesLow(SlidesSubsystem slides){
        this.slides = slides;
        addRequirements(slides);
    }

    public void initialize(){
        slides.setTargetPos(low);
    }

    public boolean isFinished() {
        if (Math.abs(slides.slideLeft.getPosition() - low) < 10) {
            return true;
        }
        return false;
    }
}
