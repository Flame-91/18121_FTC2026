package org.firstinspires.ftc.teamcode.pedroPathing.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class PivotSubsystem extends SubsystemBase {

    private final DcMotor leftPivot;
    private final DcMotor rightPivot;

    // PIDF gains (needs tuning!)
    private final double kP = 0.01, kI = 0, kD = 0, kF = 0;

    private final PIDFController pivotPIDF;
    private double targetPos = 0;

    public PivotSubsystem(HardwareMap hardwareMap) {
        // Left pivot motor
        leftPivot = hardwareMap.get(DcMotor.class, "leftPivot");
        leftPivot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftPivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Right pivot motor
        rightPivot = hardwareMap.get(DcMotor.class, "rightPivot");
        rightPivot.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightPivot.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // PID controller
        pivotPIDF = new PIDFController(kP, kI, kD, kF);
    }

    public void updatePID() {
        double currentPos = rightPivot.getCurrentPosition();
        double power = pivotPIDF.calculate(currentPos, targetPos);
        rightPivot.setPower(power);
        leftPivot.setPower(power);
    }

    public void setTargetPos(double target) {
        targetPos = target;
    }

    public double getTargetPos() {
        return targetPos;
    }

    public double getCurrentPos() {
        return rightPivot.getCurrentPosition();
    }

    public double getError() {
        return targetPos - getCurrentPos();
    }

    @Override
    public void periodic() {
        updatePID();
    }
}