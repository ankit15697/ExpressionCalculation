// This class will be responsible for Controlling the whole logic of Calculation
package com.expression.controller;
import java.util.*;
import com.expression.part.*;
import com.expression.exceptions.*;
import com.expression.validation.*;
import com.expression.evaluation.*;
public class ExpressionCalculation {
    private String expression;
    private LinkedList<ExpressionPart> splittedExpression;
    private ExpressionPartition expressionPartition;
    private ExpressionEvaluation expressionEvaluation;
    private ExpressionValidation expressionValidation;
    // Constructor
    public  ExpressionCalculation(String expression){
        this.expression = expression;
        init();
    }
    // This method will initialize the data
    private void init(){
        splittedExpression = new LinkedList<ExpressionPart>();
        expressionPartition = new ExpressionPartition(expression);
        expressionEvaluation = new ExpressionEvaluation();
        expressionValidation = new ExpressionValidation();
    }
    // This method will take expression parts from ExpressionPartition class
    public void performCalculation() {
        // Expression is being convert into parts
        expressionPartition.convertIntoExpressionParts();
        splittedExpression = expressionPartition.getExpressionParts();
        //Validation is being done here
        if(expressionValidation.isValid(splittedExpression)) {
            //After evaluation result is being stored here
            ExpressionPart evaluatedPart = expressionEvaluation.evaluate(splittedExpression);
            printResult(evaluatedPart);
        }
        else {
            System.out.println("Expression is not valid");
        }
    }

    // This method will print the result
    private void printResult(ExpressionPart evaluatedPart) {
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