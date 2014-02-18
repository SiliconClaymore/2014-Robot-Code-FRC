/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siliconClaymore.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author daniel
 */
public class LoaderRaw {

    SpeedController pos;
    Relay tread;
    double bottomAngle = 0d;
    double topAngle = 90d;
    double error = 5d;

    public LoaderRaw(SpeedController pos, Relay tread) {
	this.pos = pos;
	this.tread = tread;
    }

    public boolean smartMove(double speed) {
	if (speed > 0) {
	    int d = resolveError(topAngle, currentAngle(), error);
	    pos.set(speed * d);
	    tread.set(Relay.Value.kOff);
	    return d == 1;
	} else if (speed == 0) {
	    pos.set(speed);
	    tread.set(Relay.Value.kOff);
	    return false;
	} else {
	    int d = resolveError(topAngle, currentAngle(), error);
	    pos.set(speed * d);
	    tread.set(Relay.Value.kOn);
	    return d == -1;
	}
    }

    private int resolveError(double dest, double curn, double error) {
	if (dest - error > currentAngle()) {
	    return 1;
	} else if (this.topAngle + this.error < currentAngle()) {
	    return -1;
	} else {
	    return 0;
	}
    }

    public void adjustAngle(double adjust) {
	bottomAngle += adjust;
    }

    public void setAngle(double angle) {
	this.bottomAngle = angle;
    }

    private double currentAngle() {
	return -30D;
    }
}
