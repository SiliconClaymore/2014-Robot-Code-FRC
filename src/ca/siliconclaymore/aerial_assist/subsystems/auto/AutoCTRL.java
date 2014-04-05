/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.siliconclaymore.aerial_assist.subsystems.auto;

import ca.siliconclaymore.aerial_assist.subsystems.SubsystemController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author daniel
 */
public class AutoCTRL implements SubsystemController {

    RobotDrive drive;
    SpeedController launcher;
    double driveTime;
    double driveSpeed;
    double shootTime;
    Timer timer;
    boolean driving;

    public AutoCTRL(RobotDrive drive, SpeedController launcher, double driveTime, double driveSpeed, double shootTime) {
	this.drive = drive;
	this.launcher = launcher;
	this.driveTime = driveTime;
	this.driveSpeed = driveSpeed;
	this.shootTime = shootTime;
	(this.timer = new Timer()).start();
	driving = true;
    }

    public void update() {
	if (driving) {
	    if (driveTime > timer.get()) {
		drive.tankDrive(driveSpeed, driveSpeed);
	    } else {
		drive.stopMotor();
		driving = false;
	    }
	} else {
	    if (shootTime > timer.get()) {
		launcher.set(1);
	    } else {
		launcher.set(0);
	    }
	}

    }
}
