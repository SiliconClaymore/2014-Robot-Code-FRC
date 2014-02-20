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
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Watchdog;
import siliconClaymore.subsystems.LoaderRaw;
import siliconClaymore.subsystems.tele.Drive;
import siliconClaymore.subsystems.tele.LoaderCTRL;

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
    Joystick operator;
    LoaderCTRL loaderCTRL;
    LoaderRaw loaderRaw;
    Talon launcher;

    public void robotInit() {
	robotDrive = new RobotDrive(new Talon(1), new Talon(2));
	launcher = new Talon(3);
	loaderRaw = new LoaderRaw(new Talon(4), new Relay(5));
    }

    public void teleopInit() {
	driver = new Joystick(1);
	operator = new Joystick(2);
	drive = new Drive(robotDrive, driver, 2, driver, 5);
	loaderCTRL = new LoaderCTRL(loaderRaw, operator, 6, 1.0D);
    }

    public void teleopPeriodic() {
	Watchdog.getInstance().feed();	//Don't forget to feed the Watchdog
	drive.update();
	loaderCTRL.update();
    }
    
    public void testPeriodic () {
	robotDrive.arcadeDrive(driver.getRawAxis(2), driver.getRawAxis(5));
	launcher.set(operator.getRawAxis(2));
	loaderRaw.dumbMove(operator.getRawAxis(5), operator.getRawButton(6));
    }
}
