/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.gui.model;

import com.message.be.Message;
import com.message.bll.BLLManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mape
 */
public class MessageModel {

    public MessageModel() {
        allMessages.addAll(BLLManager.getBLLManagerInstance().getMessages());
    }
    
   
    
    
    private ObservableList<Message> allMessages = FXCollections.observableArrayList();

    public ObservableList<Message> getAllMessages() {
        
        return allMessages;
    }

    public Message sendMessage(String text) {
        Message m  = BLLManager.getBLLManagerInstance().logMessage(text);
        allMessages.add(m);
        return m;
        
    }
    
    
    
}
