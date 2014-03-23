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
public class LauncherRaw {
    
    SpeedController motor;
    private Position position; //Never mind this error

    public LauncherRaw(SpeedController motor) {
	this.motor = motor;
    }
    
    public void FIRE () {
	moveToPos(Position.kStandby);
    }
    
    public void moveToPos (Position position) {
	this.position = position;
    }
    
    public Position getPosition () {
	if (checkBlock()) {
	    return Position.kBlock;
	} else if (checkStandby()) {
	    return Position.kStandby;
	} else {
	    return Position.kAnywhere;
	}
    }
    
    public Position update () {
	
	return getPosition();
    }
    
    private boolean checkBlock () {
	return false;
    }
    
    private boolean checkStandby () {
	return false;
    }
    
    public static class Position {

        /**
         * The integer value representing this enumeration
         */
        public final int value;
        static final int kAnywhere_val = 0;
        static final int kStandby_val = 1;
        static final int kBlock_val = 2;
        /**
         * value: Anywhere else
         */
        public static final Position kAnywhere = new Position(kAnywhere_val);
        /**
         * value: Resting
         */
        public static final Position kStandby = new Position(kStandby_val);
        /**
         * value: Blocking
         */
        public static final Position kBlock = new Position(kBlock_val);

        private Position(int value) {
            this.value = value;
        }
    }
}
