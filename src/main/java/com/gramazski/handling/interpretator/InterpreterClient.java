package com.gramazski.handling.interpretator;

import com.gramazski.handling.interpretator.context.ExpressionContext;
import com.gramazski.handling.interpretator.impl.nonterminal.NonterminalExpressionNumber;
import com.gramazski.handling.interpretator.impl.terminal.*;
import com.gramazski.handling.interpretator.parser.ExpressionParser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gs on 22.01.2017.
 */
public class InterpreterClient {
    private ArrayList<AbstractExpression> listExpression = new ArrayList<AbstractExpression>();

    public void setExpression(String expression){
        ExpressionParser expressionParser = new ExpressionParser();
        parse(expressionParser.parse(expression));
    }

    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }

            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpression.add(new TerminalExpressionAdd());
                    break;
                case '-':
                    listExpression.add(new TerminalExpressionSubtract());
                    break;
                case '*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                case 's':
                    listExpression.add(new TerminalExpressionSinus());
                    break;
                case 'c':
                    listExpression.add(new TerminalExpressionCosine());
                    break;
                case 'p':
                    listExpression.add(new NonterminalExpressionNumber(Math.PI));
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextDouble()) {
                        listExpression.add(
                                new NonterminalExpressionNumber(scan.nextDouble()));
                    }
                    break;
            }
        }
    }

    public Number calculate() {
        ExpressionContext context = new ExpressionContext();

        for (AbstractExpression terminal : listExpression) {
            terminal.interpret(context);
        }

        return context.popValue();
    }
}
