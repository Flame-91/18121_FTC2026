package org.firstinspires.ftc.teamcode.pedroPathing.game;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.pedroPathing.subsystems.PedroDriveSubsystem;
import org.firstinspires.ftc.teamcode.pedroPathing.commands.PedroDriveCommand;
import org.firstinspires.ftc.teamcode.pedroPathing.subsystems.TestIntakeSubsystem;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp", group = "game")

public class TeleOp extends CommandOpMode {
    // Defining mechnaisms
    private PedroDriveSubsystem driveSubsystem;
    private TestIntakeSubsystem intakeSubsystem;

    // Gamepads for Driver and Operator
    GamepadEx driver = new GamepadEx(gamepad1);
    GamepadEx operator = new GamepadEx(gamepad2);

    @Override
    public void initialize() {
        // Mecanum Drive Scheduler
        driveSubsystem = new PedroDriveSubsystem(hardwareMap);
        PedroDriveCommand driveCommand = new PedroDriveCommand(driveSubsystem, gamepad1);
        driveSubsystem.setDefaultCommand(driveCommand);

        //Example intake mechanism (with gamepad buttons)
        //operator.getGamepadButton(GamepadKeys.Button.A).whenPressed()

        // Telemetry
    }
}
