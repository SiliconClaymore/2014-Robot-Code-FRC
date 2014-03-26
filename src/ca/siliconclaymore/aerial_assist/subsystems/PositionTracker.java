/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.siliconclaymore.aerial_assist.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Daniel
 */
public class PositionTracker {

    private DigitalInput[] positions;
    private int lastPosition;

    public PositionTracker(DigitalInput[] positions, int lastPosition) {
        this.positions = positions;
        this.lastPosition = lastPosition;
    }

    /**
     * Returns the predicted position Make sure to call this often even if not
     * reading the result Calling to often is not a problem
     * @param forward Specify what direction moving in
     * @return Position as an int
     * even numbers signify contact with a sensor (array position * 2)
     * while odd numbers signify no contact with a sensor
     */
    public int update(boolean forward) {
        int workingPos = -1;

        for (int i = 0; i < positions.length; i++) {
            if (positions[i].get()) {
                workingPos = i * 2;
            }
        }
        if (workingPos == -1) {
            if (forward) {
                workingPos = (int) Math.floor(lastPosition / 2D) * 2;
                workingPos++;
            } else {
                workingPos = (int) Math.ceil(lastPosition / 2D) * 2;
                workingPos--;
            }
        }
        return lastPosition = workingPos;
    }
}
