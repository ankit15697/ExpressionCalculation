// This class is responsible for calculating the cos value of a Number
package operators;
import java.util.*;
public class Cos implements Operator {
    //Constructor
    public Cos(){}
    public Double doCalculation (Double... operands) {
        return Math.cos(Math.toRadians(operands[0]));
    }
}
