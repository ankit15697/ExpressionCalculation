// This class is responsible for calculating the sin value of a Number
package operators;
import customExceptions.InValidOperandException;

import java.util.*;
public class Sin implements Operator {
    //Constructor
    public Sin(){}
    public Double doCalculation (Double... operands) throws InValidOperandException  {
        if(operands.length != 1) {
            throw new InValidOperandException("Only one operand should be but entered opertors by you : "+operands.length);
        }
        return Math.sin(Math.toRadians(operands[0]));
    }
}
