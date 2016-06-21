package elsuper.david.com.calculadora;

/**
 * Andrés David García Gómez
 */
public class Calculator {

    public enum TypeOperation
    {
        SUM,
        SUSTRACTION,
        MULTIPLICATION,
        DIVISION,
        MODULE
    }

    //Operaciones posibles para esta calculadora en modo estándar
    public double standardOperation(double number1, double number2, TypeOperation operator){

        double result = 0;

        switch (operator) {
            case SUM:
                result = number1 + number2;
            break;
            case SUSTRACTION:
                result = number1 - number2;
            break;
            case MULTIPLICATION:
                result = number1 * number2;
            break;
            case DIVISION:
                result = number1 / number2;
            break;
            case MODULE:
                result = number1 % number2;
            break;
        }
        return result;
    }

    //Operaciones posibles para esta calculadora en modo binario
    public String binaryOperation(String number1, String number2, TypeOperation operator){

        String result = "";
        long operation = 0;

        //Convertimos los operandos a enteros largos
        long operand1 = Long.parseLong(number1, 2);
        long operand2 = Long.parseLong(number2, 2);

        switch (operator) {
            case SUM:
                //Hacemos la operación
                operation = operand1 + operand2;
                break;
        }

        //Convertimos a binario
        result = Long.toString(operation, 2);

        return result;
    }
}
