package org.firstinspires.ftc.teamcode.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Slides {

    //establish left and right slide for gamepad
    public final DcMotor leftSlide, rightSlide;
    public final Gamepad gamepad2;
    //This determines where slides will stop depending on what the driver wants
    private static int HIGH = 1000;
    public static int MID = 500;
    public static int LOW = 0;
    public static int RESET = 0;

    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public Slides(OpMode opMode) {
        this.hardwareMap = opMode.hardwareMap;
        this.gamepad2 = opMode.gamepad2;
        this.telemetry = opMode.telemetry;
        leftSlide = (DcMotor) hardwareMap.get("leftSlide");
        rightSlide = (DcMotor) hardwareMap.get("rightSlide");

        //The slides must be set to correct directions
        leftSlide.setDirection(DcMotorSimple.Direction.FORWARD);
        rightSlide.setDirection(DcMotorSimple.Direction.REVERSE);

        //brake
        rightSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //
        leftSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftSlide.setTargetPosition(RESET);
        rightSlide.setTargetPosition(RESET);

        leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void teleOp() {
        if (gamepad2.dpad_up) slidesHighBasket();
        else if (gamepad2.dpad_right) slidesLowBasket();
        else if (gamepad2.dpad_left) slidesLowChamber();
        else if (gamepad2.dpad_down) reset();

        telemetry.addData("Slide Pos", rightSlide.getCurrentPosition());

    }
    public void slidesHighBasket() {
        rightSlide.setTargetPosition(HIGH);
        rightSlide.setPower(1);
        leftSlide.setTargetPosition(HIGH);
        leftSlide.setPower(1);
    }
    public void slidesLowBasket() {
        //Use this for high chamber
        rightSlide.setTargetPosition(MID);
        rightSlide.setPower(1);
        leftSlide.setTargetPosition(MID);
        leftSlide.setPower(1);
    }
    public void slidesLowChamber() {
        rightSlide.setTargetPosition(LOW);
        rightSlide.setPower(1);
        leftSlide.setTargetPosition(LOW);
        leftSlide.setPower(1);
    }
    public void reset() {
        rightSlide.setTargetPosition(RESET);
        rightSlide.setPower(1);
        leftSlide.setTargetPosition(RESET);
        leftSlide.setPower(1);

    }
    public void slideManual(Gamepad gamepad) {
        double multiplier = -gamepad.left_stick_y;

        if (multiplier >= 0.25) {
            for (int i = 50; i < 1000; i++) {
                leftSlide.setTargetPosition((int) (leftSlide.getCurrentPosition() - (multiplier * i++)));
                rightSlide.setTargetPosition((int) (rightSlide.getCurrentPosition() - (multiplier * i++)));
            }
        } else if (multiplier <= -0.25) {
            for (int i = -50; i < 0; i++) {
                leftSlide.setTargetPosition((int) (leftSlide.getCurrentPosition() - (multiplier * i--)));
                rightSlide.setTargetPosition((int) (rightSlide.getCurrentPosition() - (multiplier * i--)));
            }
        }
    }
}
