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
public class SimpleAccelerator implements SpeedController {

    SpeedController target;
    double scale;

    public SimpleAccelerator(SpeedController target, double scale) {
	this.target = target;
	this.scale = scale;
    }

    public void disable() {
	target.disable();
    }

    public void set(double speed) {

	double currentSpeed = target.get();

	if (currentSpeed > speed) {
	    if (currentSpeed > speed + scale) {
		target.set(currentSpeed + scale);
	    } else {
		target.set(speed);
	    }
	} else {
	    if (currentSpeed > speed - scale) {
		target.set(currentSpeed - scale);
	    } else {
		target.set(speed);
	    }
	}
    }

    public void set(double speed, byte syncGroup) {
	set(speed);
    }

    public double get() {
	return target.get();
    }

    public void pidWrite(double output) {
	set(output);
    }
}
