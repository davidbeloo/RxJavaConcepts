package com.thepinkandroid.rxjavaconcepts.interfaces;

import com.thepinkandroid.rxjavaconcepts.models.DataToPresent;

/**
 * Created by davidbeloosesky on 09/10/2016.
 */

public interface CalculateListener {
    void onSuccess(DataToPresent dataToPresent);
    void onFailed();
}

