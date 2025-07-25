package org.firstinspires.ftc.teamcode.pedroPathing.subsystems;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.arcrobotics.ftclib.command.SubsystemBase;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;

/**
 * A subsystem that wraps the PedroPath Follower class for use in TeleOp drive.
 */
public class PedroDriveSubsystem extends SubsystemBase {

    Pose startingPose = new Pose(0,0,0);  // Might need to change
    private final Follower follower;

    public PedroDriveSubsystem(HardwareMap hardwareMap) {
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
        follower.setStartingPose(startingPose);
    }

    /**
     * Called in initialize() to prepare Pedro for teleop drive.
     */
    public void startTeleopDrive() {
        follower.startTeleopDrive();
    }

    /**
     * Drives the robot with given field-centric inputs.
     * @param forward Forward/backward motion (positive = forward)
     * @param strafe Left/right motion (positive = right)
     * @param turn Rotation (positive = clockwise)
     */
    public void drive(double forward, double strafe, double turn) {
        follower.setTeleOpMovementVectors(forward, strafe, turn, false); // false = field-centric & true = robot-centric
        follower.update();
    }

    /**
     * Stops the robot (optional depending on use case)
     */
    public void stop() {
        follower.setTeleOpMovementVectors(0, 0, 0, false);
        follower.update();
    }

    /**
     * Optional: expose pose if other systems need it
     */
    public Pose getPose() {
        return follower.getPose();
    }
}
