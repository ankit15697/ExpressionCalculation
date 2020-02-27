package com.expression.validation;

import com.expression.part.ExpressionPart;

import java.util.LinkedList;

interface TokenValidation {
    boolean performValidation(LinkedList<ExpressionPart> currentExp, int currentIndex);
}