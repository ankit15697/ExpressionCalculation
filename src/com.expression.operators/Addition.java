// This class will do addition
package com.expression.operators;

import com.expression.exceptions.InValidOperandException;
import org.jetbrains.annotations.NotNull;

public class Addition implements Operator  {
    //Constructor
    public  Addition(){

    }

    public Double doCalculation(@NotNull Double ...operands) throws InValidOperandException {
        if(operands.length != 2) {
            throw new InValidOperandException("Only two operands should be but entered operands by you : "+operands.length);
        }
        return operands[0] + operands[1];
    }
}