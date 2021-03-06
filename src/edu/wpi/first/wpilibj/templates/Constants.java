/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;

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
    static Jaguar frontLeft = new Jaguar(PWM_DRIVE_FRONT_LEFT);
    static Jaguar rearLeft = new Jaguar(PWM_DRIVE_REAR_LEFT);
    static Jaguar frontRight = new Jaguar(PWM_DRIVE_FRONT_RIGHT);
    static Jaguar rearRight = new Jaguar(PWM_DRIVE_REAR_RIGHT);
    
    //Harvester PWMs
    //public static final int PWM_HARVEST_RIGHT = 5;
    //public static final int PWM_HARVEST_LEFT = 6;
    
    //Teleop Loop Delay
    public static final double TELEOP_LOOP_DELAY_SECS = .05;  //Main loop speed (.05 = 20hz)

    //Left Joystick buttons
    public static final int JB_SHIFT_DOWN = 2;
    public static final int JB_SHIFT_UP = 3;
    public static final int JB_TRAMPOZINE = 1;
    public static final int JB_SLOW_SPEED_ONE = 7;
    public static final int JB_SLOW_SPEED_TWO = 10;
    
}
