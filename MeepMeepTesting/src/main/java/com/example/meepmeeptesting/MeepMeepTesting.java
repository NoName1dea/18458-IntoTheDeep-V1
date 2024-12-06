package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(700);
        //Each square is 23 by 23 pixel thingies

        RoadRunnerBotEntity redBotRight = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 17)
                .setDimensions(17, 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14, -61, Math.toRadians(90)))
                                //Outtakes preload
                                .lineToLinearHeading(new Pose2d(8, -34, Math.toRadians(90)))
                                .waitSeconds(1)
                                .lineToConstantHeading(new Vector2d(58, -59))
                                .waitSeconds(1)
                                .build()
                );

        RoadRunnerBotEntity redBotLeft = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 17)
                .setDimensions(17, 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-32, -61, Math.toRadians(90)))
                                .lineToLinearHeading(new Pose2d(-8, -34, Math.toRadians(90)))
                                .waitSeconds(1)
                                .build()
                );

        RoadRunnerBotEntity blueBotLeft = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 17)
                .setDimensions(17, 15)
                .setColorScheme(new ColorSchemeBlueDark())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(10, 61, Math.toRadians(270)))
                                .lineToLinearHeading(new Pose2d(8, 33, Math.toRadians(-90)))
                                .waitSeconds(1)
                                .build()
                );

        RoadRunnerBotEntity blueBotRight = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(45, 45, Math.toRadians(180), Math.toRadians(180), 17)
                .setDimensions(17, 15)
                .setColorScheme(new ColorSchemeBlueDark())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-32, 61, Math.toRadians(270)))
                                //Mats are 23'23
                                //Outtakes preload
                                .lineToLinearHeading(new Pose2d(-8, 33, Math.toRadians(-90)))
                                .waitSeconds(1)
                                .lineToConstantHeading(new Vector2d(-57, 59))
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(redBotLeft)
                .addEntity(redBotRight)
                .addEntity(blueBotRight)
                .addEntity(blueBotLeft)
                .start();

    }


}