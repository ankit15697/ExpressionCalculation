// This interface is the Parent of all operator classes
package com.expression.operators;

import com.expression.exceptions.InValidOperandException;
public interface Operator{
    public Double doCalculation(Double ...operands) throws InValidOperandException;
}