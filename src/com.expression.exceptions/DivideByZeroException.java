//This class will be for divide by zero
package com.expression.exceptions;
public class DivideByZeroException extends RuntimeException{
    public DivideByZeroException(String msg) {
        super(msg);
    }
}