/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.bll;

import com.message.be.Message;
import com.message.dal.ConnectionModel;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mape
 */
public class BLLManager implements IMechaChatLogicFacade {

    private BLLManager() {
    }
    
    private static BLLManager BLLInstance = null;
  
    
    ConnectionModel cm = new ConnectionModel();
    
    @Override
    public Message logMessage(String text) {
        Message message = new Message(text);
        return cm.addMessage(message);
    }

    @Override
    public List<Message> getMessages() {
        return cm.getMessages();
    }
    
    public static BLLManager getBLLManagerInstance() {
        if (BLLInstance == null) {
            BLLInstance = new BLLManager();
            
        }
        return BLLInstance;
    }

    
    
}
