// This class will do multiplication of two number
package com.expression.operators;

import com.expression.exceptions.InValidOperandException;

public class Multiplication implements Operator{
    //Constructor
    public Multiplication(){

    }

    public Double doCalculation(Double ...operands) throws InValidOperandException {
        if(operands.length != 2) {
            throw new InValidOperandException("Only two operands should be but entered operands by you : "+operands.length);
        }
        return operands[0] * operands[1];
    }
}