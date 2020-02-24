// This interface is the Parent of all operator classes
package operators;

import customExceptions.InValidOperandException;

public interface Operator{
    public Double doCalculation(Double ...operands) throws InValidOperandException;
}