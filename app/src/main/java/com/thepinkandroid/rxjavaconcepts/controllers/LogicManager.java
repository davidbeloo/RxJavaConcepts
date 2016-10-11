package com.thepinkandroid.rxjavaconcepts.controllers;

import com.thepinkandroid.rxjavaconcepts.models.DataToCalculate;
import com.thepinkandroid.rxjavaconcepts.models.DataToPresent;

import rx.Observer;

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

    public void runLogic(DataToCalculate dataToCalculate, Observer<DataToPresent> observer) {
        AsyncManager.getInstance().calculateResult(dataToCalculate, observer);
    }


    public void unSubscribe() {
        AsyncManager.getInstance().unSubscribe();
    }
}
