// This class will do divison of two number
package com.expression.operators;

import com.expression.exceptions.*;
public class Divison implements Operator{
    //Constructor
    public Divison(){

    }

    public Double doCalculation(Double ...operands) throws InValidOperandException {
        if(operands.length != 2) {
            throw new InValidOperandException("Only two operands should be but entered operands by you : "+operands.length);
        }
        if(operands[0] == Math.floor(operands[0])) {
            double second = operands[0];
            int integerResult = (int)second;
            if(integerResult == 0) {
                throw new DivideByZeroException("!!! Divide by zero has occurred ");
            }
        }
        return operands[1] / operands[0];
    }
}