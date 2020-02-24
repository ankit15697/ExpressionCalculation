// This class will do Substraction of two number
package com.expression.operators;

import com.expression.exceptions.InValidOperandException;
public class Substraction implements Operator{
    //Constructor
    public Substraction(){

    }

    public Double doCalculation(Double ...operands) throws InValidOperandException  {
        if(operands.length != 2) {
            throw new InValidOperandException("Only two operands should be but entered operands by you : "+operands.length);
        }
        return operands[1] - operands[0];
    }
}