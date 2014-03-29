/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.siliconclaymore.aerial_assist.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author daniel
 */
public class LauncherRaw {
    
    SpeedController motor;

    public LauncherRaw(SpeedController motor) {
	this.motor = motor;
    }
    
    public void set (double speed) {
	motor.set(speed);
    }
}
