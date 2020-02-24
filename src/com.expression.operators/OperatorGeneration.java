// This class will be responsible for generating the objects based on
package com.expression.operators;
public class OperatorGeneration {
    // Constructor
    public OperatorGeneration(){

    }
    // This method will return operator object
    public static Operator getOperator(String operator)  {
        if(operator.equals("+")) {
            return new Addition();
        }
        else if(operator.equals("-")) {
            return new Substraction();
        }
        else if(operator.equals("*")) {
            return new Multiplication();
        }
        else if(operator.equals("/")) {
            return new Divison();
        }
        else if(operator.equals("sin")) {
            return new Sin();
        }
        else if(operator.equals("cos")) {
            return new Cos();
        }
        else if(operator.equals("tan")) {
            return new Tan();
        }

        return null;
    }
}