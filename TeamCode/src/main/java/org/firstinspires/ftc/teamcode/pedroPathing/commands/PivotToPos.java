package org.firstinspires.ftc.teamcode.pedroPathing.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.pedroPathing.subsystems.PivotSubsystem;

public class PivotToPos extends CommandBase {

    private final PivotSubsystem pivotSubsystem;
    private final double targetPos;
    private final Gamepad gamepad;

    public PivotToPos(PivotSubsystem pivotSubsystem, double targetPos, Gamepad gamepad) {
        this.gamepad = gamepad;
        this.pivotSubsystem = pivotSubsystem;
        this.targetPos = targetPos;
        addRequirements(pivotSubsystem);
    }

    @Override
    public void execute() {
        if (gamepad.a) {
            pivotSubsystem.setTargetPos(targetPos);
        }
    }

        @Override
        public boolean isFinished () {
      return Math.abs(pivotSubsystem.getError()) < 5; // Tolerance in ticks
        }

        @Override
        public void end ( boolean interrupted){
            pivotSubsystem.setTargetPos(pivotSubsystem.getCurrentPos()); // Hold position
        }
    }
