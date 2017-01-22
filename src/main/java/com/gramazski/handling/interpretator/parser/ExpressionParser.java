package com.gramazski.handling.interpretator.parser;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by gs on 22.01.2017.
 */
public class ExpressionParser {
    private Deque<Character> expressionStack = new ArrayDeque<Character>();

    public String parse(String expression){
        String parsingExpression = "";
        int i = 0;
        int priority = 0;

        while (i < expression.length()){
            Character currentSymbol = expression.charAt(i);
            priority = getPriority(currentSymbol);
            i++;

            if (priority == 5){
                parsingExpression += currentSymbol;
                parsingExpression += " ";
            }
            else {
                if (!(expressionStack.isEmpty()) && (priority != 0)){
                    Boolean outFromCycleFlag = false;

                    do {
                        Character symbolFromStack = expressionStack.pop();
                        if (priority > getPriority(symbolFromStack)){
                            outFromCycleFlag = true;
                            expressionStack.push(symbolFromStack);
                        }
                        else {
                            parsingExpression += symbolFromStack;
                            parsingExpression += " ";
                        }
                    }while (!(outFromCycleFlag) && !(expressionStack.isEmpty()));
                }

                if (priority == 1){
                    expressionStack.pop();
                }
                else {
                    expressionStack.push(currentSymbol);
                }
            }
        }

        if (!expressionStack.isEmpty()){
            for (Character symbolFromStack : expressionStack) {
                parsingExpression += symbolFromStack;
                parsingExpression += " ";
            }
        }

        return parsingExpression.trim();
    }

    //Change on list
    private int getPriority(Character symbol){
        int priority = 0;

        switch (symbol){
            case '(':
                priority = 0;
                break;
            case ')':
                priority = 1;
                break;
            case '-':
            case '+':
                priority = 2;
                break;
            case '/':
            case '*':
                priority = 3;
                break;
            case 's':
            case 'c':
                priority = 4;
                break;
            default:
                priority = 5;
                break;
        }

        return priority;
    }
}
