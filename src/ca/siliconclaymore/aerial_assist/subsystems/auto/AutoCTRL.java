/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.siliconclaymore.aerial_assist.subsystems.auto;

import ca.siliconclaymore.aerial_assist.subsystems.SubsystemController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author daniel
 */
public class AutoCTRL implements SubsystemController{
    
    RobotDrive drive;
    double driveTime;
    double driveSpeed;
    Timer timer;

    public AutoCTRL(RobotDrive drive, double driveTime, double driveSpeed) {
	this.drive = drive;
	this.driveTime = driveTime;
	this.driveSpeed = driveSpeed;
	(this.timer = new Timer()).start();
    }
    
    public void update () {
	if (driveTime>timer.get()) {
	    drive.tankDrive(driveSpeed, driveSpeed);
	} else {
	    drive.stopMotor();
	}
    }
}
