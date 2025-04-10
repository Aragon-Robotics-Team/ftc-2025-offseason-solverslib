package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

public class SlidesMed extends CommandBase{
    private final SlidesSubsystem slides;
    private int med = 500;

    public SlidesMed(SlidesSubsystem slides){
        this.slides = slides;
        addRequirements(slides);
    }

    public void initialize(){
        slides.setTargetPos(med);
    }

    public boolean isFinished() {
        if (Math.abs(slides.slideLeft.getPosition() - med) < 10) {
            return true;
        }
        return false;
    }
}
