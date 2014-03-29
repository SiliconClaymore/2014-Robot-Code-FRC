/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.siliconclaymore.aerial_assist.subsystems.tele;

import ca.siliconclaymore.aerial_assist.subsystems.LauncherRaw;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author daniel
 */
public class LauncherCTRL {
    
    LauncherRaw target;
    Joystick cont;
    int axis;
    int scaleButton;
    double scale;

    public LauncherCTRL(LauncherRaw target, Joystick cont, int axis, int scaleButton, double scale) {
	this.target = target;
	this.cont = cont;
	this.axis = axis;
	this.scaleButton = scaleButton;
	this.scale = scale;
    }    
    
    public void update() {
	if (cont.getRawButton(scaleButton)) {
	    target.set(cont.getRawAxis(axis));
	} else {
	    target.set(cont.getRawAxis(axis) * scale);
	}
    }
    
}
