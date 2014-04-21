package com.claydonkey.ObserverPattern;

import static java.lang.System.*;


class ListeningObject {

    Listener Click;
    Listener KeyUp;

    public ListeningObject() {
        Click = new Listener();
        KeyUp = new Listener();
    }

    protected void OnClick(EventArgs e) {
        Click.update(this, e);
    }

    protected void OnKeyUp(EventArgs e) {
        KeyUp.update(this, e);
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
        });
        m.OnClick(new MyEventArgs(" MyEventArgs: Event Args"));
        m.OnKeyUp(new MyEventArgs(" MyEventArgs: Event Args"));

    }

}
