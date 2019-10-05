package om.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity {

    final char ADD = '+', SUB = '-', MUL = 'x', DIV = '/', NO_OPERATOR = '\0';

    Double ans;
    String input;
    char operator;

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEq, buttonC, buttonDot, buttonNeg;

    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonEq = findViewById(R.id.buttonEq);
        buttonC = findViewById(R.id.buttonC);
        buttonDot = findViewById(R.id.buttonDot);
        buttonNeg = findViewById(R.id.buttonNeg);
        display = findViewById(R.id.display);

        resetDefaultValues();

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('0');
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('1');
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('2');
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('3');
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('4');
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('5');
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('6');
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('7');
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('8');
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addCharToInput('9');
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (input.isEmpty()){
                    input = "0";
                }
                if (!input.contains(".")) {
                    addCharToInput('.');
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                resetDefaultValues();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOperation();
                operator = ADD;
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOperation();
                operator = SUB;
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOperation();
                operator = MUL;
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.isEmpty()) {
                    doOperation();
                }
                operator = DIV;
            }
        });

        buttonNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.isEmpty() & ans != null) {
                    ans = -ans;
                    display.setText(Double.toString(ans));
                } else if (input.isEmpty()) {
                    input = "-0";
                    display.setText(input);
                } else if (!input.equals("NaN")) {
                    if (input.startsWith("-")){
                        input = input.substring(1, input.length());
                    } else {
                        input = "-" + input;
                    }
                    display.setText(input);
                }
            }
        });

        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOperation();
            }
        });
    }

    private void addCharToInput(char c){
        if (input.equals("0") && c != '.') {
            input = "" + c;
        } else if (input.equals("-0") && c != '.') {
            input = "-" + c;
        } else {
            input = input + c;
        }

        setDisplayText(input);
    }

    private void doOperation(){
        if (ans == null) {
            // Doing the very first operation when ans is still NaN
            ans = Double.parseDouble(input);
            input = "";
        } else if (!input.isEmpty()) {
            double inputDouble = Double.parseDouble(input);

            switch (operator){
                case ADD:
                    ans = ans + inputDouble;
                    break;
                case SUB:
                    ans = ans - inputDouble;
                    break;
                case MUL:
                    ans = ans * inputDouble;
                    break;
                case DIV:
                    ans = ans / inputDouble;
                    break;
                case NO_OPERATOR:
                    ans = Double.parseDouble(input);
                    break;
                default:
                    throw new IllegalArgumentException("operator is invalid: " + operator);
            }
        }
        input = "";
        operator = NO_OPERATOR;
        setDisplayText(Double.toString(ans));
    }

    private void setDisplayText(String value) {
        display.setText(value);
    }

    private void resetDefaultValues(){
        input = "";
        ans = null;
        operator = NO_OPERATOR;
        setDisplayText("0");
    }
}
