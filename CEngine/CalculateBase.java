package com.company;

/*
 * Created by klawal on
 */
public abstract class CalculateBase {
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

    //Constructors
    public CalculateBase() {
    }

    public CalculateBase(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public abstract void calculate();

}

