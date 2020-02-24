// This class will do divison of two number
package operators;
import customExceptions.*;
public class Divison implements Operator{
    //Constructor
    public Divison(){

    }

    public Double doCalculation(Double ...operands) {
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