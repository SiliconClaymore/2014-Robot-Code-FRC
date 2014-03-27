/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.siliconclaymore.aerial_assist.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Class to handle the position of rotating arms using only Limit Switches.
 *
 * @author Daniel
 */
public class PositionTracker {

    private final DigitalInput[] positions;
    private int lastPosition;

    /**
     * Creates an instance of PositionTracker.
     *
     * @param positions An array of {@link DigitalInput} representing Limit
     * Switches in order.
     * @param startPosition The last known position or supposed starting
     * position. Even numbers signify contact with a sensor (array position * 2)
     * while odd numbers signify no contact with a sensor. If unknown just set
     * this to whatever.
     */
    public PositionTracker(DigitalInput[] positions, int startPosition) {
        this.positions = positions;
        lastPosition = startPosition;
    }

    /**
     * Creates an instance of PositionTracker.
     *
     * @param ports An array of ints representing ports that are connected to
     * Limit Switches in order.
     * @param startPosition The last known position or supposed starting
     * position. Even numbers signify contact with a sensor (array position * 2)
     * while odd numbers signify no contact with a sensor. If unknown just set
     * this to whatever.
     */
    public PositionTracker(int[] ports, int startPosition) {
        positions = new DigitalInput[ports.length];
        for (int i = 0; i < ports.length; i++) {
            positions[i] = new DigitalInput(ports[i]);
        }
        this.lastPosition = startPosition;
    }

    /**
     * Returns the predicted position. Make sure to call this often even if not
     * reading the result. Calling too often is not a problem
     *
     * @param forward Specify what direction moving in.
     * @return Position as an int. Even numbers signify contact with a sensor
     * (array position * 2) while odd numbers signify no contact with a sensor.
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
