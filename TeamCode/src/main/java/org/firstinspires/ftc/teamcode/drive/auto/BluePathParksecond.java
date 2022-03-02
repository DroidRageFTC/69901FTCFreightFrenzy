package org.firstinspires.ftc.teamcode.drive.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequenceimproved.TrajectorySequence;

@Autonomous(name="Auton 69: Blue Path Park")
public class BluePathParksecond extends LinearOpMode {
    @Override
    public void runOpMode() {
        Robot drive = new Robot(this);
        Pose2d startPose = new Pose2d(-1, 63, Math.toRadians(90));

        TrajectorySequence myTrajectory = drive.trajectorySequenceBuilder(new Pose2d(-1, 63, 90))
                .splineTo(new Vector2d(-10, 40), Math.toRadians(-90))
                .waitSeconds(2)
                .setReversed(false)
                .splineTo(new Vector2d( 33, 65), Math.toRadians(0))
                .forward(5)
                .build();
//                                .splineTo(new Vector2d(56,56), Math. toRadians(0))

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectorySequence(myTrajectory);
    }
}