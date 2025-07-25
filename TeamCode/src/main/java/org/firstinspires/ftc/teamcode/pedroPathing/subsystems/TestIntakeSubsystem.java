package org.firstinspires.ftc.teamcode.pedroPathing.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestIntakeSubsystem extends SubsystemBase {

    private final DcMotorEx intake;
    private final PIDFController pidf;
    private final double kP = 0.01, kI = 0, kD = 0, kF = 0; // Need to tune
    private double targetPosition;

    public TestIntakeSubsystem(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotorEx.class, "Intake");
        intake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        intake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        pidf = new PIDFController(kP, kI, kD, kF);
    }

    public void setTargetPosition(double position) {
        targetPosition = position;
    }

    public void updatePID() {
        double currentPosition = intake.getCurrentPosition();
        double power = pidf.calculate(currentPosition, targetPosition);
        intake.setPower(power);
    }

    @Override
    public void periodic() {
        updatePID(); // Update every loop (when scheduled)
    }
}
