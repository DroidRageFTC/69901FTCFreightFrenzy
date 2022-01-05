package org.firstinspires.ftc.teamcode.SubSystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class TurretSubsystem extends BaseSubsystem {
    // Values
    public static double TURRET_SERVOS_FRONT = 0;

    public static double TURRET_SERVOS_LEFT = 0.14;

    public static double TURRET_SERVOS_RIGHT = 0.80;

    public static double TURRET_POWER = 0.3;

    public static double TURRET_RANGE = 360;

    public static double TURRET_TICK_PER_REVOLUTION = 384.539792;

    double targetPos = TURRET_SERVOS_FRONT;
    boolean disableTurret = true;

    // Create hardware variables
    public DcMotorEx turretMotor = null;
    //
    // Constructor
    public TurretSubsystem() {

    }

    // Initialize hardware variables
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        super.init(hardwareMap, telemetry);
        turretMotor = hardwareMap.get(DcMotorEx.class,"turretMotor");
        turretMotor.setDirection(DcMotorEx.Direction.FORWARD);

        setTurretPosition();
    }

    // Default command
    public void defaultCommand(Gamepad gamepad1, Gamepad gamepad2) {
        // Reset
        if (gamepad2.a && !disableTurret) {
            targetPos = TURRET_SERVOS_FRONT;
        }
        // right
        if (gamepad2.b && !disableTurret) {
            targetPos = TURRET_SERVOS_RIGHT;
        }
        // left
        if (gamepad2.x && !disableTurret) {
            targetPos = TURRET_SERVOS_LEFT;
        }
//        if (gamepad2.left_stick_x > 0.1 && !disableTurret) {
//            targetPos += TURRET_SERVOS_SPEED;
//        }
//        if (gamepad2.left_stick_x < -0.1 && !disableTurret) {
//            targetPos -= TURRET_SERVOS_SPEED;
//        }
        if ((gamepad2.a || gamepad2.b || gamepad2.x/* || gamepad2.left_stick_x > 0.1 || gamepad2.left_stick_x < -0.1*/) && !disableTurret) {
            setTurretPosition();
        }


    }
    public void setTurretPosition() {
        turretMotor.setPower(TURRET_POWER);
        turretMotor.setTargetPosition((0));
        //turretServo2.setPosition(targetPos);
    }
}
