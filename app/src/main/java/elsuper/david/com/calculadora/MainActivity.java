package elsuper.david.com.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Andrés David García Gómez
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "Log_Calculator";

    private EditText etResult;          private Button btnBinary;   private Button btnDelete;
    private ImageButton btnDeleteOne;   private Button btnModule;   private Button btnEqual;
    private Button btnMulti;            private Button btnDiv;      private Button btnSum;
    private Button btnSub;              private Button btnMoreLess; private Button btnPoint;
    private Button btnZero;             private Button btnOne;      private Button btnTwo;
    private Button btnThree;            private Button btnFour;     private Button btnFive;
    private Button btnSix;              private Button btnSeven;    private Button btnEight;
    private Button btnNine;

    //Para saber si la calculadora está en modo estándar o binario
    private static boolean modeStandard = true;
    //Contendrá el texto de algún botón "operador", por ejemplo " + " (con el espacio incluido antes y despues)
    private static String operator;
    //Para almacenar la cadena existente en pantalla
    private static String screenContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos los controles
        etResult = (EditText) findViewById(R.id.main_etResult);
        btnBinary = (Button) findViewById(R.id.main_btnBinary);
        btnDelete = (Button) findViewById(R.id.main_btnDelete);
        btnDeleteOne = (ImageButton) findViewById(R.id.main_btnDeleteOne);
        btnModule = (Button) findViewById(R.id.main_btnModule);
        btnEqual = (Button) findViewById(R.id.main_btnEqual);
        btnMulti = (Button) findViewById(R.id.main_btnMulti);
        btnDiv = (Button) findViewById(R.id.main_btnDiv);
        btnSum = (Button) findViewById(R.id.main_btnSum);
        btnSub = (Button) findViewById(R.id.main_btnSub);
        btnMoreLess = (Button) findViewById(R.id.main_btnMoreLess);
        btnPoint = (Button) findViewById(R.id.main_btnPoint);
        btnZero = (Button) findViewById(R.id.main_btnZero);
        btnOne = (Button) findViewById(R.id.main_btnOne);
        btnTwo = (Button) findViewById(R.id.main_btnTwo);
        btnThree = (Button) findViewById(R.id.main_btnThree);
        btnFour = (Button) findViewById(R.id.main_btnFour);
        btnFive = (Button) findViewById(R.id.main_btnFive);
        btnSix = (Button) findViewById(R.id.main_btnSix);
        btnSeven = (Button) findViewById(R.id.main_btnSeven);
        btnEight = (Button) findViewById(R.id.main_btnEight);
        btnNine = (Button) findViewById(R.id.main_btnNine);

        //Agregamos el 'escucha' a todos los botones
        findViewById(R.id.main_btnBinary).setOnClickListener(this);
        findViewById(R.id.main_btnDelete).setOnClickListener(this);
        findViewById(R.id.main_btnDeleteOne).setOnClickListener(this);
        findViewById(R.id.main_btnModule).setOnClickListener(this);
        findViewById(R.id.main_btnEqual).setOnClickListener(this);
        findViewById(R.id.main_btnMulti).setOnClickListener(this);
        findViewById(R.id.main_btnDiv).setOnClickListener(this);
        findViewById(R.id.main_btnSum).setOnClickListener(this);
        findViewById(R.id.main_btnSub).setOnClickListener(this);
        findViewById(R.id.main_btnMoreLess).setOnClickListener(this);
        findViewById(R.id.main_btnPoint).setOnClickListener(this);
        findViewById(R.id.main_btnZero).setOnClickListener(this);
        findViewById(R.id.main_btnOne).setOnClickListener(this);
        findViewById(R.id.main_btnTwo).setOnClickListener(this);
        findViewById(R.id.main_btnThree).setOnClickListener(this);
        findViewById(R.id.main_btnFour).setOnClickListener(this);
        findViewById(R.id.main_btnFive).setOnClickListener(this);
        findViewById(R.id.main_btnSix).setOnClickListener(this);
        findViewById(R.id.main_btnSeven).setOnClickListener(this);
        findViewById(R.id.main_btnEight).setOnClickListener(this);
        findViewById(R.id.main_btnNine).setOnClickListener(this);
    }

    @Override
    /*Manejo del evento*/
    public void onClick(View v) {

        try {
            switch (v.getId()) {
                //Para el botón del modo (Estándar/Binario)
                case R.id.main_btnBinary:
                    modeStandard = !modeStandard;
                    //Limpiamos la pantalla
                    etResult.setText("");
                    //Dependiendo del modo, se habilitan o deshabilitan algunos botones
                    btnModule.setEnabled(modeStandard);
                    btnMulti.setEnabled(modeStandard);
                    btnDiv.setEnabled(modeStandard);
                    btnSub.setEnabled(modeStandard);
                    btnMoreLess.setEnabled(modeStandard);
                    btnPoint.setEnabled(modeStandard);
                    btnTwo.setEnabled(modeStandard);
                    btnThree.setEnabled(modeStandard);
                    btnFour.setEnabled(modeStandard);
                    btnFive.setEnabled(modeStandard);
                    btnSix.setEnabled(modeStandard);
                    btnSeven.setEnabled(modeStandard);
                    btnEight.setEnabled(modeStandard);
                    btnNine.setEnabled(modeStandard);
                    PaintButtons(modeStandard);
                    break;
                case R.id.main_btnZero:
                case R.id.main_btnOne:
                case R.id.main_btnTwo:
                case R.id.main_btnThree:
                case R.id.main_btnFour:
                case R.id.main_btnFive:
                case R.id.main_btnSix:
                case R.id.main_btnSeven:
                case R.id.main_btnEight:
                case R.id.main_btnNine:
                    numberDisplay(v);
                    break;
                case R.id.main_btnModule:
                case R.id.main_btnMulti:
                case R.id.main_btnDiv:
                case R.id.main_btnSum:
                case R.id.main_btnSub:
                    operatorDisplay(v);
                    break;
                case R.id.main_btnEqual:
                    OperationProcess();
                    break;
                case R.id.main_btnDelete:
                    //Limpia la pantalla
                    etResult.setText("");
                    break;
                case R.id.main_btnPoint:
                    pointProcess();
                    break;
                case R.id.main_btnDeleteOne:
                    //Borra el último caracter ingresado
                    deleteOneProcess();
                    break;
                case R.id.main_btnMoreLess:
                    //Para cambiar de positivo a negativo y viceversa
                    moreLessProcess();
                    break;
            }

            //Ponemos siempre visible el último caracter ingresado o el último del resultado
            etResult.setSelection(etResult.getText().length());
        }
        catch (Exception ex){
            modeStandard = true;
            operator = "";
            screenContent = "";
            Log.e(TAG,ex.getMessage());
            Toast.makeText(getApplicationContext(), R.string.main_txtCrash, Toast.LENGTH_SHORT).show();
        }
    }

    //region Métodos

    //Cambio de signo para alguno de los operandos
    private void moreLessProcess() {
        screenContent = etResult.getText().toString();

        //Si ya hay un resultado en pantalla, lo tomamos como operación nueva
        if (screenContent.contains(btnEqual.getText().toString())) {
            String partsResult[] = screenContent.split(btnEqual.getText().toString());
            if (partsResult[1].startsWith("(-")) {//Si es negativo se le quita el signo
                screenContent = partsResult[1].replace("(-", "").replace(")", "");
                etResult.setText(screenContent);
            } else //Si es positivo se le agrega el signo
                etResult.setText("(-" + partsResult[1]);

            return;
        }

        //Si no hay un operador significa que sólo hay un operando
        if (!existPreviousOperator(screenContent)) {
            //Si es negativo se le quita el signo
            if (screenContent.contains("(-")) {
                screenContent = screenContent.replace("(-", "");
                etResult.setText(screenContent);
            } else//Si es positivo o la pantalla está limpia se le agrega el signo
                etResult.setText("(-" + screenContent);

        } else { //Si hay un operador
            String operands[] = screenContent.split(" \\" + operator.trim() + " ");

            //Es el siguiente caracter después del operador
            if ((operands.length == 1) ) {
                etResult.setText(operands[0] + operator + "(-");
            }
            else {
                //Si es negativo se le quita el signo
                if (operands.length > 1 && operands[1].contains("(-")) {
                    operands[1] = operands[1].replace("(-", "");
                    etResult.setText(operands[0] + operator + operands[1]);
                } else//Si es positivo o aún no tiene números el operando 2 se le agrega el signo
                    etResult.setText(operands[0] + operator + "(-" + operands[1]);
            }
        }
    }

    //Borra el último caracter ingresado. En caso de ser un espacio en blanco, que sólo
    //se dará al llegar a un operador, por ejemplo " + ", se borran los 3 caracteres aunque
    //el usuario sólo perciba que se borra dicho operador.
    private void deleteOneProcess() {
        screenContent = etResult.getText().toString();

        //Si ya hay un resultado en pantalla, aplica la misma funcionalidad de botón btnDelete
        if (screenContent.contains(btnEqual.getText().toString())) {
            //Limpia la pantalla
            etResult.setText("");
            return;
        }

        // Si el caracter es el principio de un operador
        if (screenContent.endsWith(operator)) { //Por ejemplo " - "
            //Si es un número negativo, además del operador borramos el parentesis de cierre ")"
            if (screenContent.contains("(-")) //Por ejemplo (-10)_x_   --> queda (-10
                screenContent = screenContent.substring(0, screenContent.length() - 4);
            else//Por ejemplo 10_x_   --> queda 10
                screenContent = screenContent.substring(0, screenContent.length() - 3);

            etResult.setText(screenContent);
            return;
        }

        //Si no hay un operador se va borrando el operando 1
        if (!existPreviousOperator(screenContent)) {
            //Si hay un último número y éste es negativo, borra también su signo
            if (screenContent.contains("(") && screenContent.length() == 3) //Por ejemplo "(-3"
                etResult.setText("");
            else { // borra el caracter
                if (!TextUtils.isEmpty(screenContent)) //if(!screenContent.trim().equals(""))
                    screenContent = screenContent.substring(0, screenContent.length() - 1);
                etResult.setText(screenContent);
            }
        } else { //Si hay un operador se va borrando el operando 2
            String operands[] = screenContent.split(" \\" + operator.trim() + " ");
            if (operands[1].contains("(") && operands[1].length() == 3) //Por ejemplo "(-3"
                etResult.setText(operands[0] + operator);
            else { // borra el caracter
                screenContent = screenContent.substring(0, screenContent.length() - 1);
                etResult.setText(screenContent);
            }
        }
    }

    //Si en pantalla hay un operador de igualdad "=" (Significa que ya se realizó
    // una operación), se borra el contenido de la pantalla y se inicia una nueva operación.
    //Si no hay signo de igualdad, se valida que no exista ya un punto en el operando en el que
    //se encuentre tecleando el usuario
    private void pointProcess() {
        screenContent = etResult.getText().toString();

        //Si ya hay un resultado en pantalla, lo tomamos como operación nueva
        if (screenContent.contains(btnEqual.getText().toString())) {
            etResult.setText(btnPoint.getText().toString());
            return;
        }

        //Si no hay en pantalla un operador (está en el operando 1), se valida si hay un punto existente
        if (!existPreviousOperator(screenContent)) {
            if (!screenContent.contains(".")) {
                etResult.setText(etResult.getText().toString() + btnPoint.getText().toString());
            }
        } else {
            //Si hay en pantalla un operador (está en el operando 2), se valida si hay un punto
            //existente en el lado derecho del operador
            String operands[] = screenContent.split(" \\" + operator.trim() + " ");

            //Es el siguiente caracter después del operador, se pinta el punto (Lado izq de la condición)
            //Si el operando 2 ya tiene números pero no contiene punto, se agrega. (Lado der de la condición)
            if ((operands.length == 1) || (operands.length > 1 && !operands[1].contains(".")))
                etResult.setText(etResult.getText().toString() + btnPoint.getText().toString());
        }
    }

    /*Dependiendo del modo en que está la calculadora (Estándar/Binaria) algunos
      botones toman un color normal o uno para indicar que están deshabilitados.*/
    private void PaintButtons(boolean modeStandard) {
        if (modeStandard) {
            btnBinary.setText(R.string.main_txtModeBinary);
            btnModule.setBackgroundResource(R.color.colorBtnOperators);
            btnMulti.setBackgroundResource(R.color.colorBtnOperators);
            btnDiv.setBackgroundResource(R.color.colorBtnOperators);
            btnSub.setBackgroundResource(R.color.colorBtnOperators);
            btnMoreLess.setBackgroundResource(R.color.colorButton);
            btnPoint.setBackgroundResource(R.color.colorButton);
            btnTwo.setBackgroundResource(R.color.colorButton);
            btnThree.setBackgroundResource(R.color.colorButton);
            btnFour.setBackgroundResource(R.color.colorButton);
            btnFive.setBackgroundResource(R.color.colorButton);
            btnSix.setBackgroundResource(R.color.colorButton);
            btnSeven.setBackgroundResource(R.color.colorButton);
            btnEight.setBackgroundResource(R.color.colorButton);
            btnNine.setBackgroundResource(R.color.colorButton);
        } else {
            btnBinary.setText(R.string.main_txtModeStandard);
            btnModule.setBackgroundResource(R.color.colorBtnDisabled);
            btnMulti.setBackgroundResource(R.color.colorBtnDisabled);
            btnDiv.setBackgroundResource(R.color.colorBtnDisabled);
            btnSub.setBackgroundResource(R.color.colorBtnDisabled);
            btnMoreLess.setBackgroundResource(R.color.colorBtnDisabled);
            btnPoint.setBackgroundResource(R.color.colorBtnDisabled);
            btnTwo.setBackgroundResource(R.color.colorBtnDisabled);
            btnThree.setBackgroundResource(R.color.colorBtnDisabled);
            btnFour.setBackgroundResource(R.color.colorBtnDisabled);
            btnFive.setBackgroundResource(R.color.colorBtnDisabled);
            btnSix.setBackgroundResource(R.color.colorBtnDisabled);
            btnSeven.setBackgroundResource(R.color.colorBtnDisabled);
            btnEight.setBackgroundResource(R.color.colorBtnDisabled);
            btnNine.setBackgroundResource(R.color.colorBtnDisabled);
        }
    }

    //Para los números, si en pantalla hay un operador de igualdad "="
    //(Significa que ya se realizó una operación), se borra el contenido
    //De la pantalla y se inicia una nueva operación.
    //Si no hay signo de igualdad, se pinta el número en pantalla
    private void numberDisplay(View v) {
        screenContent = etResult.getText().toString();

        if (screenContent.contains(btnEqual.getText().toString())) {
            etResult.setText(((Button) v).getText().toString());
        } else
            etResult.setText(etResult.getText().toString() + ((Button) v).getText().toString());
    }

    /*Para los operadores, valida que no haya un operador previo
      y que exista al menos un número en pantalla. También se toma en cuenta si ya
      hay una operación resuelta para tomar su resultado como primer operando
      de una operación nueva.*/
    private void operatorDisplay(View v) {
        screenContent = etResult.getText().toString();

        //Si ya hay un resultado en pantalla, lo tomamos como operación nueva
        if (screenContent.contains(btnEqual.getText().toString())) {
            String partsResult[] = screenContent.split(btnEqual.getText().toString());
            etResult.setText(partsResult[1] + ((Button) v).getText().toString());
            //Guardamos el operador
            operator = ((Button) v).getText().toString();
        } else if (!existPreviousOperator(screenContent) && screenContent.matches(".*[0-9]$")) {
            if (screenContent.contains("(-")) //Si es un número negativo el operando 1, se cierra el parentesis
                etResult.setText(etResult.getText().toString() + ")");

            etResult.setText(etResult.getText().toString() + ((Button) v).getText().toString());
            //Guardamos el operador
            operator = ((Button) v).getText().toString();
        }
    }

    /*Como esta calculadora sólo realiza una operación a la vez,
      valida que no haya un operador previo en la pantalla.*/
    public boolean existPreviousOperator(String screenContent) {
        if (screenContent.contains(btnModule.getText().toString()) ||
                screenContent.contains(btnMulti.getText().toString()) ||
                screenContent.contains(btnDiv.getText().toString()) ||
                screenContent.contains(btnSum.getText().toString()) ||
                screenContent.contains(btnSub.getText().toString()))
            return true;

        else
            return false;
    }

    //Realiza la operación
    private void OperationProcess() {
        screenContent = etResult.getText().toString();

        //Si ya hay un resultado en pantalla, dejamos el resultado igual
        if (screenContent.contains(btnEqual.getText().toString())) {
            return;
        }

        //Instancia de la calculadora para realizar la operación solicitada
        Calculator calculator = new Calculator();
        //Para el tipo de operación (+,-,*,/,%)
        Calculator.TypeOperation typeOperation = null;

        //Si hay un operador y la cadena termina con un cierre de parentesis o
        // un número, la operación puede realizarse
        if (existPreviousOperator(screenContent) && screenContent.matches(".*[)0-9]$")) {

            //Asignamos el tipo de operación
            switch (operator) {
                case " + ":
                    typeOperation = Calculator.TypeOperation.SUM;
                    break;
                case " - ":
                    typeOperation = Calculator.TypeOperation.SUSTRACTION;
                    break;
                case " * ":
                    typeOperation = Calculator.TypeOperation.MULTIPLICATION;
                    break;
                case " / ":
                    typeOperation = Calculator.TypeOperation.DIVISION;
                    break;
                case " % ":
                    typeOperation = Calculator.TypeOperation.MODULE;
                    break;
            }

            //Extraemos los operandos
            String operands[] = screenContent.split(" \\" + operator.trim() + " ");
            //Quitamos los parentesis, si tienen
            String stringNumber1 = operands[0].replace("(", "").replace(")", "");
            String stringNumber2 = operands[1];

            //Si hay un parentesis abierto, es decir, es un núm negativo, lo cerramos (en pantalla)
            if(stringNumber2.contains("("))
                etResult.setText(etResult.getText().toString() + ")");

            stringNumber2 = operands[1].replace("(", "");


            //Modo estándar
            if (modeStandard) {
                //hacemos la conversión
                double number1 = Double.parseDouble(stringNumber1);
                double number2 = Double.parseDouble(stringNumber2);
                double result = 0;

                //Validando la división entre cero
                if((typeOperation == Calculator.TypeOperation.DIVISION || typeOperation == Calculator.TypeOperation.MODULE)
                        && number2 == 0){
                    Toast.makeText(getApplicationContext(), R.string.main_txtInvalidOperation, Toast.LENGTH_SHORT).show();
                    return;
                }

                //Hacemos la operación
                result = calculator.standardOperation(number1,number2, typeOperation);

                //si el resultado es negativo agregamos el parentesis
                if (result < 0)
                    etResult.setText(etResult.getText().toString() + " = (" + result + ")");
                else
                    etResult.setText(etResult.getText().toString() + " = " + result);
            }
            else { //Modo binario
                //Hacemos la operación
                etResult.setText(etResult.getText().toString() +
                        " = " + calculator.binaryOperation(stringNumber1, stringNumber2, typeOperation));
            }
        }
    }

    //endregion
}