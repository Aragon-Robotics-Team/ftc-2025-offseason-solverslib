package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.button.Button;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.SlidesHighCommand;
import org.firstinspires.ftc.teamcode.commands.SlidesLowCommand;
import org.firstinspires.ftc.teamcode.commands.SlidesMedCommand;
import org.firstinspires.ftc.teamcode.hardware.RobotHardware;

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

        Button slidesDownButton = new GamepadButton(
                gp1, GamepadKeys.Button.X
        );

        Button slidesMidButton = new GamepadButton(
                gp1, GamepadKeys.Button.A
        );

        //Schedule commands
        schedule();

        slidesUpButton.whenPressed(new SlidesHighCommand(robot.slides)).whenReleased(new SlidesLowCommand(robot.slides));
        slidesDownButton.whenPressed(new SlidesLowCommand(robot.slides));
        slidesMidButton.whenPressed(new SlidesMedCommand(robot.slides));
    }
    public void run() {
        telemetry.update();
        for (LynxModule h : robot.allHubs) {
            h.clearBulkCache();
        }
    }
}
