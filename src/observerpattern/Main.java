package observerpattern;

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.ListIterator;

class EventArgs {
}

class MyEventArgs extends EventArgs {

    public MyEventArgs(String str) {
        message = str;
    }
    public String message;
}

interface IEventHandler {

    public void OnEvent(Object sender, EventArgs e);
}

abstract class EventHandler implements IEventHandler {

    EventHandler() {
    }

    EventHandler(EventArgs args) {
        _args = args;
    }
    EventArgs _args;

}

// Event source
class Listener {

    private Object _obj;

    public Listener(Object obj) {
        this._obj = obj;
    }

    protected ArrayList _listeners;

    public void addEventHandler(IEventHandler eventhandler) {
        if (_listeners == null) {
            _listeners = new ArrayList();
        }
        _listeners.add(eventhandler);
    }

    protected void update() {
        if (_listeners != null & !_listeners.isEmpty()) {
            ListIterator itr = _listeners.listIterator();
            while (itr.hasNext()) {
                EventHandler eventhandler = (EventHandler) itr.next();
                eventhandler.OnEvent(_obj, eventhandler._args);
            }
        }
    }
}

abstract class ClickEventHandler extends EventHandler {

    ClickEventHandler(EventArgs args) {
        super(args);
    }

}

class ListeningObject {

    Listener ClickEventListener;
    Listener KeyUpEventListener;

    public ListeningObject() {
        ClickEventListener = new Listener(this);
        KeyUpEventListener = new Listener(this);
    }

    protected void Click() {
        ClickEventListener.update();
    }

    protected void KeyUp() {
        KeyUpEventListener.update();
    }

}

public class Main {

    public static void main(String[] args) {

        IEventHandler clickhandler = new ClickEventHandler(new MyEventArgs("MyEventArgs: Event Args")) {
            @Override
            public void OnEvent(Object sender, EventArgs e) {
                out.println("CLICK " + ((MyEventArgs) e).message);
            }
        };

        IEventHandler clickhandler2 = new ClickEventHandler(new MyEventArgs("MyEventArgs: Event Args")) {
            @Override
            public void OnEvent(Object sender, EventArgs e) {
                out.println("CLICK 2 " + ((MyEventArgs) e).message);
            }
        };

        IEventHandler keyuphandler = new EventHandler() {
            @Override
            public void OnEvent(Object sender, EventArgs e) {
                out.println("KEY UP");
            }
        };

        ListeningObject m = new ListeningObject();

        m.ClickEventListener.addEventHandler(clickhandler);
        m.ClickEventListener.addEventHandler(clickhandler2);
        m.KeyUpEventListener.addEventHandler(keyuphandler);

        m.Click();
        m.KeyUp();

    }

}
