package com.thepinkandroid.rxjavaconcepts.views;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.thepinkandroid.rxjavaconcepts.R;
import com.thepinkandroid.rxjavaconcepts.controllers.EventsManager;
import com.thepinkandroid.rxjavaconcepts.controllers.LogicManager;
import com.thepinkandroid.rxjavaconcepts.models.Action;
import com.thepinkandroid.rxjavaconcepts.models.DataToCalculate;
import com.thepinkandroid.rxjavaconcepts.models.DataToPresent;

import rx.Observer;


public class MainActivity extends AppCompatActivity implements Observer<DataToPresent>{

    private TextView mPlusResult;
    private TextView mMinusResult;
    private TextView mMultipleResult;
    private TextView mDivideResult;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        setViews();
        EventsManager.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        EventsManager.getInstance().unregister(this);
        // Unsubscription if needed
        LogicManager.getInstance().unSubscribe();
        super.onDestroy();
    }

    private void setViews() {
        setPlusViews();
        setMinusViews();
        setMultipleViews();
        setDivideViews();
    }

    private void setPlusViews() {
        final EditText editTextInput1 = (EditText) findViewById(R.id.editTextPlusInput1);
        final EditText editTextInput2 = (EditText) findViewById(R.id.editTextPlusInput2);
        mPlusResult = (TextView) findViewById(R.id.textViewPlusResult);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input1 = editTextInput1.getText().toString();
                String input2 = editTextInput2.getText().toString();

                if (!TextUtils.isEmpty(input1) && !TextUtils.isEmpty(input2)) {
                    DataToCalculate dataToCalculate = new DataToCalculate(Action.PLUS);
                    dataToCalculate.addValue(Integer.valueOf(input1));
                    dataToCalculate.addValue(Integer.valueOf(input2));
                    LogicManager.getInstance().runLogic(dataToCalculate, (Observer<DataToPresent>) mContext);
                } else {
                    mPlusResult.setText("0");
                }
            }
        };

        editTextInput1.addTextChangedListener(textWatcher);
        editTextInput2.addTextChangedListener(textWatcher);
    }

    private void setMinusViews() {
        final EditText editTextInput1 = (EditText) findViewById(R.id.editTextMinusInput1);
        final EditText editTextInput2 = (EditText) findViewById(R.id.editTextMinusInput2);
        mMinusResult = (TextView) findViewById(R.id.textViewMinusResult);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input1 = editTextInput1.getText().toString();
                String input2 = editTextInput2.getText().toString();

                if (!TextUtils.isEmpty(input1) && !TextUtils.isEmpty(input2)) {
                    DataToCalculate dataToCalculate = new DataToCalculate(Action.MINUS);
                    dataToCalculate.addValue(Integer.valueOf(input1));
                    dataToCalculate.addValue(Integer.valueOf(input2));
                    LogicManager.getInstance().runLogic(dataToCalculate, (Observer<DataToPresent>) mContext);
                } else {
                    mMinusResult.setText("0");
                }
            }
        };

        editTextInput1.addTextChangedListener(textWatcher);
        editTextInput2.addTextChangedListener(textWatcher);
    }

    private void setMultipleViews() {
        final EditText editTextInput1 = (EditText) findViewById(R.id.editTextMultipleInput1);
        final EditText editTextInput2 = (EditText) findViewById(R.id.editTextMultipleInput2);
        mMultipleResult = (TextView) findViewById(R.id.textViewMultipleResult);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input1 = editTextInput1.getText().toString();
                String input2 = editTextInput2.getText().toString();

                if (!TextUtils.isEmpty(input1) && !TextUtils.isEmpty(input2)) {
                    DataToCalculate dataToCalculate = new DataToCalculate(Action.MULTIPLE);
                    dataToCalculate.addValue(Integer.valueOf(input1));
                    dataToCalculate.addValue(Integer.valueOf(input2));
                    LogicManager.getInstance().runLogic(dataToCalculate, (Observer<DataToPresent>)mContext);
                } else {
                    mMultipleResult.setText("0");
                }
            }
        };

        editTextInput1.addTextChangedListener(textWatcher);
        editTextInput2.addTextChangedListener(textWatcher);
    }

    private void setDivideViews() {
        final EditText editTextInput1 = (EditText) findViewById(R.id.editTextDivideInput1);
        final EditText editTextInput2 = (EditText) findViewById(R.id.editTextDivideInput2);
        mDivideResult = (TextView) findViewById(R.id.textViewDivideResult);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input1 = editTextInput1.getText().toString();
                String input2 = editTextInput2.getText().toString();

                if (!TextUtils.isEmpty(input1) && !TextUtils.isEmpty(input2)) {
                    DataToCalculate dataToCalculate = new DataToCalculate(Action.DIVIDE);
                    dataToCalculate.addValue(Integer.valueOf(input1));
                    dataToCalculate.addValue(Integer.valueOf(input2));
                    LogicManager.getInstance().runLogic(dataToCalculate,(Observer<DataToPresent>)mContext);
                } else {
                    mDivideResult.setText("0");
                }
            }
        };

        editTextInput1.addTextChangedListener(textWatcher);
        editTextInput2.addTextChangedListener(textWatcher);
    }

    @Override
    public void onCompleted() {
        // Do nothing
    }

    @Override
    public void onError(Throwable e) {
        Snackbar.make(mPlusResult, R.string.error_in_calculation, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(DataToPresent dataToPresent) {
        // Update the UI component after a result is ready
        if(dataToPresent.isLegit())
        {
            switch (dataToPresent.getAction()) {
                case PLUS:
                    mPlusResult.setText(String.valueOf(dataToPresent.getResult()));
                    break;
                case MINUS:
                    mMinusResult.setText(String.valueOf(dataToPresent.getResult()));
                    break;
                case MULTIPLE:
                    mMultipleResult.setText(String.valueOf(dataToPresent.getResult()));
                    break;
                case DIVIDE:
                    mDivideResult.setText(String.valueOf(dataToPresent.getResult()));
                    break;
            }
        }
        else
        {
            Snackbar.make(mPlusResult, R.string.error_in_calculation, Snackbar.LENGTH_SHORT).show();
        }
    }
}
