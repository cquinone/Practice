package com.company;

/*
 * Created by klawal
 */
public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;

    //Getters and Setters
    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    public MathEquation() {
    }

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute() {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                System.out.println("Error - invalid opCode");
                result = 0.0d;
                break;
        }
    }

    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal= rightVal;
        execute();
    }

    public void execute(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
        result = (int)result;
    }

    /*
     * Wrapper Class Members
     * Byte, Short Integer, Long: MIN_VALUE, MAX_VALUE, bitCount, toBinaryString
     * Float, Double: MIN_VALUE, MAX_VALUE, isDigit, isLetter
     * Boolean: TRUE, FALSE
     */

    //Integer i1000A = 10 * 10 * 10;
    //Integer i1000B = 100 * 10;
    //System.out.println(i1000A == i1000B); //prints false
    //System.out.println(i1000A.equals(i1000B)); //prints true

    //Integer i8A = 4 * 2;
    //Integer i8B = 2 * 2 * 2;
    //System.out.println(i8A == i8B); //prints true bc in the range -128 to 127

}
