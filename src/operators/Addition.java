// This class will do addition
package operators;
public class Addition implements Operator{
    //Constructor
    public  Addition(){

    }

    public Double doCalculation(Double ...operands) {
        return operands[0] + operands[1];
    }
}