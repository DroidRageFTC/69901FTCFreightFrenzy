package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.SubSystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.SubSystems.BoxSubsystem;
import org.firstinspires.ftc.teamcode.SubSystems.FlipperSubsystem;
import org.firstinspires.ftc.teamcode.SubSystems.TurretSubsystem;

/**
     * This file provides basic Telop driving for a Pushbot robot.
     * The code is structured as an Iterative OpMode
     *
     * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
     * All device access is managed through the HardwarePushbot class.
     *
     * This particular OpMode executes a basic Tank Drive Teleop for a PushBot
     * It raises and lowers the claw using the Gampad Y and A buttons respectively.
     * It also opens and closes the claws slowly using the left and right Bumper buttons.
     *
     * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
     * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
     */

@TeleOp(name="Start Drive", group="Pushbot")

public class StartDrive extends OpMode{

    /* Declare OpMode members. */
    Hardware69 robot       = new Hardware69(); // use the class created to define a Pushbot's hardware

    //defines the subsystems in this tele-op
    ArmSubsystem arm                            = new ArmSubsystem                          ();
    BoxSubsystem box                            = new BoxSubsystem                          ();
    TurretSubsystem turret                      = new TurretSubsystem                       ();
    FlipperSubsystem flipper                    = new FlipperSubsystem                      ();

    double          clawOffset  = 0.0 ;                  // Servo mid position
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         * Init's all the subsystems
         */
        robot.init(hardwareMap);

        arm.init(hardwareMap, telemetry, box, turret, flipper);
        box.init(hardwareMap, telemetry);
        turret.init(hardwareMap, telemetry);
        flipper.init(hardwareMap,telemetry);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Sup Nerd, ", "Get Ready!");
    }


     //* Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY

    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() 
    {
        flipper.defaultCommand(gamepad1, gamepad2);
        // DO all thecrap with all the arm and stuff
        arm.findArmPosition(gamepad1, gamepad2);
        arm.loopCommand();

        double leftPower;
        double rightPower;

        double drive =- gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        double speedMultiplier;
        //Controls the speed of the bot
        //if the left bumper= fast, right bump= slow, if not keep it at normal
        if (gamepad1.left_bumper) {
            speedMultiplier = 1;
        } else if (gamepad1.right_bumper) {
            speedMultiplier = 0.3;
        } else {
            speedMultiplier = 0.6;
        }


        double rotate = gamepad2.right_trigger;
        double Lift = gamepad2.left_stick_y;

        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
     //ArmPower = Range.clip(Lift, -0.2, 0.2) ;
        robot.leftFront.setPower(leftPower * speedMultiplier);
        robot.leftRear.setPower(leftPower * speedMultiplier);
        robot.rightRear.setPower(rightPower * speedMultiplier);
        robot.rightFront.setPower(rightPower * speedMultiplier);

        //right and left trigger control the intake
        if (gamepad1.right_trigger >= 0.1)
                robot.Intake.setPower(1);
        if (gamepad1.left_trigger >= 0.1)
            robot.Intake.setPower(-1);
        else if (gamepad1.right_trigger < 0.1 && gamepad1.left_trigger < 0.1)
            robot.Intake.setPower(0);


        //buttons control the carousel
        if (gamepad2.b) {
            robot.carousel.setPower(1);
        }
        if (gamepad2.x){
            robot.carousel.setPower(-1);
        }
        if (!gamepad2.b && !gamepad2.x) {
            robot.carousel.setPower(0);
        }


        // Send telemetry message to signify robot running;
        telemetry.addData("claw",  "Offset = %.2f", clawOffset);
        telemetry.addData("left",  "%.2f", leftPower);
        telemetry.addData("right", "%.2f", rightPower);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}
