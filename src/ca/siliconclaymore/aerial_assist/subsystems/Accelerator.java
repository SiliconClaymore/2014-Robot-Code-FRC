/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.siliconclaymore.aerial_assist.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author daniel
 */
public class Accelerator implements SpeedController {

    PIDController controller;
    MotorInterface target;

    public Accelerator(SpeedController motor, double Kp, double Ki, double Kd) {
	target = new MotorInterface(motor);
	controller = new PIDController(Kp, Ki, Kd, target, target);
	setupMinMax();
    }
    
    public Accelerator(SpeedController motor, double Kp, double Ki, double Kd, double Kf) {
	target = new MotorInterface(motor);
	controller = new PIDController(Kp, Ki, Kd, Kf, target, target);
	setupMinMax();
    }
    
    private void setupMinMax () {
	controller.setInputRange(-1.0, 1.0);
	controller.setOutputRange(-1.0, 1.0);
    }

    public void disable() {
	target.getTarget().disable();
    }

    public void set(double speed) {
	controller.setSetpoint(speed);
    }

    public void set(double speed, byte syncGroup) {
	set(speed);
    }

    public double get() {
	return target.getTarget().get();
    }

    public void pidWrite(double output) {
	set(output);
    }

    private class MotorInterface implements PIDOutput, PIDSource {

	SpeedController target;

	public MotorInterface(SpeedController target) {
	    this.target = target;
	}

	public double pidGet() {
	    return target.get();
	}

	public void pidWrite(double output) {
	    target.set(target.get() + output);
	}

	public SpeedController getTarget() {
	    return target;
	}

    }

}
