package org.firstinspires.ftc.teamcode.drive.auto;
import android.transition.Slide;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Hardware69;
import org.firstinspires.ftc.teamcode.SubSystems.FlipperSubsystem;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequenceimproved.TrajectorySequence;
import org.firstinspires.ftc.teamcode.SubSystems.BoxSubsystem;

@Autonomous (name="Auto WareHouse Blue")
public class WarehouseBlue extends LinearOpMode {
    Pose2d startPose = new Pose2d(-5, 69, Math.toRadians(0));

    @Override
    public void runOpMode() {
        Robot drive = new Robot(this);
        Hardware69 Robot = new Hardware69();
        Robot.init(hardwareMap);
        waitForStart();
        drive.setPoseEstimate(startPose);

        TrajectorySequence myTrajectory = drive.trajectorySequenceBuilder(startPose)
                .forward(37)

                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectorySequence(myTrajectory);
    }
}
