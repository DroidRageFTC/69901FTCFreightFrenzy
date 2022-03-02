package org.firstinspires.ftc.teamcode.drive.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequenceimproved.TrajectorySequence;

@Autonomous(name="Carousel blue 69")

public class CarouselBlue extends LinearOpMode {

    Pose2d startPose = new Pose2d(-30, 63, Math.toRadians(0));

    @Override
    public void runOpMode() {
        Robot drive = new Robot(this, startPose);

        drive.setPoseEstimate(startPose);

        TrajectorySequence myTrajectory =  drive.trajectorySequenceBuilder(startPose)
                .setReversed(true)
                .back(10)
                .waitSeconds(4)
                .turn(Math.toRadians(90))
                .splineTo(new Vector2d(-49, 55), Math.toRadians(90))

//                .turn(Math.toRadians(90))
//                .waitSeconds(4)
//                .turn(Math.toRadians(-90))
//                .forward(30)
//                .setReversed(false)
//                .waitSeconds(4)
//                .setReversed(true)
//                                .splineTo(new Vector2d(-60,-33), Math.toRadians(180))

                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectorySequence(myTrajectory);
    }
}