//This class will be responsible for evaluting the expression
package expressionEvaluation;
import operators.*;
import expressionData.*;
import expressionParts.*;
import java.util.*;
public class ExpressionEvaluation {
    private Stack<Double> values;
    private Stack<String> expressionOperators;
    private ExpressionData expressionData;
    // Constructor
    public ExpressionEvaluation() {
        values = new Stack<Double>();
        expressionData = new ExpressionData();
        expressionOperators = new Stack<String> ();
    }
    // This method will evalute the expression
    public ExpressionPart evaluate(LinkedList<ExpressionPart> expressionParts) {
        // Run a loope till end of the expression size
        for (int i = 0; i < expressionParts.size(); i++) {
            String currentExpression = expressionParts.get(i).getExpressionPart().trim();
            if(currentExpression.equals("(")) {
                expressionOperators.push(currentExpression);
            }
            else if(currentExpression.equals(")")) {

            }
            else if(!expressionData.isOperator(currentExpression)) {
                values.push(Double.parseDouble(currentExpression));
            }
            // If negative number occurrs here
            else if(currentExpression.equals("-") && (i==0 || (expressionData.isOperator(expressionParts.get(i-1).getExpressionPart()) || expressionParts.get(i-1).getExpressionPart() == "("))) {
                    Double negativeValue = Double.parseDouble(expressionParts.get(i+1).getExpressionPart());
                    negativeValue = -negativeValue;
                    values.push(negativeValue);
                    i=i+1;
            }
            else {
                while(!expressionOperators.empty() && precedence(currentExpression, expressionOperators.peek())) {
                    String currentOp = expressionOperators.pop();
                    Operator currentOperator = OperatorGeneration.getOperator(currentOp);
                    if (expressionData.isUnary(currentOp)) {
                        values.push(currentOperator.doCalculation(values.pop()));
                    }
                    else if(expressionData.isBinary(currentOp)) {
                        values.push(currentOperator.doCalculation(values.pop(), values.pop()));
                    }
                }
                expressionOperators.push(currentExpression);
            }
        }
        while(!expressionOperators.empty()) {
            String currentOp = expressionOperators.pop();
            Operator currentOperator = OperatorGeneration.getOperator(currentOp);
            if (expressionData.isUnary(currentOp)) {
                values.push(currentOperator.doCalculation(values.pop()));
            }
            else if(expressionData.isBinary(currentOp)) {
                values.push(currentOperator.doCalculation(values.pop(), values.pop()));
            }
        }
        return (new ExpressionPart(String.valueOf(values.pop())));
    }
    // This method will check whether given string is numeric type or not
    private boolean isNumeric(String operand) {
        boolean isNumber = true;
        try {
            Double num = Double.parseDouble(operand);
        }
        catch (NumberFormatException e) {
            isNumber = false;
        }
        return isNumber;
    }
    // This method will give the operator precedence
    private  boolean precedence(String first, String second) {
        if(second.equals("(") || second.equals("(")) {
            return false;
        }
        if((first.equals( "*") || first.equals("/")) && (second.equals("+") || second.equals("-"))) {
            return false;
        }
        if(expressionData.isUnary(first)) {
            return false;
        }
        return true;
    }
}