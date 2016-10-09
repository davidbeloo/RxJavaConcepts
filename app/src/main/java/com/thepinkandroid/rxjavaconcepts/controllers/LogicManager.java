package com.thepinkandroid.rxjavaconcepts.controllers;

import android.text.TextUtils;
import android.util.Log;

import com.thepinkandroid.rxjavaconcepts.interfaces.CalculateListener;
import com.thepinkandroid.rxjavaconcepts.models.DataToCalculate;
import com.thepinkandroid.rxjavaconcepts.models.DataToPresent;

import rx.subjects.Subject;

/**
 * Created by davidbeloosesky on 09/10/2016.
 */
public class LogicManager {
    private static LogicManager msInstance = new LogicManager();


    public static LogicManager getInstance() {
        return msInstance;
    }

    private LogicManager() {

    }

    public void runLogic(DataToCalculate dataToCalculate) {
        AsyncManager.getInstance().calculateResult(dataToCalculate, new CalculateListener() {
            @Override
            public void onSuccess(DataToPresent dataToPresent) {
                notifyListeners(dataToPresent);
            }

            @Override
            public void onFailed() {
                Log.e(LogicManager.class.getSimpleName(), "Calculation error");
            }
        });
    }

    private void notifyListeners(DataToPresent dataToPresent) {
        EventsManager.getInstance().post(dataToPresent);
    }
}
