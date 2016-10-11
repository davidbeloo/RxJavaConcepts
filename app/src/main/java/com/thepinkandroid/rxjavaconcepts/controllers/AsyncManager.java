package com.thepinkandroid.rxjavaconcepts.controllers;

import com.thepinkandroid.rxjavaconcepts.models.DataToCalculate;
import com.thepinkandroid.rxjavaconcepts.models.DataToPresent;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.subjects.Subject;

/**
 * Created by davidbeloosesky on 09/10/2016.
 */
public class AsyncManager {
    private static AsyncManager msInstance = new AsyncManager();
    private Subject<DataToCalculate, Integer> mSubject;
    private Observer<DataToPresent> mUIObserver;
    private Subscription mObserverSubscription;


    public static AsyncManager getInstance() {
        return msInstance;
    }

    private AsyncManager() {
        initialize();
    }

    public void calculateResult(DataToCalculate dataToCalculate, Observer<DataToPresent> observer) {
        mUIObserver = observer;
        mSubject.onNext(dataToCalculate);
    }
    
    private void initialize() {

        mSubject = new Subject<DataToCalculate, Integer>(null) {
            @Override
            public boolean hasObservers() {
                return false;
            }

            @Override
            public void onCompleted() {
                // Called when the observable has no more data to emit
            }

            @Override
            public void onError(Throwable e) {
                // Called when the observable encounters an error
                DataToPresent result = new DataToPresent(null, null, true);
                updateUI(result);
            }

            @Override
            public void onNext(DataToCalculate dataToCalculate) {
                // Called each time the observable emits data
                DataToPresent result = calculate(dataToCalculate);
                updateUI(result);
            }
        };
    }

    private void updateUI(DataToPresent dataToPresent) {
        Observable<DataToPresent> observable = Observable.just(dataToPresent);
        mObserverSubscription = observable.subscribe(mUIObserver);
    }


    private DataToPresent calculate(DataToCalculate dataToCalculate) {
        Float result = Float.valueOf(-1);

        for (Integer value : dataToCalculate.getValues()) {
            switch (dataToCalculate.getAction()) {
                case PLUS:
                    if (result == -1) {
                        result = Float.valueOf(value);
                    } else {
                        result = result + value;
                    }
                    break;
                case MINUS:
                    if (result == -1) {
                        result = Float.valueOf(value);
                    } else {
                        result = result - value;
                    }
                    break;
                case MULTIPLE:
                    if (result == -1) {
                        result = Float.valueOf(value);
                    } else {
                        result = result * value;
                    }
                    break;
                case DIVIDE:
                    if (result == -1) {
                        result = Float.valueOf(value);
                    } else {
                        result = result / value;
                    }

                    break;
            }
        }

        return new DataToPresent(dataToCalculate.getAction(), result, false);
    }

    public void unSubscribe() {
        if (mObserverSubscription != null && !mObserverSubscription.isUnsubscribed()) {
            mObserverSubscription.unsubscribe();
        }
    }
}
