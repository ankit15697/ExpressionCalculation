// This class is responsible for calculating the sin value of a Number
package operators;
import java.util.*;
public class Sin implements Operator {
    //Constructor
    public Sin(){}
    public Double doCalculation (Double... operands) {
        return Math.sin(Math.toRadians(operands[0]));
    }
}
