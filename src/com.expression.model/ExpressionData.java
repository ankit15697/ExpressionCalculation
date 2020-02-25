// This class will be responsible for data storation
package com.expression.model;
public class ExpressionData {
    private static String unaryOperators[] = {"sin", "cos", "tan"};
    private static String binaryOperators[] = {"+", "-", "*", "/"};
    //Constructor
    public ExpressionData() {

    }
    // This function will return true if operator is unary
    public static boolean isUnary(String operator) {
        for(int  i = 0; i < unaryOperators.length; i++) {
            if(unaryOperators[i].equals(operator)) {
                return true;
            }
        }
        return false;
    }
    // This function will return true if Operator is binary
    public static boolean isBinary(String operator) {
        for(int i = 0; i < binaryOperators.length; i++) {
            if(binaryOperators[i].equals(operator)) {
                return  true;
            }
        }
        return false;
    }
    public static boolean isOperator(String operator) {
        for( int i = 0; i < unaryOperators.length; i++) {
            if(unaryOperators[i].equals(operator)) {
                return true;
            }
        }
        for (int i = 0; i < binaryOperators.length; i++) {
            if(binaryOperators[i].equals(operator)) {
                return true;
            }
        }
        return false;
    }
}