// This class is responsible for calculating the tan value of a Number
package operators;
import customExceptions.InValidOperandException;

import java.util.*;
public class Tan implements Operator {
    //Constructor
    public Tan(){}
    public Double doCalculation (Double... operands) throws InValidOperandException {
        if(operands.length != 1) {
            throw new InValidOperandException("Only one operand should be but entered opertors by you : "+operands.length);
        }
        return Math.tan(Math.toRadians(operands[0]));
    }
}
