// This class will be responsible for invalid number of operands and should be checked
package com.expression.exceptions;

public class InValidOperandException extends Exception{
    public InValidOperandException(String msg) {
        super(msg);
    }
}
