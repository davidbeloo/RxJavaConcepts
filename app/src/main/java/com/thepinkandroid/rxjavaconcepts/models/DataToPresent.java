package com.thepinkandroid.rxjavaconcepts.models;

import java.util.ArrayList;

/**
 * Created by davidbeloosesky on 09/10/2016.
 */

public class DataToPresent extends BasicData{

    private boolean mIsErrorOccurred = false;
    private Float mResult;

    public DataToPresent(Action action, Float result, boolean isErrorOccurred) {
        super(action);
        mResult = result;
        mIsErrorOccurred = isErrorOccurred;
    }

    public Float getResult() {
        return mResult;
    }

    public boolean isLegit() {
        return !mIsErrorOccurred;
    }
}
