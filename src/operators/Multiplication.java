// This class will do multiplication of two number
package operators;

import customExceptions.InValidOperandException;

public class Multiplication implements Operator{
    //Constructor
    public Multiplication(){

    }

    public Double doCalculation(Double ...operands) throws InValidOperandException {
        if(operands.length != 2) {
            throw new InValidOperandException("Only two operands should be but entered opertors by you : "+operands.length);
        }
        return operands[0] * operands[1];
    }
}