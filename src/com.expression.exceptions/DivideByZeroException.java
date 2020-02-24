//This class will be for divide by zero and this is an unchecked exception
package com.expression.exceptions;
public class DivideByZeroException extends RuntimeException{
    public DivideByZeroException(String msg) {
        super(msg);
    }
}