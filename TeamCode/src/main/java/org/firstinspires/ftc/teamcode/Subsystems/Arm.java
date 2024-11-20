package org.firstinspires.ftc.teamcode.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Arm {
    public static Servo leftArm;
    public static Servo rightArm;
    public final Gamepad gamepad2;
    private static int REST = 0;  //set  later
    public static int INTAKE = 0;
    public static int OUTTAKE = 0;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Arm(OpMode opMode) {
        this.hardwareMap = opMode.hardwareMap;
        this.gamepad2 = opMode.gamepad2;
        this.telemetry = opMode.telemetry;
        leftArm = (Servo) hardwareMap.get("leftArm");
        rightArm = (Servo) hardwareMap.get("rightArm");

        //The slides must be set to correct directions
        leftArm.setDirection (Servo.Direction.REVERSE);
        rightArm.setDirection (Servo.Direction.FORWARD);
        leftArm.setPosition(REST);
        rightArm.setPosition(REST);
    }
    public void teleOp() {
        if (gamepad2.a) {
            armservo(INTAKE,INTAKE);};
        if (gamepad2.b) {
            armservo(OUTTAKE, OUTTAKE);}
        if (gamepad2.x) {
            armservo(REST, REST);}
    }
    private static void armservo(double setPositionLeft, double setPositionRight){
        rightArm.setPosition(setPositionRight);
        leftArm.setPosition(setPositionLeft);
        }
    }