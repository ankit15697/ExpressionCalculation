// This class is responsible for calculating the tan value of a Number
package com.expression.operators;

import com.expression.exceptions.InValidOperandException;
import java.util.*;
public class Tan implements Operator {
    //Constructor
    public Tan(){}
    public Double doCalculation (Double... operands) throws InValidOperandException {
        if(operands.length != 1) {
            throw new InValidOperandException("Only one operand should be but entered operands by you : "+operands.length);
        }
        return Math.tan(Math.toRadians(operands[0]));
    }
}
