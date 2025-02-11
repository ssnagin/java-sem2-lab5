/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author DEVELOPER
 */
public class BeyondLimitsException extends Exception {

    /**
     * Creates a new instance of <code>BeyondLimitsException</code> without
     * detail message.
     */
    public BeyondLimitsException() {
    }

    /**
     * Constructs an instance of <code>BeyondLimitsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BeyondLimitsException(String msg) {
        super(msg);
    }
}
