/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siliconClaymore.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author daniel
 */
public class LoaderRaw {

    SpeedController tread;
    SpeedController pos;
    double bottomAngle = 0d;
    double topAngle = 90d;
    double error = 5d;

    public LoaderRaw(SpeedController tread, SpeedController pos) {
        this.tread = tread;
        this.pos = pos;
    }

    public boolean smartMove(double speed) {
        if (speed > 0) {
            int d = resolveError(topAngle, currentAngle(), error);
            pos.set(speed * d);
            return d == 1;
        } else if (speed == 0) {
            return false;
        } else {
            int d = resolveError(topAngle, currentAngle(), error);
            pos.set(speed * d);
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
