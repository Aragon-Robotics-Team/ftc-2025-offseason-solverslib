package org.firstinspires.ftc.teamcode;

import android.transition.Slide;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.Robot;
import com.seattlesolvers.solverslib.command.Subsystem;
import com.seattlesolvers.solverslib.command.button.Button;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.DriveForXCommand;
import org.firstinspires.ftc.teamcode.commands.SlidesHigh;
import org.firstinspires.ftc.teamcode.commands.SlidesLow;
import org.firstinspires.ftc.teamcode.commands.SlidesMed;
import org.firstinspires.ftc.teamcode.hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlidesSubsystem;

@TeleOp
public class TeleOpCommandOpMode extends CommandOpMode {
    private final RobotHardware robot = RobotHardware.getInstance();
    GamepadEx gp1 = new GamepadEx(gamepad1);
    GamepadEx gp2 = new GamepadEx(gamepad2);
    @Override
    public void initialize() {
        super.reset(); //Reset command scheduler

        robot.init(hardwareMap);

        register(robot.drive);

        robot.initSubsystems();

        //init buttons
        Button slidesUpButton = new GamepadButton(
                gp1, GamepadKeys.Button.Y
        );

        //Schedule commands
        schedule();

        slidesUpButton.whenPressed(new SlidesHigh(robot.slides)).whenReleased(new SlidesLow(robot.slides));
    }
    public void run() {
        telemetry.update();
        for (LynxModule h : robot.allHubs) {
            h.clearBulkCache();
        }
    }
}
