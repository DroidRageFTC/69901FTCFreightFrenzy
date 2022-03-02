package org.firstinspires.ftc.teamcode.drive.auto;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.Robot;
import org.firstinspires.ftc.teamcode.trajectorysequenceimproved.TrajectorySequence;

@Config
@Autonomous(name="Blue Path.Park&Depot", group="Roadrunner Paths")
public class BluePath_Park_and_Depot extends LinearOpMode {

    @Override
    public void runOpMode() {
        Robot drive = new Robot(this);

        // On start

        waitForStart();
        if(isStopRequested()) return;










        Pose2d startPose = new Pose2d(3, 60, Math.toRadians(90));
        ElapsedTime timer = new ElapsedTime();

        drive.setPoseEstimate(startPose);

        TrajectorySequence Trajectory1 = drive.trajectorySequenceBuilder(startPose)

                .build();

        drive.followTrajectorySequence(Trajectory1);

    }
}

