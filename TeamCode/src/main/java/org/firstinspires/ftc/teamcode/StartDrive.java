package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

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
    double          clawOffset  = 0.0 ;                  // Servo mid position
    final double    CLAW_SPEED  = 0.5 ;                 // sets rate to move servo
    double          ServoSpeed = 0.7;       //Speed of a servo
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Sup Nerd", "Hello Driver");    //
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
        double leftPower;
        double rightPower;
        double ArmPower = 0.3;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        //left = -gamepad1.left_stick_y;
        //right = -gamepad1.right_stick_y;

        double drive =- gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        double rotate = gamepad2.right_trigger;
         ArmPower = gamepad2.left_stick_y;

        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

        robot.leftDrive.setPower(leftPower);
        robot.backleftDrive.setPower(leftPower);
        robot.backrightDrive.setPower(rightPower);
        robot.rightDrive.setPower(rightPower);

        //Carsouel moves based on left or right trigger
        if (gamepad2.right_trigger >= 0.1)
                robot.Carousel.setPower(0.4);
        if (gamepad2.left_trigger >= 0.1)
            robot.Carousel.setPower(-0.4);
        else if (gamepad2.right_trigger < 0.1 && gamepad2.left_trigger < 0.1)
            robot.Carousel.setPower(0.0);

        // Use gamepad buttons to move the arm by the left stick
       /*
        if (gamepad2.left_stick_y > 0.1)
            robot.Arm.setPower(0.4);
        else if (gamepad2.left_stick_y>-0.1)
            robot.Arm.setPower(-0.4);
        else if (gamepad2.left_stick_y == 0)
            robot.Arm.setPower(0.0);
*/
        //takes the drop or lifts it based on right bumper (up) and left bumper (down)
        if (gamepad1.right_bumper)
                robot.Intake.setPower(0.8);
        else if (gamepad1.left_bumper)
                robot.Intake.setPower(-0.8);
        else
            robot.Intake.setPower(0.0);
        // Intake servo Controls


        /*if (gamepad1.right_bumper)
            robot.Drop.setPosition(0.5);
        else if (gamepad1.left_bumper)
            robot.Drop.setPosition(0);
*/
        if (gamepad1.a)
            robot.Drop.setPosition(-0.5);
        else if (gamepad1.b)
            robot.Drop.setPosition(0.5);

        if (gamepad2.a)
            robot.Intakeservo.setPosition (-0.5);
        else if (gamepad2.y)
            robot.Intakeservo.setPosition (0.2);

        if(gamepad2.right_bumper)
            robot.Stick.setPosition(0);
        else if (gamepad2.left_bumper)
            robot.Stick.setPosition (0.2);
        else
            robot.Stick.setPosition (0.2);
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
