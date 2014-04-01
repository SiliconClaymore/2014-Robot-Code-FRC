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
public class LoaderRaw {
    
    SpeedController pos;
    SpeedController tread;
    
    public LoaderRaw(SpeedController pos, SpeedController tread) {
	this.pos = pos;
	this.tread = tread;
    }
    
    public void dumbMove(double pos, int treadDir) {
	this.pos.set(pos);
	if (treadDir < -1 || treadDir > 1) {
	    throw new IllegalArgumentException();
	} else {
	    tread.set(treadDir);
	}
    }
}
