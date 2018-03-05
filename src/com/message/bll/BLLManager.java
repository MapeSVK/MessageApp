/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.bll;

import com.message.be.Message;
import com.message.dal.ConnectionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mape
 */
public class BLLManager implements IMechaChatLogicFacade {

    private ObservableList<Message> allMessages = FXCollections.observableArrayList();
  
    
    ConnectionModel cm = new ConnectionModel();
    
    @Override
    public Message logMessage(String msg) {
        Message message = new Message(-1,msg);
        return cm.addMessage(message);
    }

    
    
}
