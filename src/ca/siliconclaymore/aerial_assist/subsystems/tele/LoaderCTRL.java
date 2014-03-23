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
    int button;
    double posSpeed;

    public LoaderCTRL(LoaderRaw target, Joystick controller, int button, double posSpeed) {
	this.target = target;
	this.cont = controller;
	this.button = button;
	this.posSpeed = posSpeed;
    }

    public void update() {
	if (cont.getRawButton(button)) {
	    target.smartMove(posSpeed);
	} else {
	    target.smartMove(-posSpeed);
	}
    }
}
