/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.siliconclaymore.aerial_assist.subsystems.tele;

import ca.siliconclaymore.aerial_assist.subsystems.SubsystemController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author daniel
 */
public class LauncherCTRL implements SubsystemController{

    SpeedController target;
    Joystick cont;
    int axis;
    int scaleButton;
    int fullButton;
    double scale;

    public LauncherCTRL(SpeedController target, Joystick cont, int axis, int scaleButton, int fullButton, double scale) {
	this.target = target;
	this.cont = cont;
	this.axis = axis;
	this.scaleButton = scaleButton;
	this.fullButton = fullButton;
	this.scale = scale;
    }

    public void update() {
	if (cont.getRawButton(fullButton)){
	    target.set(1);
	} else {
	    target.set(scale());
	}
    }

    private double scale() {
	if (cont.getRawButton(scaleButton)) {
	    return cont.getRawAxis(axis);
	} else {
	    return cont.getRawAxis(axis) * scale;
	}
    }
}
