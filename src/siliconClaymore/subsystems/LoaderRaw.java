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
    
    public LoaderRaw (SpeedController tread, SpeedController pos) {
        this.tread = tread;
        this.pos = pos;
    }
    
    public boolean smartMove (double speed) {
        if (speed > 0) {
            if (!isTop()) {
                pos.set(speed);
            }
            return !isTop();
        } else if (speed == 0) {
            return false;
        } else {
            if (!isBottom()) {
                pos.set(speed);
                tread.set(1D);
            }
            return !isBottom();
        }
    }
    
    private boolean isTop () {
        return false;
    }
    
    private boolean isBottom () {
        return false;
    }
}
