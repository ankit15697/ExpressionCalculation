// This is user defined unchecked exception which will be used in when any invalid exception will occur
package com.expression.exceptions;
public class InValidCharacterException extends RuntimeException {

    // User will get message and that message will be printed in the console
    public InValidCharacterException(String msg) {
        super(msg);
    }
}