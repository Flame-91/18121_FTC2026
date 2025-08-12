package org.firstinspires.ftc.teamcode.pedroPathing.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.pedroPathing.subsystems.PedroDriveSubsystem;
import com.qualcomm.robotcore.hardware.Gamepad;

public class PedroDriveCommand extends CommandBase {

    private final PedroDriveSubsystem driveSubsystem;
    private final Gamepad gamepad;

    public PedroDriveCommand(PedroDriveSubsystem a, Gamepad gamepad) {
        this.driveSubsystem = a;
        this.gamepad = gamepad;
        addRequirements(a);
    }

    @Override
    public void initialize() {
        driveSubsystem.startTeleopDrive();
    }

    @Override
    public void execute() {
        double forward = -gamepad.left_stick_y;
        double strafe = -gamepad.left_stick_x;
        double turn = gamepad.right_stick_x;


        driveSubsystem.drive(forward, strafe, turn);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        // just wanted to get rid of the "Method 'isFinished()' is identical to its super method"
        return false;
    }
}