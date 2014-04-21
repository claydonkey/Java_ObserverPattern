package observerpattern;

import static java.lang.System.*;
import java.util.ArrayList;
import java.util.ListIterator;

class EventArgs {}

class MyEventArgs extends EventArgs {

    public MyEventArgs(String str) {
        message = str;
    }
    public String message;
}

interface IEventHandler {

    public void OnEvent(Object s, EventArgs e);
}

abstract class EventHandler implements IEventHandler { // This is analogous to a FUNCTOR or A DELEGATE in the CLI

    EventHandler() {}
}

// Event source
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

class ListeningObject {

    Listener Click;
    Listener KeyUp;

    public ListeningObject() {
        Click = new Listener();
        KeyUp = new Listener();
    }

    protected void OnClick(EventArgs e) {
        Click.update(this,e);
    }

    protected void OnKeyUp(EventArgs e) {
       KeyUp.update(this,e);
    }

}

public class Main {
 IEventHandler ListeningObject_Click1 = new EventHandler() {
            @Override
            public void OnEvent(Object s, EventArgs e) {
                out.println(s.toString() + " CLICK " + ((MyEventArgs) e).message);
            }
        };

        IEventHandler ListeningObject_Click2 = new EventHandler() {
            @Override
            public void OnEvent(Object s, EventArgs e) {
                out.println(s.toString() + " CLICK 2 " + ((MyEventArgs) e).message);
            }
        };

        IEventHandler ListeningObject_KeyUp = new EventHandler() {
            @Override
            public void OnEvent(Object s, EventArgs e) {
                out.println(s.toString() + " KEY UP ");
            }
        };
    public static void main(String[] args) {

        
        //HERE THE FUNCTOR has been used for an anonomous method - much like a lambda in the CLI
        IEventHandler ListeningObject_Click1 = new EventHandler() {
            @Override
            public void OnEvent(Object s, EventArgs e) {
                out.println(s.toString() + " CLICK " + ((MyEventArgs) e).message);
            }
        };

        IEventHandler ListeningObject_Click2 = new EventHandler() {
            @Override
            public void OnEvent(Object s, EventArgs e) {
                out.println(s.toString() + " CLICK 2 " + ((MyEventArgs) e).message);
            }
        };

        IEventHandler ListeningObject_KeyUp = new EventHandler() {
            @Override
            public void OnEvent(Object s, EventArgs e) {
                out.println(s.toString() + " KEY UP ");
            }
        };

        ListeningObject m = new ListeningObject();
        m.Click.addEventHandler(ListeningObject_Click1); // Analogous to  m.OnClick += 
        m.Click.addEventHandler(ListeningObject_Click2);
        m.KeyUp.addEventHandler(ListeningObject_KeyUp);
        
          m.KeyUp.addEventHandler(new EventHandler() {
            @Override
            public void OnEvent(Object s, EventArgs e) {
                out.println(s.toString() + " CLICK 2 " + ((MyEventArgs) e).message);
            }
          }         );
        m.OnClick(new MyEventArgs(" MyEventArgs: Event Args"));
        m.OnKeyUp(new MyEventArgs(" MyEventArgs: Event Args"));

    }

}
