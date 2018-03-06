/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.be;

/**
 *
 * @author Mape
 */
public class Message {
    
    private int id;
    private String text;

    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }
    
    public Message(String text) {
        
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
