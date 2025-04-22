package org.firstinspires.ftc.teamcode;

import android.transition.Slide;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.Subsystem;
import com.seattlesolvers.solverslib.command.button.Button;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.DriveForXCommand;
import org.firstinspires.ftc.teamcode.commands.SlidesHigh;
import org.firstinspires.ftc.teamcode.commands.SlidesLow;
import org.firstinspires.ftc.teamcode.commands.SlidesMed;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

@TeleOp
public class TeleOpCommandOpMode extends CommandOpMode {
    private DriveSubsystem drive;
    private SlidesSubsystem slides;
    private DriveForXCommand driveForXCommand;
    private SlidesHigh slidesHigh;
    private SlidesMed slidesMed;
    private SlidesLow slidesLow;
    GamepadEx gp1 = new GamepadEx(gamepad1);
    GamepadEx gp2 = new GamepadEx(gamepad2);
    @Override
    public void initialize() {
        super.reset(); //Reset command scheduler

        //Initialize hardware
        DriveSubsystem drive = new DriveSubsystem(hardwareMap, "leftFront", "leftRear", "rightFront", "rightRear");
        SlidesSubsystem slides = new SlidesSubsystem(hardwareMap, "slideL", "slideR");
        register(drive, slides);
        //Schedule commands
        schedule();

        //init butons
        Button slidesUpButton = new GamepadButton(
                gp1, GamepadKeys.Button.Y
        );

        slidesUpButton.whenPressed(new SlidesHigh(slides)).whenReleased(new SlidesLow(slides));
    }
}
