// This class is responsible for calculating the cos value of a Number
package operators;
import customExceptions.InValidOperandException;

import java.util.*;
public class Cos implements Operator {
    //Constructor
    public Cos(){}
    public Double doCalculation (Double... operands) throws InValidOperandException {
        if(operands.length != 1) {
            throw new InValidOperandException("Only one operand should be but entered opertors by you : "+operands.length);
        }
        return Math.cos(Math.toRadians(operands[0]));
    }
}
