package com.claydonkey.ObserverPattern;

// Event source

import java.util.ArrayList;
import java.util.ListIterator;

class Listener {  //Same as Observable and Listener objects in the Observer Design Pattern

    protected ArrayList _listeners;

    public void addEventHandler(IEventHandler eventhandler) {
        if (_listeners == null) {
            _listeners = new ArrayList();
        }
        _listeners.add(eventhandler);
    }

    protected void update(Object o, EventArgs e) {
        if (_listeners != null & !_listeners.isEmpty()) {
            ListIterator itr = _listeners.listIterator();
            while (itr.hasNext()) {
                EventHandler eventhandler = (EventHandler) itr.next();
                eventhandler.OnEvent(o, e);
            }
        }
    }
}