/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.siliconclaymore.aerial_assist.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author daniel
 */
public class LoaderRaw {

    SpeedController pos;
    Relay tread;

    public LoaderRaw(SpeedController pos, Relay tread) {
	this.pos = pos;
	this.tread = tread;
    }

    public void dumbMove(double pos, boolean tread) {
	this.pos.set(pos);
	if (tread) {
	    this.tread.set(Relay.Value.kOn);
	} else {
	    this.tread.set(Relay.Value.kOff);
	}
    }
}
