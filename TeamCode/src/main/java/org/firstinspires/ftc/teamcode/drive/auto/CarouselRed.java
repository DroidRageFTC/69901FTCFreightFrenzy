package org.firstinspires.ftc.teamcode.drive.auto;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware69;
import org.firstinspires.ftc.teamcode.SubSystems.BoxSubsystem;
import org.firstinspires.ftc.teamcode.SubSystems.FlipperSubsystem;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequenceimproved.TrajectorySequence;

@Autonomous(name="Carousel red 69")

public class CarouselRed extends LinearOpMode {

    Pose2d startPose = new Pose2d(-30, -68, Math.toRadians(-90));

    @Override
    public void runOpMode() {
        Robot drive = new Robot(this);
        Hardware69 Robot = new Hardware69();
        FlipperSubsystem flipper = new FlipperSubsystem();
        BoxSubsystem Box = new BoxSubsystem();
        Robot.init(hardwareMap);
        Box.init(hardwareMap, telemetry);
        flipper.init( hardwareMap, telemetry);
        waitForStart();
        drive.setPoseEstimate(startPose);
        TrajectorySequence myTrajectory = drive.trajectorySequenceBuilder(startPose)
                .back(20)
                .turn(Math.toRadians(90))
                .back(34)
                .turn(Math.toRadians(-90))
                .addDisplacementMarker(() -> {
                    Robot.duck.setPower(-.35);
                })
                .forward(21)
                .waitSeconds(3)
                .back(27)


                .build();

        waitForStart();

        if(isStopRequested()) return;

        drive.followTrajectorySequence(myTrajectory);
    }
}