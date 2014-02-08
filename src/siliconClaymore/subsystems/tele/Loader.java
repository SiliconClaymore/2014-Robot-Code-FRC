/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siliconClaymore.subsystems.tele;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author daniel
 */
public class Loader implements SubsystemController {

    SpeedController posMotor;
    SpeedController treadMotor;
    Joystick cont;
    int button;
    double posSpeed;
    double treadSpeed;

    public Loader(SpeedController posMotor, SpeedController treadMotor , Joystick controller, int button, double posSpeed, double treadSpeed) {
        this.posMotor = posMotor;
        this.treadMotor = treadMotor;
        this.cont = controller;
        this.button = button;
        this.posSpeed = posSpeed;
        this.treadSpeed = treadSpeed;
    }

    public void update() {
        if (cont.getRawButton(button) && !isTop()) {
            posMotor.set(posSpeed);
        } else if ( isBottom()) {
            posMotor.set(-posSpeed);
            treadMotor.set(treadSpeed);
        } else {
            posMotor.set(0D);
        }
    }
    
    private boolean isTop () {
        return false;
    }
    
    private boolean isBottom () {
        return false;
    }
}
