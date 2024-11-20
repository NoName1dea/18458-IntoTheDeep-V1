package org.firstinspires.ftc.teamcode.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Arm {
    public Servo leftArm, rightArm;
    public final Gamepad gamepad2;
    public HardwareMap hardwareMap;
    public static double INTAKE = 0.25;
    public static double OUTTAKE = 0.5;
    public Telemetry telemetry;
    public Arm(OpMode opMode) {
        this.hardwareMap = opMode.hardwareMap;
        this.gamepad2 = opMode.gamepad2;

        leftArm = (Servo) hardwareMap.get("leftArm");
        rightArm = (Servo) hardwareMap.get("rightArm");

        leftArm.setDirection(Servo.Direction.FORWARD);
        rightArm.setDirection(Servo.Direction.REVERSE);

    }
    public void teleOp() {
        if (gamepad2.a) armPos(INTAKE);
        else if (gamepad2.y) armPos(OUTTAKE);
    }
    public void armPos(double position) {
        leftArm.setPosition(position);
        rightArm.setPosition(position);
    }
}