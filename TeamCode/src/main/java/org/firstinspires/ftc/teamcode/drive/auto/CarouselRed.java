package org.firstinspires.ftc.teamcode.drive.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequenceimproved.TrajectorySequence;

@Autonomous(name="Carousel red 69")

public class CarouselRed extends LinearOpMode {

    Pose2d startPose = new Pose2d(-31, -61, Math.toRadians(0));

    @Override
    public void runOpMode() {
        Robot drive = new Robot(this);

        TrajectorySequence myTrajectory = drive.trajectorySequenceBuilder(startPose)
                .setReversed(true)
                .back(40)


         //       .addDisplacementMarker(() -> carouselRed.start())

                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectorySequence(myTrajectory);
    }
}