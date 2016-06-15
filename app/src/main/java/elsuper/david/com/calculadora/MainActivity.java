package elsuper.david.com.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etResult;      private Button btnBinary;   private Button btnDelete;
    private Button btnDeleteOne;    private Button btnModule;   private Button btnEqual;
    private Button btnMulti;        private Button btnDiv;      private Button btnSum;
    private Button btnSub;          private Button btnMoreLess; private Button btnPoint;
    private Button btnZero;         private Button btnOne;      private Button btnTwo;
    private Button btnThree;        private Button btnFour;     private Button btnFive;
    private Button btnSix;          private Button btnSeven;    private Button btnEight;
    private Button btnNine;         private static boolean modeStandard = true;


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
            case R.id.main_btnDelete:
                //Limpia la pantalla
                etResult.setText("");
                break;
            case R.id.main_btnDeleteOne:
                //Borra el último caracter ingresado
                screenContent = etResult.getText().toString();
                if(!TextUtils.isEmpty(screenContent))
                //if(!screenContent.trim().equals(""))
                    screenContent = screenContent.substring(0,screenContent.length()-1);
                etResult.setText(screenContent);
                break;
            case R.id.main_btnEqual:

                break;
            //Para los operadores, valida si no hay un operador previo
            // y si ya hay, al menos, un número en pantalla
            case R.id.main_btnModule:
                screenContent = etResult.getText().toString();
                if(!existPreviousOperator(screenContent) && !TextUtils.isEmpty(screenContent))
                    etResult.setText(etResult.getText().toString() + btnModule.getText().toString());
                break;
            case R.id.main_btnMulti:
                screenContent = etResult.getText().toString();
                if(!existPreviousOperator(screenContent) && !TextUtils.isEmpty(screenContent))
                    etResult.setText(etResult.getText().toString() + btnMulti.getText().toString());
                break;
            case R.id.main_btnDiv:
                screenContent = etResult.getText().toString();
                if(!existPreviousOperator(screenContent) && !TextUtils.isEmpty(screenContent))
                    etResult.setText(etResult.getText().toString() + btnDiv.getText().toString());
                break;
            case R.id.main_btnSum:
                screenContent = etResult.getText().toString();
                if(!existPreviousOperator(screenContent) && !TextUtils.isEmpty(screenContent))
                    etResult.setText(etResult.getText().toString() + btnSum.getText().toString());
                break;
            case R.id.main_btnSub:
                screenContent = etResult.getText().toString();
                if(!existPreviousOperator(screenContent) && !TextUtils.isEmpty(screenContent))
                    etResult.setText(etResult.getText().toString() + btnSub.getText().toString());
                break;
            case R.id.main_btnMoreLess:
                screenContent = etResult.getText().toString();
                /*if(!TextUtils.isEmpty(screenContent))
                    etResult.setText("(-");
                else{

                }*/


                break;
            case R.id.main_btnPoint:
                screenContent = etResult.getText().toString();
                if(!existPreviousOperator(screenContent) && !TextUtils.isEmpty(screenContent))
                    etResult.setText(etResult.getText().toString() + btnPoint.getText().toString());
                break;
            //Para los números, si en pantalla hay un operador de igualdad "="
            //(Significa que ya se realizó una operación), se borra el contenido
            //De la pantalla y se inicia una nueva operación.
            //Si no hay signo de igualdad, se pinta el número en pantalla
            case R.id.main_btnZero:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "0");
                break;
            case R.id.main_btnOne:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "1");
                break;
            case R.id.main_btnTwo:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "2");
                break;
            case R.id.main_btnThree:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "3");
                break;
            case R.id.main_btnFour:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "4");
                break;
            case R.id.main_btnFive:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "5");
                break;
            case R.id.main_btnSix:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "6");
                break;
            case R.id.main_btnSeven:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "7");
                break;
            case R.id.main_btnEight:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "8");
                break;
            case R.id.main_btnNine:
                screenContent = etResult.getText().toString();
                if(screenContent.contains(btnEqual.getText().toString()))
                    etResult.setText("");
                etResult.setText(etResult.getText().toString() + "9");
                break;
        }
    }

    /*Dependiendo del modo en que está la calculadora (Estándar/Binaria) algunos
      botones toman un color normal o uno para indicar que están deshabilitados*/
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
      valida que no haya un operador previo en la pantalla*/
    public boolean existPreviousOperator(String screenContent) {
        if(screenContent.contains(btnModule.getText().toString()) ||
                screenContent.contains(btnMulti.getText().toString()) ||
                screenContent.contains(btnDiv.getText().toString()) ||
                screenContent.contains(btnSum.getText().toString()) ||
                screenContent.contains(btnSub.getText().toString()) ||
                screenContent.contains(btnPoint.getText().toString()) ||
                screenContent.contains(btnEqual.getText().toString()))
            return  true;
        else
            return false;
    }
}
