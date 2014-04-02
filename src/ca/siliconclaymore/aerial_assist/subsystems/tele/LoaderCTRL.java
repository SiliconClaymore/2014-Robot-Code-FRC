/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.siliconclaymore.aerial_assist.subsystems.tele;

import edu.wpi.first.wpilibj.Joystick;
import ca.siliconclaymore.aerial_assist.subsystems.LoaderRaw;

/**
 *
 * @author daniel
 */
public class LoaderCTRL implements SubsystemController {

    LoaderRaw target;
    Joystick cont;
    int treadButton;
    int treadOpp;
    int scaleButton;
    int axis;
    double scale;

    public LoaderCTRL(LoaderRaw target, Joystick cont, int axis, int treadButton, int treadOpp, int scaleButton, double scale) {
	this.target = target;
	this.cont = cont;
	this.treadButton = treadButton;
	this.treadOpp = treadOpp;
	this.scaleButton = scaleButton;
	this.axis = axis;
	this.scale = scale;
    }

    public void update() {
	target.dumbMove(scale(), tread());
    }

    private double scale() {
	if (cont.getRawButton(scaleButton)) {
	    return cont.getRawAxis(axis) * scale;
	} else {
	    return cont.getRawAxis(axis);
	}
    }

    public int tread() {
	return cont.getRawButton(treadButton) ? 1 : (cont.getRawButton(treadOpp) ? -1 : 0);
    }
}
