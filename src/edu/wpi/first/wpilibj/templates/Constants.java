/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Ben
 */
public class Constants {
    //Drivetrain PWMs
    public static final int PWM_DRIVE_FRONT_LEFT = 1;
    public static final int PWM_DRIVE_REAR_LEFT = 2;
    public static final int PWM_DRIVE_FRONT_RIGHT = 3;
    public static final int PWM_DRIVE_REAR_RIGHT = 4;
    
    //Drivetrain motor declarations
    static Talon frontLeft = new Talon(PWM_DRIVE_FRONT_LEFT);
    static Talon rearLeft = new Talon(PWM_DRIVE_REAR_LEFT);
    static Talon frontRight = new Talon(PWM_DRIVE_FRONT_RIGHT);
    static Talon rearRight = new Talon(PWM_DRIVE_REAR_RIGHT);
    
    //Harvester PWMs
    public static final int PWM_HARVEST_RIGHT = 5;
    public static final int PWM_HARVEST_LEFT = 6;
    
}
