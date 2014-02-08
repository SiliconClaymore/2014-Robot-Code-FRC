/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siliconClaymore.subsystems.tele;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author daniel
 */
public class Drive implements SubsystemController {

    RobotDrive mainDrive;
    Joystick controller1;
    int axis1;
    Joystick controller2;
    int axis2;
    boolean arcadeDrive;

    public Drive(RobotDrive mainDrive, Joystick controller1, int axis1, Joystick controller2, int axis2, boolean arcadeDrive) {
        this.mainDrive = mainDrive;
        this.controller1 = controller1;
        this.axis1 = axis1;
        this.controller2 = controller2;
        this.axis2 = axis2;
        this.arcadeDrive = arcadeDrive;
    }
    
    public Drive(RobotDrive mainDrive, Joystick controller1, int axis1, Joystick controller2, int axis2) {
        this(mainDrive, controller1, axis1, controller2, axis2, false);
    }

    public void update() {
        if (arcadeDrive) {
            mainDrive.arcadeDrive(controller1, axis1, controller2, axis2, true);
        } else {
            mainDrive.tankDrive(controller1, axis1, controller2, axis2, true);
        }      
    }
}
