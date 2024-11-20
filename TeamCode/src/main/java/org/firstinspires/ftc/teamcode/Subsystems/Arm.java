package org.firstinspires.ftc.teamcode.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Arm {
    public Servo leftArm, rightArm;
    public final Gamepad gamepad2;
    public HardwareMap hardwareMap;
    public static double OPENED = 0;
    public static double CLOSED = 0.8;
    public Arm(OpMode opMode) {
        this.hardwareMap = opMode.hardwareMap;
        this.gamepad2 = opMode.gamepad2;

        leftArm = (Servo) hardwareMap.get("leftArm");
        rightArm = (Servo) hardwareMap.get("rightArm");

        leftArm.setDirection(Servo.Direction.FORWARD);
        rightArm.setDirection(Servo.Direction.REVERSE);

        armPos(OPENED);
    }
    public void teleOp() {
        if (gamepad2.left_bumper) armPos(OPENED);
        else if (gamepad2.right_bumper) armPos(CLOSED);
    }
    public void armPos(double position) {
        leftArm.setPosition(position);
        rightArm.setPosition(position);
    }
}