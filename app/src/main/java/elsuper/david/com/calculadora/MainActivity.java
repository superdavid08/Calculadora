package elsuper.david.com.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etResult;      private Button btnBinary;   private Button btnDelete;
    private Button btnDeleteOne;    private Button btnModule;   private Button btnEqual;
    private Button btnMulti;        private Button btnDiv;      private Button btnSum;
    private Button btnSub;          private Button btnMoreLess; private Button btnPoint;
    private Button btnZero;         private Button btnOne;      private Button btnTwo;
    private Button btnThree;        private Button btnFour;     private Button btnFive;
    private Button btnSix;          private Button btnSeven;    private Button btnEight;
    private Button btnNine;

    private static boolean modeStandard = true;
    private static String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos los controles
        etResult = (EditText)findViewById(R.id.main_etResult);
        btnBinary = (Button)findViewById(R.id.main_btnBinary);
        btnDelete = (Button)findViewById(R.id.main_btnDelete);
        btnDeleteOne = (Button)findViewById(R.id.main_btnDeleteOne);
        btnModule = (Button)findViewById(R.id.main_btnModule);
        btnEqual = (Button)findViewById(R.id.main_btnEqual);
        btnMulti = (Button)findViewById(R.id.main_btnMulti);
        btnDiv = (Button)findViewById(R.id.main_btnDiv);
        btnSum = (Button)findViewById(R.id.main_btnSum);
        btnSub = (Button)findViewById(R.id.main_btnSub);
        btnMoreLess = (Button)findViewById(R.id.main_btnMoreLess);
        btnPoint = (Button)findViewById(R.id.main_btnPoint);
        btnZero = (Button)findViewById(R.id.main_btnZero);
        btnOne = (Button)findViewById(R.id.main_btnOne);
        btnTwo = (Button)findViewById(R.id.main_btnTwo);
        btnThree = (Button)findViewById(R.id.main_btnThree);
        btnFour = (Button)findViewById(R.id.main_btnFour);
        btnFive = (Button)findViewById(R.id.main_btnFive);
        btnSix = (Button)findViewById(R.id.main_btnSix);
        btnSeven = (Button)findViewById(R.id.main_btnSeven);
        btnEight = (Button)findViewById(R.id.main_btnEight);
        btnNine = (Button)findViewById(R.id.main_btnNine);

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

        //Para almacenar la cadena existente en pantalla
        String screenContent;

        switch (v.getId()){
            //Para el botón del modo (Estándar/Binario)
            case R.id.main_btnBinary:
                modeStandard = !modeStandard;
                //Limpiamos la pantalla
                etResult.setText("");
                //Dependiendo del modo, se habilitan o deshabilitan algunos botones
                btnModule.setEnabled(modeStandard);     btnMulti.setEnabled(modeStandard);
                btnDiv.setEnabled(modeStandard);        btnSub.setEnabled(modeStandard);
                btnMoreLess.setEnabled(modeStandard);   btnPoint.setEnabled(modeStandard);
                btnTwo.setEnabled(modeStandard);        btnThree.setEnabled(modeStandard);
                btnFour.setEnabled(modeStandard);       btnFive.setEnabled(modeStandard);
                btnSix.setEnabled(modeStandard);        btnSeven.setEnabled(modeStandard);
                btnEight.setEnabled(modeStandard);      btnNine.setEnabled(modeStandard);
                PaintButtons(modeStandard);
                break;
            case R.id.main_btnDelete:
                //Limpia la pantalla
                etResult.setText("");
                break;
            case R.id.main_btnDeleteOne: //Borra el último caracter ingresado
                screenContent = etResult.getText().toString();
                //Si ya hay un resultado en pantalla, aplica la misma funcionalidad de botón btnDelete
                if(screenContent.contains(btnEqual.getText().toString())) {
                    //Limpia la pantalla
                    etResult.setText("");
                    break;
                }

                // Si el caracter es un operador
                if(screenContent.endsWith(operator)){
                    //Si es un número negativo, además del operador borramos el parentesis de cierre ")"
                    if(screenContent.contains("(-"))
                        screenContent = screenContent.substring(0,screenContent.length()-2);
                    else
                        screenContent = screenContent.substring(0,screenContent.length()-1);

                    etResult.setText(screenContent);
                    break;
                }

                //Si no hay un operador se va borrando el operando de la izquierda
                if (!existPreviousOperator(screenContent)) {
                    //Si hay un último número y éste es negativo, borra también su signo
                    if(screenContent.contains("(") && screenContent.length() == 3) //Por ejemplo "(-3"
                        etResult.setText("");
                    else{ // borra el caracter
                        if(!TextUtils.isEmpty(screenContent)) //if(!screenContent.trim().equals(""))
                            screenContent = screenContent.substring(0,screenContent.length()-1);
                        etResult.setText(screenContent);
                    }
                }
                else{ //Si hay un operador se va borrando el operando de la izquierda
                    String operands[] = screenContent.split(operator);
                    if(operands[1].contains("(") && operands[1].length() == 3) //Por ejemplo "(-3"
                        etResult.setText(operands[0] + operator);
                    else{ // borra el caracter
                        screenContent = screenContent.substring(0,screenContent.length()-1);
                        etResult.setText(screenContent);
                    }
                }
                break;
            case R.id.main_btnEqual:
                OperationProcess();
                break;
            case R.id.main_btnModule: case R.id.main_btnMulti: case R.id.main_btnDiv:
            case R.id.main_btnSum: case R.id.main_btnSub:
                operatorDisplay(v);
                break;
            case R.id.main_btnMoreLess: //Para cambiar de positivo a negativo y viceversa
                screenContent = etResult.getText().toString();
                //Si ya hay un resultado en pantalla, lo tomamos como operación nueva
                if(screenContent.contains(btnEqual.getText().toString())) {
                    String partsResult[] = screenContent.split(btnEqual.getText().toString());
                    if(partsResult[1].startsWith("(-")) {//Si es negativo se le quita el signo
                        screenContent = screenContent.substring(2,screenContent.length()-1);
                        etResult.setText(screenContent);
                    }
                    else //Si es positivo se le agraga el signo
                        etResult.setText("(-" + screenContent + ")");

                    break;
                }

                //Si no hay un operador significa que sólo hay un operando
                if (!existPreviousOperator(screenContent)) {
                    //Si es negativo se le quita el signo
                    if (screenContent.contains("(-") || screenContent.contains("(")) {
                        screenContent.replace("(-", "").replace("(", "").replace(")", "");
                        etResult.setText(screenContent);
                    }
                    else//Si es positivo se le agraga el signo
                        etResult.setText("(-" + screenContent);

                }
                else { //Si hay un operador
                    String operands[] = screenContent.split(operator);
                    //Si es negativo se le quita el signo
                    if (operands[1].contains("(-") || operands[1].contains("(")) {
                        operands[1].replace("(-", "").replace("(", "").replace(")", "");
                        etResult.setText(operands[0] + operator + operands[1]);
                    }
                    else//Si es positivo se le agraga el signo
                        etResult.setText(operands[0] + operator + "(-" + operands[1]);
                }
                break;
            case R.id.main_btnPoint:
                screenContent = etResult.getText().toString();
                //Si ya hay un resultado en pantalla, lo tomamos como operación nueva
                if(screenContent.contains(btnEqual.getText().toString())) {
                    String partsResult[] = screenContent.split(btnEqual.getText().toString());
                    etResult.setText(partsResult[1] + btnPoint.getText().toString());
                    break;
                }

                //Si no hay en pantalla un operador, se valida si hay un punto existente
                if (!existPreviousOperator(screenContent)) {
                    if (!screenContent.contains(".")) {
                        etResult.setText(etResult.getText().toString() + btnPoint.getText().toString());
                    }
                }
                else {
                    //Si hay en pantalla un operador, se valida si hay un punto existente en el lado derecho del operador
                    String operands[] = screenContent.split(operator);
                    if(operands.length == 1)
                        etResult.setText(etResult.getText().toString() + btnPoint.getText().toString());
                    if(operands.length > 1 && !operands[1].contains(".")) {
                        etResult.setText(etResult.getText().toString() + btnPoint.getText().toString());
                    }
                }

                break;
            case R.id.main_btnZero: case R.id.main_btnOne: case R.id.main_btnTwo: case R.id.main_btnThree:
            case R.id.main_btnFour: case R.id.main_btnFive: case R.id.main_btnSix: case R.id.main_btnSeven:
            case R.id.main_btnEight: case R.id.main_btnNine:
                numberDisplay(v);
                break;
        }
    }

    //region Métodos
    private void OperationProcess() {
        //Para almacenar la cadena existente en pantalla
        String screenContent = etResult.getText().toString();
        Calculator calculator = new Calculator();

        //Si hay un operador y la cadena termina con un cierre de parentesis o
        // un número, la operación puede realizarse
        if( existPreviousOperator(screenContent) &&
                (screenContent.endsWith(")") || screenContent.endsWith("0") || screenContent.endsWith("1") ||
                        screenContent.endsWith("2") || screenContent.endsWith("3") || screenContent.endsWith("4") ||
                        screenContent.endsWith("5") || screenContent.endsWith("6") || screenContent.endsWith("7") ||
                        screenContent.endsWith("8") || screenContent.endsWith("9")) ){
            //Modo binario
            if(btnBinary.getText().equals(R.string.main_binary)) {
                Toast.makeText(getApplicationContext(),"Binario", Toast.LENGTH_SHORT).show();
            }
            else { //Modo estándar
                StringTokenizer tokens = new StringTokenizer(screenContent, operator);
                //Log.v("David", tokens.countTokens() + " Num Tokens");
                String stringNumber1 = "0";
                String stringNumber2 = "0";
                boolean negativOperand2 = false;

                int counter = 0;
                //Separamos los operandos
                while (tokens.hasMoreTokens()) {
                    //Log.v("David", tokens.nextToken() + "");
                    if(counter== 0)
                        stringNumber1 = tokens.nextToken().replace("(", "").replace(")", "");
                    else {
                        stringNumber2 = tokens.nextToken();

                        if(stringNumber2.contains("("))
                            negativOperand2 = true;

                        stringNumber2 = stringNumber2.replace("(", "").replace(")", "");
                    }
                    counter++;
                }

                double number1 = Double.parseDouble(stringNumber1);
                double number2 = Double.parseDouble(stringNumber2);
                double result = 0;

                switch (operator) {
                    case " + ":
                        result = calculator.standardOperation(number1,number2, Calculator.TypeOperation.SUM);
                        break;
                    case " - ":
                        result = calculator.standardOperation(number1,number2, Calculator.TypeOperation.SUSTRACTION);
                        break;
                    case " x ":
                        result = calculator.standardOperation(number1,number2, Calculator.TypeOperation.MULTIPLICATION);
                        break;
                    case " / ":
                        if(number2 == 0) {
                            Toast.makeText(getApplicationContext(), R.string.main_invalidOperation, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else
                            result = calculator.standardOperation(number1, number2, Calculator.TypeOperation.DIVISION);
                        break;
                    case " % ":
                        if(number2 == 0) {
                            Toast.makeText(getApplicationContext(), R.string.main_invalidOperation, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else
                            result = calculator.standardOperation(number1,number2, Calculator.TypeOperation.MODULE);
                        break;
                }

                //Si hay un parentesis abierto, lo cerramos
                if(negativOperand2)
                    etResult.setText(etResult.getText().toString() + ")");

                if(result <0)
                    etResult.setText(etResult.getText().toString() + " = (-" + result + ")");
                else
                    etResult.setText(etResult.getText().toString() + " = " + result);
            }
        }
    }

    //Para los números, si en pantalla hay un operador de igualdad "="
    //(Significa que ya se realizó una operación), se borra el contenido
    //De la pantalla y se inicia una nueva operación.
    //Si no hay signo de igualdad, se pinta el número en pantalla
    private void numberDisplay(View v) {
        //Para almacenar la cadena existente en pantalla
        String screenContent = etResult.getText().toString();
        screenContent = etResult.getText().toString();
        if(screenContent.contains(btnEqual.getText().toString())) {
            String partsResult[] = screenContent.split(btnEqual.getText().toString());
            etResult.setText(partsResult[1] + etResult.getText().toString() + ((Button)v).getText().toString());
        }
        else
            etResult.setText(etResult.getText().toString() + ((Button)v).getText().toString());
    }

    /*Para los operadores, valida que no haya un operador previo
      y al menos un número en pantalla. También se toma en cuenta si ya
      hay una operación resuelta para tomar su resultado como primer operando
      de una operación nueva.*/
    private void operatorDisplay(View v) {
        //Para almacenar la cadena existente en pantalla
        String screenContent = etResult.getText().toString();
        //Si ya hay un resultado en pantalla, lo tomamos como operación nueva
        if(screenContent.contains(btnEqual.getText().toString())) {
            String partsResult[] = screenContent.split(btnEqual.getText().toString());
            etResult.setText(partsResult[1] + ((Button)v).getText().toString());
            operator = ((Button)v).getText().toString();
        }
        else if (!existPreviousOperator(screenContent) && !TextUtils.isEmpty(screenContent)){
                if(screenContent.contains("(-")) //Si es un número negativo se cierra el parentesis
                    etResult.setText(etResult.getText().toString() + ")");
            etResult.setText(etResult.getText().toString() + ((Button)v).getText().toString());
            operator = ((Button)v).getText().toString();
        }
    }

    /*Dependiendo del modo en que está la calculadora (Estándar/Binaria) algunos
      botones toman un color normal o uno para indicar que están deshabilitados.*/
    private void PaintButtons(boolean modeStandard) {
        if(modeStandard){
            btnBinary.setText(R.string.main_binary);
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
        }
        else
        {
            btnBinary.setText(R.string.main_standard);
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

    /*Como esta calculadora sólo realiza una operación a la vez,
      valida que no haya un operador previo en la pantalla.*/
    public boolean existPreviousOperator(String screenContent) {
        if(screenContent.contains(btnModule.getText().toString()) ||
                screenContent.contains(btnMulti.getText().toString()) ||
                screenContent.contains(btnDiv.getText().toString()) ||
                screenContent.contains(btnSum.getText().toString()) ||
                screenContent.contains(btnSub.getText().toString())
                //screenContent.contains(btnPoint.getText().toString()) ||
                //screenContent.contains(btnEqual.getText().toString())
        )
            return  true;

        else
            return false;
    }
    //endregion
}