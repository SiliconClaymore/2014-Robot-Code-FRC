/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package siliconClaymore;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Watchdog;
import siliconClaymore.subsystems.Loader;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {

    RobotDrive mainDrive;
    Joystick driver;
    Joystick operator;
    Loader loader;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        mainDrive = new RobotDrive(1, 2);
        loader = new Loader(new Talon(3), new Talon(4), operator, 6, 1.0D, 1.0D);
    }

    public void teleopInit() {
        driver = new Joystick(1);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //Don't forget to feed the Watchdog
        Watchdog.getInstance().feed();
        mainDrive.tankDrive(driver, 2, driver, 5, true);
    }
}