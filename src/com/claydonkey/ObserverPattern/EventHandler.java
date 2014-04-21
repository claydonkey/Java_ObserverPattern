/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.claydonkey.ObserverPattern;

interface IEventHandler {

    public void OnEvent(Object s, EventArgs e);
}

abstract class EventHandler implements IEventHandler { }// This is analogous to a FUNCTOR or A DELEGATE in the CLI

   

