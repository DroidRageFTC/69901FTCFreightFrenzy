package org.firstinspires.ftc.teamcode.SubSystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.lang.reflect.Constructor;

@Config
public class BoxSubsystem extends BaseSubsystem {
    // Values
    public static double BOX_HIGH = 0.8;
  //  public static double BOX_SHARED = 1.0;
    public static double BOX_SHARED = .9;
    public static double BOX_MID = .825;
    public static double BOX_DOWN = -1.0;


    // Create hardware variables
    public Servo Box = null;

    // Constructor
    public BoxSubsystem() {

    }

    // Initialize hardware variables
    public void init(HardwareMap hardwareMap, Telemetry telemetry) {
        super.init(hardwareMap, telemetry);
        Box = hardwareMap.get(Servo.class, "boxServo");
        Box.setDirection(Servo.Direction.REVERSE);
    }
    public void defaultCommand(Gamepad gamepad1, Gamepad gamepad2) {
        super.gamepadInit(gamepad1, gamepad2);

        if(gamepad2.a){
            Box.setPosition(BOX_HIGH);
        }
        if(gamepad2.x){
            Box.setPosition(BOX_DOWN);
        }
        if(gamepad2.b){
            Box.setPosition(BOX_SHARED);
        }
        Box.setPosition(BOX_HIGH);
        Box.setPosition(BOX_DOWN);
        Box.setPosition(BOX_SHARED);



    }

}