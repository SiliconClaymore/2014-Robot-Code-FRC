/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siliconClaymore.subsystems.tele;

import edu.wpi.first.wpilibj.Joystick;
import siliconClaymore.subsystems.LoaderRaw;

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
        if (cont.getRawButton(button) && !isTop()) {
            target.smartMove(posSpeed);
        } else {
            target.smartMove(-posSpeed);
        }
    }
    
    private boolean isTop () {
        return false;
    }
    
    private boolean isBottom () {
        return false;
    }
}
