/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Natouche extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    //Joystick declarations
    Joystick leftstick = new Joystick(1);
    Joystick rightstick = new Joystick(2);
    
    //Solendoid declarations
    Solenoid gearRight = new Solenoid(1);
    Solenoid gearLeft = new Solenoid(2);
    Solenoid dropRight = new Solenoid(3);
    Solenoid dropLeft = new Solenoid(4);
    
    //Drivetrain initiation
    DriveTrain dt = new DriveTrain(Constants.frontLeft, Constants.rearLeft,
                                   Constants.frontRight, Constants.rearRight);
    
    //Harvester motor declarations
    Talon harvestRight = new Talon(Constants.PWM_HARVEST_RIGHT);
    Talon harvestLeft = new Talon(Constants.PWM_HARVEST_LEFT);
    
    
    protected void robotInit() {
        System.out.println("RobotInit...");
        dt.setMotorsInverted();
    }
    
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        System.out.println("Teleop...");
        dt.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            dt.tankDrive(leftstick, rightstick);
            
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
