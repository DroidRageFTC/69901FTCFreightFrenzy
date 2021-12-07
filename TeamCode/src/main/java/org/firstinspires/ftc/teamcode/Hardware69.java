package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware69 {


    /**
     * This is NOT an opmode.
     * <p>
     * This class can be used to define all the specific hardware for a single robot.
     * In this case that robot is a Pushbot.
     * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
     * <p>
     * This hardware class assumes the following device names have been configured on the robot:
     * Note:  All names are lower case and some have single spaces between words.
     * <p>
     * Motor channel:  Left  drive motor:        "left_drive"
     * Motor channel:  Right drive motor:        "right_drive"
     * Motor channel:  Manipulator drive motor:  "left_arm"
     * Servo channel:  Servo to open left claw:  "left_hand"
     * Servo channel:  Servo to open right claw: "right_hand"
     */

    /* Public OpMode members. */
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor Arm = null;
    public Servo leftClaw = null;
    public Servo rightClaw = null;
    public DcMotor backleftDrive = null;
    public DcMotor backrightDrive = null;
    public DcMotor Carousel = null;
    public DcMotor Intake = null;

    public static final double MID_SERVO = 0.9;
    public static final double ARM_UP_POWER = 0.45;
    public static final double ARM_DOWN_POWER = -0.45;

    /* local OpMode members. */
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public Hardware69() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        backleftDrive = hwMap.get(DcMotor.class, "BL_drive");
        backrightDrive = hwMap.get(DcMotor.class, "BR_drive");
        Arm = hwMap.get(DcMotor.class, "Arm");
        Carousel = hwMap.get(DcMotor.class, "Rotate");
        Intake   = hwMap.get(DcMotor.class,"Drop")

        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        backleftDrive.setDirection(DcMotor.Direction.FORWARD);
        backrightDrive.setDirection(DcMotor.Direction.REVERSE);
        Carousel.setDirection(DcMotor.Direction.FORWARD);
        Intake.setDirection(DcMotor.Direction.FORWARD);
        // Set all motors to zero power
        leftDrive.setPower(0);
        backleftDrive.setPower(0);
        rightDrive.setPower(0);
        backrightDrive.setPower(0);
        Arm.setPower(0);
        Carousel.setPower(0);
        Intake.setPower(0);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backrightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

           /* leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backleftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backrightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            */
        // Define and initialize ALL installed servos.
            /*leftClaw  = hwMap.get(Servo.class, "left_claw");
            rightClaw = hwMap.get(Servo.class, "right_claw");
            leftClaw.setPosition(MID_SERVO);
            rightClaw.setPosition(MID_SERVO);
            */

    }
}

  //  private void Carousel(DcMotorSimple.Direction forward) {
   // }
//}

