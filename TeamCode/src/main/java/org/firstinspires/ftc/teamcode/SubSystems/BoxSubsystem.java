package org.firstinspires.ftc.teamcode.SubSystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class BoxSubsystem extends BaseSubsystem {
    // Values
    public static double BOX_HIGH = 0.892;
    public static double BOX_SHARED = 1.0;
    public static double BOX_DOWN_SLIGHTLY_FORWARD = 0.1;
    public static double BOX_DOWN = 0.05;


    // Create hardware variables
    public Servo boxServo = null;

    // Constructor
    public BoxSubsystem() {

    }

    // Initialize hardware variables
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        super.init(hardwareMap, telemetry);
        boxServo = hardwareMap.get(Servo.class,"boxServo");
        boxServo.setDirection(Servo.Direction.REVERSE);

        boxServo.setPosition(BOX_DOWN);
    }

}