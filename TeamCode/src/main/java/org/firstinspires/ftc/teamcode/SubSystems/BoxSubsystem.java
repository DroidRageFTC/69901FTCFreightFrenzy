package org.firstinspires.ftc.teamcode.SubSystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.lang.reflect.Constructor;

@Config
public class BoxSubsystem extends BaseSubsystem {
    // Values
    public static double BOX_HIGH = 0.892;
  //  public static double BOX_SHARED = 1.0;
    public static double BOX_DOWN_SLIGHTLY_FORWARD = 0.1;
    public static double BOX_DOWN = 0.05;


    // Create hardware variables
    public Servo Box = null;

    // Constructor
    public BoxSubsystem() {

    }

    // Initialize hardware variables
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        super.init(hardwareMap, telemetry);
        Box = hardwareMap.get(Servo.class,"boxServo");
        Box.setDirection(Servo.Direction.REVERSE);

        Box.setPosition(BOX_HIGH);
        Box.setPosition(BOX_DOWN);
        Box.setPosition(BOX_DOWN_SLIGHTLY_FORWARD);



    }

}