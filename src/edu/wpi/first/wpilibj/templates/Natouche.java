/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Gyro;
//import edu.wpi.first.wpilibj.Jaguar;

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
    Solenoid gearShiftUp = new Solenoid(1);
    Solenoid gearShiftDown = new Solenoid(2);
    Solenoid trampozine = new Solenoid(3);
    
    //Drivetrain initiation~
    DriveTrain dt = new DriveTrain(Constants.frontLeft, Constants.rearLeft, Constants.frontRight, Constants.rearRight);
    
    //Analog gyro
    Gyro gyro = new Gyro(1);             // Gyro on Analog Channel 1

    
    // This throtles speed between 0-100
    private double speedControl = 1.0;
    
    //Trampozine
    private boolean prevTrampozineButton = false;
    private boolean trampozineState = false;  
    
    //Harvester motor declarations
    //Talon harvestRight = new Talon(Constants.PWM_HARVEST_RIGHT);
    //Talon harvestLeft = new Talon(Constants.PWM_HARVEST_LEFT);
    
    
    protected void robotInit() {
        System.out.println("RobotInit...");
        dt.setMotorsInverted();
        gyro.reset();
    }
    
    public void autonomous() {
        gearShiftUp.set(false);
        double time = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp() - time < 3) {
            dt.arcadeDrive(-.9, -.23);
            if (Timer.getFPGATimestamp() - time > 0.5) {
                trampozine.set(true);
            }
        }
        time = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp() - time < 0.7) {
            dt.arcadeDrive(0.6, -.23);
        }
        time = Timer.getFPGATimestamp();
        while (Timer.getFPGATimestamp() - time < 0.7) {
            dt.arcadeDrive(-0.6, -.23);
        }
        gearShiftUp.set(false);
        dt.arcadeDrive(0, 0);
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        System.out.println("Teleop...");
        dt.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            //Drive
            if (leftstick.getRawButton(Constants.JB_SLOW_SPEED_ONE) ||
                leftstick.getRawButton(Constants.JB_SLOW_SPEED_TWO))  {
                speedControl = .8;
            } else { 
                speedControl = 1;   
            }
            double angle = gyro.getAngle(); // get current heading
            dt.arcadeDrive(dt.accelCurve(leftstick)*speedControl,
                angle/100);
            //dt.arcadeDrive(dt.accelCurve(leftstick)*speedControl,
            //    leftstick.getX()*0.85*speedControl);
            Timer.delay(Constants.TELEOP_LOOP_DELAY_SECS);
            //Shift Up
            if (leftstick.getRawButton(Constants.JB_SHIFT_UP)) {
                gearShiftUp.set(true);
            } else {
                gearShiftUp.set(false);
            }
            //Shift Down
            if (leftstick.getRawButton(Constants.JB_SHIFT_DOWN)) {
                gearShiftDown.set(true);
            } else {
                gearShiftDown.set(false);
            }
            //Trampozine - 
            if (leftstick.getRawButton(Constants.JB_TRAMPOZINE)) {
                trampozine.set(true);
            } else {
                trampozine.set(false);
            }
                //if (prevTrampozineButton = false) {
                //    prevTrampozineButton = true;             //button just got pressed
                //    if (trampozineState = true) {            //cycle the trampozine
                //        trampozineState = false;  
                //    } else {
                //        trampozineState = true;
                //    }
                //    trampozine.set(trampozineState);
                //} else {
                //    prevTrampozineButton = false;            //button just got released
                //}
            
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
