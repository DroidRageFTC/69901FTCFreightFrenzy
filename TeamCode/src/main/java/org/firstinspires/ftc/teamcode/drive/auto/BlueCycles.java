package org.firstinspires.ftc.teamcode.drive.auto;
import android.transition.Slide;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.Hardware69;
import org.firstinspires.ftc.teamcode.SubSystems.BaseSubsystem;
import org.firstinspires.ftc.teamcode.SubSystems.BoxSubsystem;
import org.firstinspires.ftc.teamcode.SubSystems.FlipperSubsystem;
import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequenceimproved.TrajectorySequence;

@Autonomous(name="Auto BlueCycles 69")
public class BlueCycles extends LinearOpMode {

    public DcMotor slide = null;

    Pose2d startPose = new Pose2d(-13, 69, Math.toRadians(90));

    @Override
    public void runOpMode() {
        Robot drive = new Robot(this);
        Hardware69 Robot = new Hardware69();

        drive.setPoseEstimate(startPose);

        TrajectorySequence myTrajectory = drive.trajectorySequenceBuilder(startPose)
                .setReversed(true)
                .back(22)
                .addDisplacementMarker(() -> {
                    Robot.slide.setPower(7);
                })
                .waitSeconds(2)
                .forward(16)
                .splineTo(new Vector2d(45, 76), Math.toRadians(0))
                .waitSeconds(2)
                .back(40)
                .splineTo(new Vector2d(-12, 52), Math.toRadians(-90))
                .waitSeconds(2)
                .forward(17)
                .splineTo(new Vector2d(45, 76), Math.toRadians(0))
                .waitSeconds(2)
                .back(40)
                .splineTo(new Vector2d(-12, 52), Math.toRadians(-90))
                .waitSeconds(2)
                .splineTo(new Vector2d(45, 76), Math.toRadians(0))





                .build();

        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectorySequence(myTrajectory);
    }
}
