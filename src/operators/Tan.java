// This class is responsible for calculating the tan value of a Number
package operators;
import java.util.*;
public class Tan implements Operator {
    //Constructor
    public Tan(){}
    public Double doCalculation (Double... operands) {
        return Math.tan(Math.toRadians(operands[0]));
    }
}
