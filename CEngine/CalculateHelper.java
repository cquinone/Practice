package com.company;

/*
 * Created by klawal on
 */
public class CalculateHelper {
    MathCommand command;
    double leftValue;
    double rightValue;
    double result;
    private static final char ADD_SYMBOL = '+';
    private static final char SUB_SYMBOL = '-';
    private static final char MULT_SYMBOL = '*';
    private static final char DIV_SYMBOL = '/';
    private static final char EQUALS_SYMBOL = '=';

    public void process(String statement) throws InvalidStatementException{
        String[] parts = statement.split(" ");
        if (parts.length != 3)
            throw new InvalidStatementException("Incorrect # of fields", statement);

        String commandString = parts[0];

        try {
            leftValue = Double.parseDouble(parts[1]);
            rightValue = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }

        setCommandFromString(commandString);
        if (command == null)
            throw new InvalidStatementException("Invalid statement", statement);

        setResultFromCommand();
    }

    @Override
    public String toString() {
        char symbol = ' ';
        switch (command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUB_SYMBOL;
                break;
            case Multiply:
                symbol = MULT_SYMBOL;
                break;
            case Divide:
                symbol = DIV_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(' ');
        sb.append(EQUALS_SYMBOL);
        sb.append(' ');
        sb.append(result);
        return sb.toString();
    }

    private void setResultFromCommand() {
        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtracter(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();
    }

    private void setCommandFromString(String commandString) {
        if (commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }

}
