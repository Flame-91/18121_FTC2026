package org.firstinspires.ftc.teamcode.pedroPathing.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.pedroPathing.subsystems.TestIntakeSubsystem;

public class TestIntakeCommand extends CommandBase {

    private final TestIntakeSubsystem intake;
    private final Gamepad gamepad;

    public TestIntakeCommand(TestIntakeSubsystem intake, Gamepad gamepad) {
        this.intake = intake;
        this.gamepad = gamepad;
        addRequirements(intake);
    }

    public void initialize() {
        
    }
}
