// This class is responsible for calculating the cos value of a Number
package com.expression.operators;

import com.expression.exceptions.InValidOperandException;

import java.util.*;
public class Cos implements Operator {
    //Constructor
    public Cos(){}
    public Double doCalculation (Double... operands) throws InValidOperandException {
        if(operands.length != 1) {
            throw new InValidOperandException("Only one operand should be but entered operands by you : "+operands.length);
        }
        return Math.cos(Math.toRadians(operands[0]));
    }
}
