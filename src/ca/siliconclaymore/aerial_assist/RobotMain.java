/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package ca.siliconclaymore.aerial_assist;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Watchdog;
import ca.siliconclaymore.aerial_assist.subsystems.LoaderRaw;
import ca.siliconclaymore.aerial_assist.subsystems.tele.Drive;
import ca.siliconclaymore.aerial_assist.subsystems.tele.LauncherCTRL;
import ca.siliconclaymore.aerial_assist.subsystems.tele.LoaderCTRL;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {

    Drive drive;
    RobotDrive robotDrive;
    Joystick driver;
    Joystick secondDriver;
    Joystick operator;
    LoaderCTRL loaderCTRL;
    LoaderRaw loaderRaw;
    LauncherCTRL LauncherCTRL;
    Talon launcher;

    public void robotInit() {
	robotDrive = new RobotDrive(new Talon(1), new Talon(2));
	launcher = new Talon(3);
	loaderRaw = new LoaderRaw(new Talon(4), new Talon(5));
    }

    public void teleopInit() {
	initJoysticks ();
	drive = new Drive(robotDrive, driver, 2, secondDriver, 2);
	loaderCTRL = new LoaderCTRL(loaderRaw, operator, 2, 5, 9, 0.5);
	LauncherCTRL = new LauncherCTRL(launcher, operator, 5, 10, 0.5);
    }

    public void teleopPeriodic() {
	Watchdog.getInstance().feed();	//Don't forget to feed the Watchdog
	drive.update();
	loaderCTRL.update();
	LauncherCTRL.update();
    }
    
    public void testInit () {
	initJoysticks ();
    }
    
    public void testPeriodic () {
	robotDrive.arcadeDrive(driver.getRawAxis(2), secondDriver.getRawAxis(2));
	launcher.set(operator.getRawAxis(5));
	loaderRaw.dumbMove(operator.getRawAxis(2), operator.getRawButton(5));
    }
    
    public void initJoysticks () {
	driver = new Joystick(1);
	secondDriver = new Joystick(2);
	operator = new Joystick(3);
    }
}
