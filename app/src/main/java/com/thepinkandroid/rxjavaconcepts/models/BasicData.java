package com.thepinkandroid.rxjavaconcepts.models;

/**
 * Created by davidbeloosesky on 09/10/2016.
 */

public abstract class BasicData {
    protected Action mAction;

    public BasicData(Action action) {
        mAction = action;
    }

    public void setAction(Action action) {
        mAction = action;
    }

    public Action getAction() {
        return mAction;
    }
}
