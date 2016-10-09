package com.thepinkandroid.rxjavaconcepts.controllers;

import com.squareup.otto.Bus;

/**
 * Created by davidbeloosesky on 09/10/2016.
 */
public class EventsManager {
    private static EventsManager msInstance = new EventsManager();
    private Bus mBus = new Bus();

    public static EventsManager getInstance() {
        return msInstance;
    }

    private EventsManager() {
    }

    public void post(Object object)
    {
        mBus.post(object);
    }

    public void register(Object object)
    {
        mBus.register(object);
    }

    public void unregister(Object object)
    {
        mBus.unregister(object);
    }
}
