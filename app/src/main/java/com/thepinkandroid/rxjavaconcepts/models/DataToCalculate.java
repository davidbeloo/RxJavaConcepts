package com.thepinkandroid.rxjavaconcepts.models;

import java.util.ArrayList;

/**
 * Created by davidbeloosesky on 09/10/2016.
 */

public class DataToCalculate extends BasicData{

    private ArrayList<Integer> mValues = new ArrayList<>();

    public DataToCalculate(Action action) {
        super(action);
    }

    public void addValue(Integer value)
    {
        mValues.add(value);
    }

    public ArrayList<Integer> getValues() {
        return mValues;
    }
}
