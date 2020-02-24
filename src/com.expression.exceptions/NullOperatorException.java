package com.expression.exceptions;
// This class is responsible for Throwing exception whenever no operator matches
public class NullOperatorException extends Exception{
        public NullOperatorException(String msg) {
            super(msg);
        }
}
