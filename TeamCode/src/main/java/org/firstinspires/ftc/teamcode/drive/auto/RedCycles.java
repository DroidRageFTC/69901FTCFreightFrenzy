package org.firstinspires.ftc.teamcode.drive.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware69;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequenceimproved.TrajectorySequence;

@Autonomous(name="Auto 69 Red Cycles")
public class RedCycles extends LinearOpMode {

    Pose2d startPose = new Pose2d(-13, -69, Math.toRadians(-90));
    Hardware69 Robot = new Hardware69();


    @Override
    public void runOpMode() {
        Robot drive = new Robot(this);
        drive.setPoseEstimate(startPose);
        TrajectorySequence myTrajectory = drive.trajectorySequenceBuilder(startPose)
                .setReversed(true)
                .back(22)
                .addDisplacementMarker(() -> {
                    Robot.slide.setPower(.8);
                })

                .waitSeconds(2)
                .forward(16)
                .splineTo(new Vector2d(45, -76), Math.toRadians(0))
                .waitSeconds(2)
                .back(40)
                .splineTo(new Vector2d(-12, -52), Math.toRadians(90))
                .waitSeconds(2)
                .forward(16)
                .splineTo(new Vector2d(45, -77), Math.toRadians(0))
                .waitSeconds(2)
                .back(40)
                .splineTo(new Vector2d(-12, -52), Math.toRadians(90))
                .waitSeconds(2)
                .splineTo(new Vector2d(45, -76), Math.toRadians(0))
                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectorySequence(myTrajectory);
    }
}
