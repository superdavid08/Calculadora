package elsuper.david.com.calculadora;

/**
 * Created by VPCF1 on 13/06/2016.
 */
public class Calculator {

    public enum TypeOperation
    {
        SUM, //0
        SUSTRACTION, //1
        MULTIPLICATION, //2
        DIVISION, //3
        MODULE //4
    }

    public double standardOperation(double number1, double number2, TypeOperation operator){

        double result = 0;

        switch (operator.ordinal()) {
            case 0:
                result = number1 + number2;
            break;
            case 1:
                result = number1 - number2;
            break;
            case 2:
                result = number1 * number2;
            break;
            case 3:
                result = number1 / number2;
            break;
            case 4:
                result = number1 % number2;
            break;
        }
        return result;
    }


    public String binaryOperation(String number1, String number2, TypeOperation operator){

        switch (operator.ordinal()) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        return "";
    }
}
