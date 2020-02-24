// This class will do Substraction of two number
package operators;
public class Substraction implements Operator{
    //Constructor
    public Substraction(){

    }

    public Double doCalculation(Double ...operands) {
        return operands[1] - operands[0];
    }
}