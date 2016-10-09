package com.thepinkandroid.rxjavaconcepts.models;

import java.util.ArrayList;

/**
 * Created by davidbeloosesky on 09/10/2016.
 */

public class DataToPresent extends BasicData{

    private Float mResult;

    public DataToPresent(Action action, Float result) {
        super(action);
        mResult = result;
    }

    public Float getResult() {
        return mResult;
    }
}
