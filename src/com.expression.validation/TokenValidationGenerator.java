package com.expression.validation;

import com.expression.model.ExpressionData;
import com.expression.operators.Operator;

public class TokenValidationGenerator {
    public static TokenValidation getCurrentTokenValidation(String tokenValidation) {
        if(ExpressionData.isOperator(tokenValidation)) {
            return new OperatorValidation();
        }
        return new DecimalValidation();
    }
}
