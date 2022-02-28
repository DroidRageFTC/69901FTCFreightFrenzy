package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.SubSystems.BoxSubsystem;

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
    public DcMotor leftFront = null;
    public DcMotor rightFront = null;
//    public DcMotor Turret = null;
//    public DcMotor Arm = null;
//    public Servo Pivot = null;
//    public Servo Gripper = null;
    public DcMotor leftRear = null;
    public DcMotor rightRear = null;
    public DcMotor Intake = null;
    public DcMotor duck = null;
    public DcMotor slide = null;
 //   public Servo Box = null;

    double targetTime;
    double targetTime2;
    boolean left;
    boolean right;



    public static final double MID_SERVO = 0.9;
    public static final double ARM_UP_POWER = 0.45;
    public static final double ARM_DOWN_POWER = -0.45;
    public static double StickPos = 0;
    public static double BOX_HIGH_POWER = 0.892;
    public static double BOX_DOWN_POWER = 0.05;


    public void setArmPosition(double pos) {
       // Arm.setTargetPosition((int) (1425.06 * pos));
    }

    /* local OpMode members. */
    HardwareMap hwMap = null;
    public ElapsedTime runtime = new ElapsedTime();

    /* Constructor */
    public Hardware69() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftFront = hwMap.get(DcMotor.class, "leftFront");
        rightFront = hwMap.get(DcMotor.class, "rightFront");
        leftRear = hwMap.get(DcMotor.class, "leftRear");
        rightRear = hwMap.get(DcMotor.class, "rightRear");
//        Arm = hwMap.get(DcMotor.class, "Arm");
//        Turret = hwMap.get(DcMotor.class, "Turret");
//        Pivot = hwMap.get(Servo.class, "Pivot");
//        Gripper = hwMap.get(Servo.class, "Gripper");
//        Carousel = hwMap.get(DcMotor.class, "Carousel");
        Intake   = hwMap.get(DcMotor.class,"Intake");
        duck = hwMap.get(DcMotor.class, "duck");
        slide =hwMap.get(DcMotor.class, "slide");
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPosition(0);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //Box = hwMap.get(Servo.class, "Box");
//        IntakeServo = hwMap.get(Servo.class,"IntakeServo");
//        Drop = hwMap.get(Servo.class,"Drop");
//        Stick = hwMap.get(Servo.class,"Stick");

        leftFront.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightFront.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftRear.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.REVERSE);
        duck.setDirection(DcMotor.Direction.FORWARD);
        slide.setDirection(DcMotor.Direction.FORWARD);

        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        duck.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        Intake.setDirection(DcMotor.Direction.FORWARD);
//        Arm.setDirection(DcMotor.Direction.REVERSE);
        // Set all motors to zero power
        leftFront.setPower(0);
        leftRear.setPower(0);
        rightFront.setPower(0);
        rightRear.setPower(0);
        duck.setPower(0);
        slide.setPower(0);

//        Carousel.setPower(0);
//        Intake.setPower(0);
//
//        Turret.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.

//        Arm.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        Arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);






           /* leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backleftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backrightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            */
        // Define and initialize ALL installed servos.
          //  *//leftClaw  = hwMap.get(Servo.class, "left_claw");
           // rightClaw = hwMap.get(Servo.class, "right_claw");
           // leftClaw.setPosition(MID_SERVO);
           // rightClaw.setPosition(MID_SERVO);
           // */

       /* Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Arm.setTargetPosition(0);
        Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        */
    }
}

  //  private void Carousel(DcMotorSimple.Direction forward) {
   // }
//}

