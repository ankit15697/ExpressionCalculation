// This class will do multiplication of two number
package operators;
public class Multiplication implements Operator{
    //Constructor
    public Multiplication(){

    }

    public Double doCalculation(Double ...operands) {
        return operands[0] * operands[1];
    }
}