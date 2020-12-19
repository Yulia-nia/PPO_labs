package com.example.labka3;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.example.labka3.calculator.EngineerCalculator;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    TextView textView = (TextView) null;
    EngineerCalculator calculator = null;
    LinkedList<Button> digits = new LinkedList<>();
    LinkedList<Button> operations = new LinkedList<>();
    Button delButton;
    Button equalButton;
    Button changeButton;
    Button dotButton;
    Button stepToEngineer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textField);
        calculator = EngineerCalculator.getCalc();
        textView.setText(calculator.getNumber());
        createViews();
        setListeners();
    }

    private void clickDelOperation() {
        textView.setText(calculator.deleteDigit());
    }

    private void clickNumber(String digit) {
        textView.setText(calculator.addDigit(digit));
    }

    private void clickOperation(String operation) {
        if (calculator.getNumber().length() > 0) {
            if (calculator.setOperation(operation)) {
                textView.setText(calculator.getNumber());
            }
        }
    }

    private void clickEqual() {
        if (calculator.getNumber().length() > 0) {
            if (calculator.setEqual()) {
                textView.setText(calculator.getNumber());
            }
        }
    }

    private void clickChangeSign() {
        if (calculator.getNumber().length() > 0) {
            textView.setText(calculator.changeSign());
        }
    }

    private void clickAddDot() {
        if (calculator.getNumber().length() > 0) {
            textView.setText(calculator.addDot());
        }
    }

    private void startEngineerActivity(){
        Intent intent = new Intent(MainActivity.this, EngineerActivity.class);
        startActivity(intent);
    }

    private void createViews() {
        int[] buttonsIds = new int[] {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9
        };

        int[] operationButtonsIds = new int[] {
                R.id.operation_button_plus,
                R.id.operation_button_minus, R.id.operation_button_dup,
                R.id.operation_button_div
        };

        for (int buttonId : buttonsIds) {
            Button b = (Button) findViewById(buttonId);
            digits.add(b);
        }

        for (int buttonId : operationButtonsIds) {
            Button b = (Button) findViewById(buttonId);
            operations.add(b);
        }

        delButton = (Button) findViewById(R.id.operation_button_del);
        equalButton = (Button) findViewById(R.id.operation_button_equal);
        changeButton = (Button) findViewById(R.id.operation_button_change);
        dotButton= (Button) findViewById(R.id.operation_button_dot);
        stepToEngineer = (Button) findViewById(R.id.stepToEngineer);
    }

    private void setListeners() {
        OnClickListener onClickBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNumber(String.valueOf(((Button) v).getText()));
            }
        };
        OnClickListener onClickOperationBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOperation(String.valueOf(((Button) v).getText()));
            }
        };
        OnClickListener onClickDelBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDelOperation();
            }
        };
        OnClickListener onClickEqualBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEqual();
            }
        };
        OnClickListener onClickChangeBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChangeSign();
            }
        };
        OnClickListener onClickStepBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                startEngineerActivity();
            }
        };

        for (Button button : digits) {
            button.setOnClickListener(onClickBtn);
        }
        for (Button button : operations) {
            button.setOnClickListener(onClickOperationBtn);
        }
        delButton.setOnClickListener(onClickDelBtn);
        equalButton.setOnClickListener(onClickEqualBtn);
        changeButton.setOnClickListener(onClickChangeBtn);
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAddDot();
            }
        });
        stepToEngineer.setOnClickListener(onClickStepBtn);
    }
}