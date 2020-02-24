// This class will be responsible for Controlling the whole logic of Calculation
package calculationController;
import java.util.*;
import expressionParts.*;
import customExceptions.*;
import expressionValidation.*;
import expressionEvaluation.*;
public class ExpressionCalculation {
    private String expression;
    private LinkedList<ExpressionPart> splittedExpression;
    private ExpressionPartition expressionPartition;
    private ExpressionEvaluation expressionEvaluation;
    private ExpressionValidation expressionValidation;
    // Constructor
    public  ExpressionCalculation(String expression){
        this.expression = expression;
        splittedExpression = new LinkedList<ExpressionPart>();
        expressionPartition = new ExpressionPartition(expression);
        expressionEvaluation = new ExpressionEvaluation();
        expressionValidation = new ExpressionValidation();
        init();
    }
    // This method will take expression parts from ExpressionPartition class
    public void init() {
        expressionPartition.convertIntoExpressionParts();
        splittedExpression = expressionPartition.getExpressionParts();
        expressionValidation.isValid(splittedExpression);
        ExpressionPart evaluatedPart = expressionEvaluation.evaluate(splittedExpression);
        double result = Double.parseDouble(evaluatedPart.getExpressionPart());
        if(result == Math.floor(result)) {
            int integerResult = (int)result;
            System.out.println(integerResult);
        }
        else {
            System.out.println(evaluatedPart.getExpressionPart());
        }

    }

}