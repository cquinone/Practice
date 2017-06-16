package com.company;

public class Main {

    public static void main(String[] args) {
        useCalculateHelper();
    }

    static void useCalculateHelper() {
        String[] statements = {
                "add 1.0", // wrong format
                "add xx 25.0", // xx not a number
                "addX 0.0 0.0", // not a command
                "divide 100.0 50.0", // 100.0 / 50.0 = 2.0
                "add 25.0 92.0", // 25.0 + 92.0 = 117.0
                "subtract 225.0 17.0", // 225.0 - 17.0 208.0
                "multiply 11.0 3.0" // 11.0 * 3.0 = 33.0
        };

        /*
        //My way of using CalculateHelper
        CalculateHelper helper = new CalculateHelper();
        for (String statement: statements) { helper.process(statement); System.out.println(statement + " ->" + helper.result);}*/

        //Better way of using CalculateHelper
        System.out.println("USING ENUM/BETTER OUTPUT");
        CalculateHelper helper = new CalculateHelper();
        for (String statement: statements) {
            try {
                helper.process(statement);
                System.out.println(helper.toString());
            } catch(InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("Original exception: " + e.getCause().getMessage());
            }

        }
    }

    static void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }
    }

    static void useCalculatorBase() {
        System.out.println("USING INHERITANCE");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for (CalculateBase calculator: calculators) {
            calculator.calculate();
            System.out.print("results = ");
            System.out.println(calculator.getResult());
        }
    }

    static void useOverloads() {
        System.out.println("USING OVERLOADS");
        System.out.println();

        double leftDouble = 11.0d;
        double rightDouble = 4.0d;
        int leftInt = 11;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

    }
}
