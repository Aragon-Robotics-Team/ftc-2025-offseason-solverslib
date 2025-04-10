package org.firstinspires.ftc.teamcode.commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

public class SlidesHigh extends CommandBase {
    private final SlidesSubsystem slides;
    private int high = 1500;

    public SlidesHigh(SlidesSubsystem slides){
        this.slides = slides;
        addRequirements(slides); //no one else can use
    }

    public void initialize(){
        slides.setTargetPos(high);
    }

    public boolean isFinished() {
        if (Math.abs(slides.slideLeft.getPosition() - high) < 10) {
            return true;
        }
        return false;
    }
}
